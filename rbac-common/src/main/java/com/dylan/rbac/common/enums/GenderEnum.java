package com.dylan.rbac.common.enums;

import com.dylan.rbac.common.enums.base.BaseEnum;

/**
 * 性别枚举类
 */
public enum GenderEnum implements BaseEnum {

    MALE(0, "男"),
    FEMALE(1, "女");

    private final int code;
    private final String description;

    GenderEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

}
