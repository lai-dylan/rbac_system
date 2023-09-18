package com.dylan.rbac.common.test;

import com.dylan.rbac.common.enums.base.ErrorBaseEnum;

public class ErrorBaseEnumTest implements ErrorBaseEnum {
    @Override
    public int code() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String cause() {
        return null;
    }

    @Override
    public String solution() {
        return null;
    }

    public static void main(String[] args) {
        ErrorBaseEnum errorBaseEnum = new ErrorBaseEnumTest();
        System.out.println(errorBaseEnum.message());
    }
}
