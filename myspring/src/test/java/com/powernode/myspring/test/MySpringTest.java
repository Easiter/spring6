package com.powernode.myspring.test;

import com.powernode.myspring.bean.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

/**
 * @ClassName MySpringTest
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/1 15:33
 * @Version 1.0
 **/
public class MySpringTest {

    @Test
    public void testMySpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");

        Object user = applicationContext.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
