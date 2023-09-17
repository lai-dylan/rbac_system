package com.dylan.rbac.common.enums;

/**
 * 枚举类基接口，枚举类都要实现此接口
 */
public interface BaseEnum {
    /**
     * 码
     */
    int code();

    /**
     * 枚举类名
     */
    String name();

    /**
     * 枚举类描述
     */
    String description();
}
