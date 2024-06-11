package com.powernode.test;

import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    @Test
    public void testRegisterBean(){
        // 自己new对象
        Student student = new Student();
        System.out.println(student);

        // 将以上自己new的对象纳入spring容器来管理。半路上交给spring管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean",student);

        // 从spring容器中获取
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }

    @Test
    public void testLifecycle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步：使用Bean：" + user);

        //  注意：必须手动关闭spring容器，这样spring容器才会销毁bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }
}
