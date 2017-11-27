
package com.nirvana.boot.user.enums;

import com.nirvana.boot.common.enums.IEnum;

/**
 * 消息枚举.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/27 13:52
 */
public enum MsgEnum implements IEnum {

    SUCCESS("0", "成功"),

    INSERT_DATA_ERROR("900001", "插入数据异常"),
    QUERY_DATA_ERROR("900002", "查询数据异常"),
    ;




    private String key;
    private String value;

    private MsgEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
