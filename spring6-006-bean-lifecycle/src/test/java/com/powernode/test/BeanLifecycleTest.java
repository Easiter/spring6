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
        // �Լ�new����
        Student student = new Student();
        System.out.println(student);

        // �������Լ�new�Ķ�������spring������������·�Ͻ���spring����
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean",student);

        // ��spring�����л�ȡ
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }

    @Test
    public void testLifecycle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("��������ʹ��Bean��" + user);

        //  ע�⣺�����ֶ��ر�spring����������spring�����Ż�����bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }
}
