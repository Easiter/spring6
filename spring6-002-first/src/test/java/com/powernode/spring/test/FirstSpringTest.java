package com.powernode.spring.test;

import com.powernode.spring.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpring() {
        // 1、获取Spring容器对象
        // ApplicationContext 翻译为：应用上下文。其实就是Spring容器
        // ApplicationContext 是一个接口
        // ApplicationContext 接口下有很多实现类。其中有一个实现类叫做：ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 专门从类路径当中加载spring配置文件的一个spring上下文对象
        // 这行代码只要执行：就相当于启动了spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器当中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 2、根据bean的id从spring容器中获取这个对象
        Object userBean = applicationContext.getBean("UserBean");
        System.out.println(userBean);
    }

    @Test
    public void testSecondSpring() {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("UserBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testInitBean() {
        // 自己怎么去使用log4j2记录日志信息呢？
        // 第一步：创建日志记录器对象
        // 获取FirstSpringTest类的日志记录器对象，也就是说只要是FirstSpringTest类中的代码执行，就会输出相关的日志信息
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        // 第二步：记录日志，根据不同级别来输出日志
        logger.info("111");
        logger.debug("222");
        logger.error("333");
    }
}

