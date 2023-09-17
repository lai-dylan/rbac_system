package com.dylan.rbac.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.dylan.rbac.dao")
@SpringBootApplication
public class RbacServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacServerApplication.class, args);
    }

}
