package com.powernode.client;

import com.powernode.annotation.Component;

/**
 * @ClassName ReflectAnnotationTest1
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/2 10:01
 * @Version 1.0
 **/
public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // ͨ�����������ô��ȡע��
        // ��ȡ��
        Class<?> clazz = Class.forName("com.powernode.bean.User");
        // �ж���������û��ע��
        if (clazz.isAnnotationPresent(Component.class)) {
            // ��ȡ���ϵ�ע��
            Component annotation = clazz.getAnnotation(Component.class);
            // ����ע������
            System.out.println(annotation.value());
        }
    }
}
