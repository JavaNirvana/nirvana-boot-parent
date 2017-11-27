package com.nirvana.boot.common.exception;

import com.nirvana.boot.common.enums.IEnum;

import java.io.Serializable;

/**
 * 参数错误异常.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 17:53
 */
public class ParameterInvalidException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -4789773002147537392L;

    private String errorCode;

    public ParameterInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterInvalidException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ParameterInvalidException(String errorCode, String cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ParameterInvalidException(IEnum enums) {
        super(enums.getValue());
        this.errorCode = enums.getKey();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
