package com.nirvana.boot.common.enums;

/**
 * 全局返回结果枚举.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:46
 */
public enum ResultEnum implements IEnum {

    SUCCESS("0", "成功"),

    /**
     * 全局默认异常类
     */
    EXCEPTION_BUSINESS("100100", "业务异常"),

    EXCEPTION_UNKWOWN("100200", "服务繁忙，请稍后再试"),

    EXCEPTION_BS("100300", "系统基础服务异常"),

    EXCEPTION_RPC("100400", "远程服务调用异常"),

    EXCEPTION_CACHE("100500", "缓存服务异常"),

    EXCEPTION_PARAMS("100600", "参数错误"),

    EXCEPTION_INVALIDE_REQ("100700", "无效的请求"),

    EXCEPTION_SECURITY("100900", "安全错误"),
    ;




    private String key;
    private String value;

    private ResultEnum(String key, String value) {
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
