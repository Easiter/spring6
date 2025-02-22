package com.powernode.proxy;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName TimerInvocationHandler
 * @Description 专门负责计时的一个调用处理器对象，在这个调用处理器当中编写计时相关的代码
 * @Author lizueyu
 * @Date 2022/11/9 21:56
 * @Version 1.0
 **/
public class TimerInvocationHandler implements InvocationHandler {

    private Object target;

    public TimerInvocationHandler(Object target) {
        // 赋值给成员变量
        this.target = target;
    }

    /*
            1、为什么强行要求你必须实现InvocationHandler接口？
                因为一个类实现接口就应该实现接口中的方法
                以下这个方法烦必须是invoke，因为JKD底层调用invoke()方法的程序已经提前写好了。
                注意：invoke方法不是我们程序员负责调用的，是JDK负责调用的
            2、invoke方法什么时候被调用呢？
                当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用。
            3、invoke()方法的三个参数：
                invoke方法是JDK负责调用的，所以JDK调用这个方法的时候会自动给我们传过来三个参数
                我们可以在invoke方法的大括号中直接调用
                第一个参数：Object proxy 代理对象的引用，这个参数用的很少
                第二个参数：Method method 目标对象上的目标方法。（要执行的目标方法就是它）
                第三个参数：Object[] args 目标方法上的实参

                invoke方法执行过程中，使用method来调用目标对象的目标方法
         */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 这个接口的目的就是为了让你有地方写增强代码
        long begin = System.currentTimeMillis();

        // 调用目标对象的目标方法
        /*
            调用方法的四要素：
                哪个对象、哪个方法、传什么参数、返回什么值
         */
        Object retValue = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");

        // 注意这个invoke方法的返回值，如果代理对象调用代理方法之后，需要返回结果的话，invoke方法必须将目标对象的目标方法的执行结果继续返回
        return retValue;
    }
}
