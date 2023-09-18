package com.dylan.rbac.common.exception;

import com.dylan.rbac.common.enums.base.ErrorBaseEnum;

/**
 * 通过获取错误枚举类，来获取code和msg
 * 或者获取自己传入的code
 */
public class ServiceException extends RuntimeException{
    private ErrorBaseEnum errorBaseEnum;
    private int code;

    public ServiceException(ErrorBaseEnum errorBaseEnum) {
        super(errorBaseEnum.message());
        this.errorBaseEnum = errorBaseEnum;
    }

    public ServiceException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public ErrorBaseEnum getErrorBaseEnum() {
        return errorBaseEnum;
    }

    public int getCode() {
        return code;
    }
}
