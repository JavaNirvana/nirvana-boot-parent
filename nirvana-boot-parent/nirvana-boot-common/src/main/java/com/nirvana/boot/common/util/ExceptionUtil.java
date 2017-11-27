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

import com.nirvana.boot.common.base.ServiceResponse;
import com.nirvana.boot.common.enums.ResultEnum;
import com.nirvana.boot.common.exception.BusinessException;
import com.nirvana.boot.common.exception.ParameterInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常处理工具类.
 *
 * @author lipw
 * @version 1.0
 * @date 2016/12/19 10:43
 */
public class ExceptionUtil {

    private static Logger LOG = LoggerFactory.getLogger(ExceptionUtil.class);

    /**
     * 异常处理
     * @param e
     * @return
     */
    public static <T> ServiceResponse<T> handleException2Response(Exception e){
        ServiceResponse<T> serviceResponse = new ServiceResponse<T>();
        if (e instanceof ParameterInvalidException) {
            ParameterInvalidException t = (ParameterInvalidException) e;
            serviceResponse.setCode(t.getErrorCode());
            serviceResponse.setMsg(t.getMessage());
        } else if (e instanceof BusinessException) {
            BusinessException t = (BusinessException) e;
            serviceResponse.setCode(t.getErrorCode());
            serviceResponse.setMsg(t.getMessage());
        } else {
            serviceResponse.setCode(ResultEnum.EXCEPTION_UNKWOWN.getKey());
            serviceResponse.setMsg(ResultEnum.EXCEPTION_UNKWOWN.getValue());
        }
        LOG.error(">>> ExceptionUtil >>> 错误代码[%s],错误信息[%s]", serviceResponse.getCode(), serviceResponse.getMsg(), e);

        return serviceResponse;
    }
}
