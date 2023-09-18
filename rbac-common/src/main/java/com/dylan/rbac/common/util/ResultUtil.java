package com.dylan.rbac.common.util;

import com.dylan.rbac.common.Result;
import com.dylan.rbac.common.enums.base.ErrorBaseEnum;
import com.dylan.rbac.common.exception.ServiceException;
import com.dylan.rbac.common.function.Action0;
import com.dylan.rbac.common.function.Func0;
import com.dylan.rbac.common.log.Loggable;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;
import java.util.Objects;

public abstract class ResultUtil {

    // （无验证，没有返回值的请求）
    public static <T> Result<T> invoke(Loggable loggable,
                                       HttpServletRequest httpServletRequest,
                                       Action0 businessHandler) {

        return invoke(loggable, httpServletRequest, null, businessHandler);
    }

    // （无验证，有返回值的请求）
    public static <T> Result<T> invoke(Loggable loggable,
                                       HttpServletRequest httpServletRequest,
                                       Func0<T> businessHandler) {

        return invoke(loggable, httpServletRequest, null, businessHandler);
    }

    // （有验证，无返回值的请求）
    public static <T> Result<T> invoke(Loggable loggable,
                                       HttpServletRequest httpServletRequest,
                                       Action0 businessValidator,
                                       Action0 businessHandler) {

        return invoke(loggable, httpServletRequest, businessValidator, (Object) businessHandler);
    }

    // （有验证，有返回值的请求）
    public static <T> Result<T> invoke(Loggable loggable,
                                       HttpServletRequest httpServletRequest,
                                       Action0 businessValidator,
                                       Func0<T> businessHandler) {

        return invoke(loggable, httpServletRequest, businessValidator, (Object) businessHandler);
    }

    // （统一中转，判断businessHandler是否需要返回值）
    public static Result invoke(Loggable loggable,
                                HttpServletRequest httpServletRequest,
                                Action0 businessValidator,
                                Object businessHandler) {

        if (Objects.nonNull(businessValidator)) {
            try {
                businessValidator.apply();
            } catch (ServiceException ex) {
                return doBusinessException(loggable, httpServletRequest, ex);
            }
        }

        try {
            if (businessHandler instanceof Action0) {
                ((Action0) businessHandler).apply();
                return Result.success(null);
            } else if (businessHandler instanceof Func0) {
                Object o = ((Func0) businessHandler).apply();
                return Result.success(o);
            } else {
                // TODO 处理Handler类型不匹配异常
                System.out.println("----------Handler类型不匹配异常----------");
//                throw new RuntimeException("Handler类型不匹配");
                return null;
            }
        } catch (ServiceException ex) {
            ex.printStackTrace();
            return doBusinessException(loggable, httpServletRequest, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            Locale locale = httpServletRequest.getLocale();
            String uri = httpServletRequest.getRequestURI();
            loggable.getLogger().debug("其他异常信息：【{}】, 请求路径:【{}】, 请求Locale: 【{}】 ",
                    ex.getMessage(), uri, locale);
            loggable.getLogger().debug(uri, ex);
            return Result.error("其他错误");
        }

    }

    /**
     * 统一处理所有业务异常，并根据传进的枚举类，打印日志
     * 如果e里面的错误枚举类为空，说明是手动通过ResultCode传入的常量code
     *
     * @param loggable 获取Logger对象
     * @param request  获取Locale对象
     * @param ex       获取错误枚举类
     * @return
     */
    public static Result doBusinessException(Loggable loggable,
                                             HttpServletRequest request,
                                             ServiceException ex) {
        Locale locale = request.getLocale();
        String uri = request.getRequestURI();

        loggable.getLogger().debug("业务逻辑异常信息：【{}】, 请求路径:【{}】, 请求Locale: 【{}】 ",
                ex.getMessage(), uri, locale);

        ErrorBaseEnum errorBaseEnum = ex.getErrorBaseEnum();
        if (Objects.isNull(errorBaseEnum)) {
            return Result.error(ex.getCode(), ex.getMessage());
        } else {
            String message = I18nUtil.getMessage(errorBaseEnum, locale);
            return Result.error(errorBaseEnum.code(), message);
        }

    }

}
