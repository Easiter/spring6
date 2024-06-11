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
        // 通过反射机制怎么读取注解
        // 获取类
        Class<?> clazz = Class.forName("com.powernode.bean.User");
        // 判断类上面有没有注解
        if (clazz.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = clazz.getAnnotation(Component.class);
            // 访问注解属性
            System.out.println(annotation.value());
        }
    }
}
