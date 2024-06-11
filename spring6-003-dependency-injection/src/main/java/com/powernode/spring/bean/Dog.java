package com.powernode.spring.bean;


import java.util.Date;

/*
    p命名空间注入底层还是set注入，只不过p命名空间注入可以让spring配置变得更简单
 */
public class Dog {
    // 简单类型
    private String name;
    private int age;
    // 非简单类型
    private Date birth;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
