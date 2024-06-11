package com.powernode.reflect;

import java.lang.reflect.Method;

public class Test2 {
    // 使用反射机制调用方法
    public static void main(String[] args) throws Exception {
        // 获取类
        Class clazz = Class.forName("com.powernode.reflect.SomeService");
        Object obj = clazz.newInstance();
        // 获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        // 调用方法
        // 四要素：调用哪个对象的哪个方法，传什么参数，反什么值
        Object result = doSomeMethod.invoke(obj, "张三", 250);
        System.out.println(result);
    }
}
