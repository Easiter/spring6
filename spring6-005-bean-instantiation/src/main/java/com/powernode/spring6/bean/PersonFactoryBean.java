package com.powernode.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

// Ҳ��һ��bean��֮�������bean�Ƚ����⣬��������bean
// ͨ������bean��������bean���Ի�ȡһ����ͨ��bean
public class PersonFactoryBean implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {
        // �������bean�Ĵ������ǳ���Ա�Լ�new��
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /*
    *   ��������ڽӿ�����Ĭ��ʵ��
    *   Ĭ�Ϸ���true����ʾ������
    *   ����������ֱ�ӽ���������޸�Ϊreturn false
    */
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
