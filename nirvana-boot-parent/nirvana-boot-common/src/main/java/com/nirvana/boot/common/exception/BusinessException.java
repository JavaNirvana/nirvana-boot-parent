package com.nirvana.boot.common.exception;

import com.nirvana.boot.common.enums.IEnum;

import java.io.Serializable;

/**
 * 业务异常.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:38
 */
public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1635893439466394446L;

    private String errorCode;

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BusinessException(String errorCode, String cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BusinessException(IEnum enums) {
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
