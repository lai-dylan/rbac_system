package com.dylan.rbac.common.util;

import java.util.UUID;

public abstract class IdGeneratorUtil {

    public static String UUId32Generate(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "个：");
            System.out.println(UUId32Generate() + "\n");
        }
    }

}
