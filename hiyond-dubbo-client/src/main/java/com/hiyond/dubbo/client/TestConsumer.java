package com.hiyond.dubbo.client;

import com.hiyond.dubbo.api.service.UserService;
import com.hiyond.entity.User;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hiyond on 2016/9/2.
 */
public class TestConsumer {

    private static Logger logger = Logger.getLogger(TestConsumer.class);

    public static void main(String[] args) throws Exception {
        String[] classPaths = {"applicationConsumer.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classPaths);
        UserService userService = (UserService) context.getBean("userService_dubbo");
        User user = userService.test("hello");
        System.out.println(user.toString());
        com.hiyond.service.UserService userService1 = (com.hiyond.service.UserService) context.getBean("userService");
        Integer count = userService1.findUserByName("123456");
        System.out.println(count);
        user = new User();
        user.setName("error01");
        user.setPassword("error01");
        userService1.insertUser(user);
//        context.start();
    }
}
