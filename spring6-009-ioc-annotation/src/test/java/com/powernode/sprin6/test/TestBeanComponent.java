package com.powernode.sprin6.test;

import com.powernode.spring6.SpringConfig;
import com.powernode.spring6.bean.Order;
import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import com.powernode.spring6.bean3.MyDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestBeanComponent
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/2 15:57
 * @Version 1.0
 **/
public class TestBeanComponent {
    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
    }

    @Test
    public void testValue(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testComponent2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

}
