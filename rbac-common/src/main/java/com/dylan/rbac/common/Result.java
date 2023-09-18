package com.dylan.rbac.common;


import com.dylan.rbac.common.constant.ResultCode;
import com.dylan.rbac.common.enums.base.ErrorBaseEnum;
import com.dylan.rbac.common.util.I18nUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Locale;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 7614403254053502838L;

    private int code;
    private String msg;
    private T data;

    /**
     * 成功[ (data), (msg, data) ]
     */
    public static <T> Result<T> success(T data){
        return success(ResultCode.SUCCESS, null, data);
    }

    public static <T> Result<T> success(String msg, T data){
        return success(ResultCode.SUCCESS, msg, data);
    }

    public static <T> Result<T> success(int code, String msg, T data){
        return new Result<>(code, msg, data);
    }

    /**
     * 失败[ (msg), (code, msg) ]
     */
    public static <T> Result<T> error(String msg){
        return error(ResultCode.UNKNOWN_ERROR, msg, null);
    }

    public static <T> Result<T> error(int code, String msg){
        return error(code, msg, null);
    }

    public static <T> Result<T> error(int code, String msg, T data){
        return new Result<>(code, msg, data);
    }

    /**
     * 根据Locale生成特定的code和msg
     */
    public static <T> Result<T> error(ErrorBaseEnum errorBaseEnum, Locale locale){
        return error(errorBaseEnum.code(), I18nUtil.getMessage(errorBaseEnum, locale));
    }

}
