package com.powernode.spring.test;

import com.powernode.spring.bean.*;
import com.powernode.spring.dao.UserDao;
import com.powernode.spring.jdbc.MyDataSource;
import com.powernode.spring.jdbc.MyDataSource1;
import com.powernode.spring.jdbc.MyDataSource2;
import com.powernode.spring.service.CustomerService;
import com.powernode.spring.service.OrderService;
import com.powernode.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class SpringDITest {

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }

    @Test
    public void testAutowire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        //OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        //orderService.generate();
        CustomerService cs = applicationContext.getBean("cs", CustomerService.class);
        cs.save();
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);

        People peopleBean2 = applicationContext.getBean("peopleBean2", People.class);
        System.out.println(peopleBean2);
    }


    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testSpecial(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }


    @Test
    public void testNullBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat catBean = applicationContext.getBean("catBean", Cat.class);
        System.out.println(catBean);
    }

    @Test
    public void testCollection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = applicationContext.getBean("PersonBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testSimpleArray() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe yuQian = applicationContext.getBean("yuQian", QianDaYe.class);
        System.out.println(yuQian);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        Clazz clazzBean = applicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(clazzBean);
        System.out.println(studentBean);
    }

    @Test
    public void testDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }


    @Test
    public void testSetDI2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderServiceBean = applicationContext.getBean("OrderServiceBean", OrderService.class);
        orderServiceBean.generate();

        OrderService orderServiceBean2 = applicationContext.getBean("OrderServiceBean2", OrderService.class);
        orderServiceBean2.generate();
    }

    @Test
    public void testSetDI(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        UserDao userDaoBean = applicationContext.getBean("UserDaoBean", UserDao.class);
//        userDaoBean.insert();
//        System.out.println(userDaoBean);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("UserServiceBean", UserService.class);
        userService.saveUser();
    }

    @Test
    public void testConstructorDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService csBean = applicationContext.getBean("CsBean", CustomerService.class);
        csBean.save();
        System.out.println("------------------------");
        CustomerService csBean2 = applicationContext.getBean("CsBean2", CustomerService.class);
        csBean2.save();
        System.out.println("------------------------");
        CustomerService csBean3 = applicationContext.getBean("CsBean3", CustomerService.class);
        csBean3.save();
    }
}
