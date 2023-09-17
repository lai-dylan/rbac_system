package com.dylan.rbac.server.controller;

import com.dylan.rbac.api.TestService;
import com.dylan.rbac.common.Result;
import com.dylan.rbac.common.controller.BaseController;
import com.dylan.rbac.common.util.ResultUtil;
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
    public Result test1(HttpServletRequest request) {
        return ResultUtil.invoke(this, request, () -> {
            throw new RuntimeException("error");
        }, () -> testService.test());
    }

    @GetMapping("/test2")
    public Result test2(HttpServletRequest request) {
        return ResultUtil.invoke(this, request, () -> testService.test());
    }


}

