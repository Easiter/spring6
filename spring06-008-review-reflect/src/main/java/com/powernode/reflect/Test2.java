package com.powernode.reflect;

import java.lang.reflect.Method;

public class Test2 {
    // ʹ�÷�����Ƶ��÷���
    public static void main(String[] args) throws Exception {
        // ��ȡ��
        Class clazz = Class.forName("com.powernode.reflect.SomeService");
        Object obj = clazz.newInstance();
        // ��ȡ����
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        // ���÷���
        // ��Ҫ�أ������ĸ�������ĸ���������ʲô��������ʲôֵ
        Object result = doSomeMethod.invoke(obj, "����", 250);
        System.out.println(result);
    }
}
