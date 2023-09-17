package com.dylan.rbac.common.util;

import com.dylan.rbac.common.Result;
import com.dylan.rbac.common.function.Action0;
import com.dylan.rbac.common.function.Func0;
import com.dylan.rbac.common.log.Loggable;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;

public abstract class ResultUtil {
    public static <T> Result<T> invoke(Loggable loggable, HttpServletRequest httpServletRequest, Func0<T> handler){
        Logger logger = loggable.getLogger();
        return Result.success("请求成功", handler.apply());
    }

    public static <T> Result<T> invoke(Loggable loggable, HttpServletRequest httpServletRequest,
                                       Action0 validator, Func0<T> handler){
        Logger logger = loggable.getLogger();
        try {
            validator.apply();
        } catch (Exception e){
            logger.debug("出现异常：{}", e.getMessage());
        }
        return Result.success("请求成功", handler.apply());
    }



}
