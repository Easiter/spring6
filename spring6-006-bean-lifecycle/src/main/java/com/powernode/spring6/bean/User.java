package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/*
- ��һ����ʵ����Bean�������޲ι��췽����
- �ڶ�����Bean���Ը�ֵ������set������
- ����������ʼ��Bean������bean��init����������ע�⣺���init��������Ҫ�Լ�д��
- ���Ĳ���ʹ��Bean
- ���岽������Bean�������bean��destroy����������ע�⣺���destroy��������Ҫ�Լ�д��
 */
public class User implements BeanNameAware, BeanClassLoaderAware,
        BeanFactoryAware, InitializingBean,DisposableBean {

    private String name;

    public User() {
        System.out.println("��һ�����޲ι��췽��ִ��");
    }

    public void setName(String name) {
        System.out.println("�ڶ���������������Ը�ֵ");
        this.name = name;
    }

    // ���������Ҫ�Լ�д���Լ��䣬������������
    public void initBean() {
        System.out.println("���Ĳ�����ʼ��bean");
    }

    // ���������Ҫ�Լ�д���Լ��䣬������������
    public void destroyBean() {
        System.out.println("���߲�������bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("�����ļ�������" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("����������beanFactory�����ǣ�" + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("���bean�������ǣ�" + s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean��afterPropertiesSet����ִ����");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean��destroy����ִ����");
    }
}
