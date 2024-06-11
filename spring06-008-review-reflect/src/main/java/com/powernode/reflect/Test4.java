package com.powernode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
    ����
        ��������֪һ����Ϣ��
            1��������һ���࣬����������com.powernode.reflect.User
            2����������javabean�淶��ʵ��˽�л��������ṩ������setter��getter����
            3���㻹֪������൱�е�һ�����ԣ����Ե����ֽ���age
            4�������㻹֪��age���Ե�������int����
        ��ʹ�÷�����Ƶ���set��������User�����age���Ը�ֵ
 */
public class Test4 {
    public static void main(String[] args) throws Exception {

        String className = "com.powernode.reflect.User";
        String propertyName = "age";

        Class clazz = Class.forName(className);
        Constructor nullParamConstructor = clazz.getDeclaredConstructor();
        Object obj = nullParamConstructor.newInstance();

        Field ageFiled = clazz.getDeclaredField(propertyName);
        Class<?> ageType = ageFiled.getType();

        Method setAgeMethod = clazz.getDeclaredMethod("set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1), ageType);
        setAgeMethod.invoke(obj, 45);
        System.out.println(obj);
    }
}
