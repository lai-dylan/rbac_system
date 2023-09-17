package com.dylan.rbac.data.enums;

import com.dylan.rbac.common.enums.ErrorBaseEnum;

/**
 * 登录与权限，错误枚举类
 */
public enum AccessErrorEnum implements ErrorBaseEnum {

    USERNAME_NOT_EXIST(1000, "用户名不存在", "请重新输入"),
    PASSWORD_NOT_CORRECT(1002, "密码不正确", "请重新输入"),
    USERNAME_OR_PASSWORD_NOT_CORRECT(1003, "用户名或密码不正确", "请重新输入"),
    UNAUTHENTICATED(1004, "未登录", "请先登录"),
    UNAUTHORIZED(1005, "权限不足", "请先询问管理员");

    private final int code;
    private final String cause;
    private final String solution;

    AccessErrorEnum(int code, String cause, String solution) {
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
