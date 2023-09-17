package com.dylan.rbac.common.exception;

import com.dylan.rbac.common.enums.ErrorBaseEnum;

public class ServiceException extends RuntimeException{
    private final ErrorBaseEnum errorBaseEnum;

    public ServiceException(ErrorBaseEnum errorBaseEnum) {
        super(errorBaseEnum.message());
        this.errorBaseEnum = errorBaseEnum;
    }


}
