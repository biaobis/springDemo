package com.zhoub.ioc;

public class UserDaoImpl implements UserDao{
    @Override
    public void say() {
        System.out.println("UserDao say Hello World!");
    }

    @Override
    public String getMsg() {
        return "Junit";
    }
}
