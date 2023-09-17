package com.dylan.rbac.common.controller;

import com.dylan.rbac.common.log.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseController implements Loggable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Logger getLogger() {
        return logger;
    }


}
