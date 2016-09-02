package com.hiyond.dubbo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hiyond on 2016/9/2.
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        String[] classPaths = {"applicationProvider.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classPaths);
        context.start();
        System.out.println("服务消费者启动");
        System.in.read();
    }
}
