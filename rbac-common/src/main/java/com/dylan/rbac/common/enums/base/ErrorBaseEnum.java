package com.dylan.rbac.common.enums.base;

/**
 * 错误枚举类基接口，错误枚举类都要实现此接口
 */
public interface ErrorBaseEnum {
    /**
     * 错误码
     */
    int code();

    /**
     * 枚举类名
     */
    String name();

    /**
     * 错误原因
     */
    String cause();

    /**
     * 解决方案
     */
    String solution();

    /**
     * 错误原因 + 解决方案
     */
    default String message(){
        return cause() + ", " + solution();
    }

}
