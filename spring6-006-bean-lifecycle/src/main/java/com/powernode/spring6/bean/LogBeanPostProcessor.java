package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("��������ִ��bean��������before����");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    // ����������������
    // ��һ���������մ�����bean����
    // �ڶ���������bean������
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("���岽��ִ��bean��������after����");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
