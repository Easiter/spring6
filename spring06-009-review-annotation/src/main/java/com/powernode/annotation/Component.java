package com.powernode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 自定义注解
 * @author: liuzeyu
 * @date: 2022/11/2 8:50
 * @param: null
 * @return: null
 */

// 标注注解的注解，叫做元注解。@Target注解用来修饰@Component可以出现的位置
// 一以下表示@Component注解可以出现在类上和属性上
@Target(ElementType.TYPE)
// 使用某个注解的时候，如果注解的属性名是value的话，“ value = ”可以省略
// 使用某个注解的时候，如果注解的属性值是数组，并且数组中只有一个元素，大括号可以省略

// @Retention也是一个元注解，用来标注@Component注解最终保留在class文件当中，并且能够被反射机制读取
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // 定义属性类型
    // String是属性类型
    // value是属性名
    String value();
}


