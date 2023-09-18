package com.dylan.rbac.common.util;

import com.dylan.rbac.common.enums.base.ErrorBaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.Locale;

public abstract class I18nUtil {


    public static String getMessage(ErrorBaseEnum errorBaseEnum, Locale locale){
        return errorBaseEnum.message();
    }

    public static void main(String[] args) {

    }


}
