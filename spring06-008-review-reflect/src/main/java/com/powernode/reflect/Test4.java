package com.powernode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
    需求：
        假设你已知一下信息：
            1、有这样一个类，类名叫做：com.powernode.reflect.User
            2、这个类符合javabean规范：实行私有化，对外提供公开的setter和getter方法
            3、你还知道这个类当中的一个属性，属性的名字叫做age
            4、并且你还知道age属性的类型是int类型
        请使用反射机制调用set方法，给User对象的age属性赋值
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
