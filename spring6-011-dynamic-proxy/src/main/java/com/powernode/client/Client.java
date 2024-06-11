package com.powernode.client;

import com.powernode.proxy.OrderService;
import com.powernode.proxy.OrderServiceImpl;
import com.powernode.proxy.TimerInvocationHandler;
import com.powernode.util.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName Client
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/9 21:30
 * @Version 1.0
 **/
public class Client {
    // 客户端程序
    public static void main(String[] args) {

        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /*
            1、newProxyInstance 翻译为：新建代理对象，也就说，通过调用这个方法可以创建代理对象
               本质上，这个newProxyInstance()方法的执行，做了两件事情：
                        第一件事情：在内存中动态的生成了一个代理类的字节码class
                        第二件事情：new对象了。通过内存中生成的代理类这个代码，实例化了代理对象
            2、关于newProxyInstance()方法的三个重要参数，每个什么含义，有什么用？
                第一个参数：ClassLoader loader
                    类加载器。这个类加载器有什么用呢？
                        在内存当中生成的字节码也是class文件，要执行也得先加载到内存当中。加载类就需要类加载器，所以这里需要指定类加载器
                        并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个!!!
                第二个参数：Class<?>[] interfaces
                    代理类和目标类要实现同一个或者同一些接口。
                    在内存中生成代理类的时候，这个代理类需要你告诉它实现哪些接口
                第三个参数：InvocationHandler h
                    InvocationHandler 被翻译为：调用处理器。是一个接口。
                    在调用处理器接口中编写的就是：增强代码
                    因为具体要增强什么代码，JDK动态代理技术它是猜不到的。没有那么神
                    既然是接口，就要写接口的实现类。

                    可能会有疑问？
                        自己还要动手写调用处理器接口的实现类，这个不会类爆炸吗？不会
                        因为这种调用处理器写一次就好了

                注意：代理对象和目标都西昂实现的接口一样，所以可以向下转型

         */
//        OrderService proxyObj = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new TimerInvocationHandler(target));
        // 上面代码通过工具类的封装就简洁了
        OrderService proxyObj = (OrderService) ProxyUtil.newProxyInstance(target);
        // 调用代理对象的代理方法
        // 注意：调用代理对象的代理方法的时候，如果你要做增强的话，目标对象的目标方法得保证转型
        proxyObj.generate();
        proxyObj.detail();
        proxyObj.modify();
        String name = proxyObj.getName();
        System.out.println(name);

    }
}
