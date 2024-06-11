package com.powernode.proxy.client;

import com.powernode.proxy.service.TimerMethodInterceptor;
import com.powernode.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName Client
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/10 17:09
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        // 这个对象是CGLIB库当中的核心对象，就是依靠它来生成代理类
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB父类是谁。告诉CGLIB目标类是谁
        enhancer.setSuperclass(UserService.class);

        // 设置回调（等同于JDK动态代理当中的调用处理器
        // 在CGLIB当中不是InvocationHandler接口，是芳芳拦截器接口：MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());

        // 创建代理对象
        /*
            这一步会做两件事：
                第一件事：在内存中生成UserService类的子类，其实就是代理类的字节码
                第二件事：创建代理对象
            父类是UserService，子类也一定是UserService
         */
        UserService userServiceProxy = (UserService) enhancer.create();

        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success ? "登陆成功" : "登陆失败");

        userServiceProxy.logout();
    }
}
