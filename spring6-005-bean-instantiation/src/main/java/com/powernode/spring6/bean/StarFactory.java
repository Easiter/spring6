package com.powernode.spring6.bean;

// 简单工厂模式中的工厂类角色
public class StarFactory {

    // 工厂类中又一个静态方法
    //  简单工厂模式又叫做静态工厂模式
    public static Star get() {
        // 这个Star对象最终实际上创建的时候还是我们负责new的对象
        return new Star();
    }
}
