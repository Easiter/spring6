package com.powernode.test;

import com.powernode.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {
    @Test
    public void testBeanScope(){
        /*
            1.spring默认情况下是如何管理Bean的，
                默认情况下bean是单例的（singleton），在spring上下文初始化的时候实例化（调用无参构造）
                每次调用getBean（）方法的时候，都返回那个单例的对象
            2.当将bean标签的scope属性设置为prototype:
                bean是多例的，此时spring上下文的初始化时不会实例化这些prototype的bean，
                每次调用getBean（）方法的时候，实例化该bean对象
                prototype翻译为：原型
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
        SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb3);
    }
}
