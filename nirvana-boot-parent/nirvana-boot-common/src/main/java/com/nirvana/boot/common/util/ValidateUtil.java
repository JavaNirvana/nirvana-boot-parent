/*************************************************************************
 *                  XIAONIU66 CONFIDENTIAL AND PROPRIETARY                                                      
 *
 *                COPYRIGHT (C) XIAONIU66 CORPORATION 2016                                                      
 *    ALL RIGHTS RESERVED BY XIAONIU66 CORPORATION. THIS PROGRAM    
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY   
 * XIAONIU66 CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN       
 * PERMISSION OF XIAONIU66 CORPORATION. USE OF COPYRIGHT NOTICE   
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.                       
 *                  XIAONIU66 CONFIDENTIAL AND PROPRIETARY        
 *************************************************************************/

package com.nirvana.boot.common.util;

import com.nirvana.boot.common.anno.ValidateProperty;
import com.nirvana.boot.common.enums.ResultEnum;
import com.nirvana.boot.common.exception.ParameterInvalidException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 检查属性工具了.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 18:00
 */
public final class ValidateUtil {
    /**
     * 校验属性
     * @param obj
     * @author lipw
     * @date 2015年9月24日 下午3:52:37
     */
    public static void check(Object obj) throws Exception{
        if(obj == null){
            throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS);
        }
        //获取属性
        Field[] cfields = obj.getClass().getDeclaredFields();
        Field[] pfields = obj.getClass().getSuperclass().getDeclaredFields();

        int len = cfields.length;
        if(pfields != null){
            len += pfields.length;
        }
        Field[] fields = new Field[len];
        System.arraycopy(cfields, 0, fields, 0, cfields.length);
        if(pfields != null){
            System.arraycopy(pfields, 0, fields, cfields.length, pfields.length);
        }
        Field field = null;
        Field.setAccessible(fields, true);
        Object fieldValue = null;
        Integer fValue = null;
        ValidateProperty validate = null;
        String errorMsg = "参数错误";
        Pattern pattern = null;
        for (int i = 0; i < fields.length; i++) {
            field = fields[i];
            validate = field.getAnnotation(ValidateProperty.class);
            if (validate != null) {
                fieldValue = field.get(obj);
                if (StringUtils.isNotBlank(validate.msg())) {
                    errorMsg = validate.msg();
                }
                //校验非空
                if (!validate.nullable()
                        && (fieldValue == null || StringUtils.isBlank(String.valueOf(fieldValue)))) {
                    throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                }
                //校验长度
                if (validate.len() != -1
                        && fieldValue != null
                        && StringUtils.isNotBlank(String.valueOf(fieldValue)) && String.valueOf(fieldValue).length() != validate.len()) {
                    throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                }
                //校验最小长度
                if (validate.min_len() != -1 && fieldValue != null
                        && String.valueOf(fieldValue).length() < validate.min_len()) {
                    throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                }

                try {
                    fValue = Integer.valueOf(String.valueOf(fieldValue));
                } catch (Exception e) { }

                if(fValue != null){
                    //校验最小值
                    if(validate.min_value() != Integer.MIN_VALUE && fValue < validate.min_value()){
                        throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                    }
                    //校验最大值
                    if(validate.max_value() != Integer.MAX_VALUE && fValue > validate.max_value()){
                        throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                    }
                    //校验Int值包含
                    if (validate.int_values() != null
                            && validate.int_values().length > 0
                            && !ArrayUtils.contains(validate.int_values(), fValue)) {
                        throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                    }
                }
                //校验String值包含
                if (validate.str_values() != null
                        && validate.str_values().length > 0
                        && !ArrayUtils.contains(validate.str_values(), String.valueOf(fieldValue))) {
                    throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                }
                //校验最大长度
                if (validate.max_len() != -1 && fieldValue != null
                        && String.valueOf(fieldValue).length() > validate
                        .max_len()) {
                    throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                }
                //执行正则表达式
                if (fieldValue != null && StringUtils.isNotBlank(validate.rule())) {
                    pattern = Pattern.compile(validate.rule());
                    if (!pattern.matcher(String.valueOf(fieldValue)).matches()) {
                        throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                    }
                }
                //校验时间格式
                if (fieldValue != null && StringUtils.isNotBlank(validate.time_rule())
                        && !isValidTime(String.valueOf(fieldValue),
                        validate.time_rule())) {
                    throw new ParameterInvalidException(ResultEnum.EXCEPTION_PARAMS.getKey(), errorMsg + ",字段名:" + field.getName());
                }
            }
        }

    }

    /**
     * 验证时间格式
     * @param time
     * @param format
     * @return
     */
    public static boolean isValidTime(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date parseDate = sdf.parse(time);
            String formatDate = sdf.format(parseDate);
            return formatDate.equals(time);
        } catch (Exception e) {
            return false;
        }
    }
}
