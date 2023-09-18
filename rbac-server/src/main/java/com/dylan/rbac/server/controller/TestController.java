package com.dylan.rbac.server.controller;

import com.dylan.rbac.api.TestService;
import com.dylan.rbac.common.Result;
import com.dylan.rbac.common.constant.ResultCode;
import com.dylan.rbac.common.controller.BaseController;
import com.dylan.rbac.common.exception.ServiceException;
import com.dylan.rbac.common.util.ResultUtil;
import com.dylan.rbac.common.enums.AccessErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @GetMapping("/test1")
    public Result<String> test1(HttpServletRequest request) {
        return ResultUtil.invoke(this, request, () -> {
            throw new ServiceException(AccessErrorEnum.UNAUTHENTICATED);
        }, () -> testService.test());
    }


    @GetMapping("/test3")
    public Result<String> test3(HttpServletRequest request) {
        return ResultUtil.invoke(this, request, () -> {
            throw new ServiceException(ResultCode.UNKNOWN_ERROR, "test3抛出的未知异常");
//            testService.test();
        });
    }

    @GetMapping("/test4")
    public Result<String> test4(HttpServletRequest request) {
        return ResultUtil.invoke(this, request, () -> {
            throw new ServiceException(AccessErrorEnum.USERNAME_NOT_EXIST);
//            testService.test();
        });
    }


}

