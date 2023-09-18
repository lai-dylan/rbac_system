package com.dylan.rbac.common.enums;


import com.dylan.rbac.common.enums.base.ErrorBaseEnum;

public enum CommonErrorEnum implements ErrorBaseEnum {

    UNKNOWN_ERROR(-1, "未知错误", "请稍后再试"),

    USERNAME_NOT_EXIST(500, "服务器异常", "请稍后再试");

    private final int code;
    private final String cause;
    private final String solution;

    CommonErrorEnum(int code, String cause, String solution) {
        this.code = code;
        this.cause = cause;
        this.solution = solution;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String cause() {
        return this.cause;
    }

    @Override
    public String solution() {
        return this.solution;
    }
}
