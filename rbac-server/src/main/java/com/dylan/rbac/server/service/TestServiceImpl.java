package com.dylan.rbac.server.service;

import com.dylan.rbac.api.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "test";
    }

}
