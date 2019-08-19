package com.zhoub.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    public static void main(String[] args){
        //初始化Spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取UserDao实例
        UserDao userDao = (UserDao) applicationContext.getBean("UserDao");
        //调用say()方法
        userDao.say();
    }
}
