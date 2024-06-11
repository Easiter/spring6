package com.powernode.proxy.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName TimerMethodInterceptor
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/10 18:16
 * @Version 1.0
 **/
public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        // ǰ����ǿ
        long begin = System.currentTimeMillis();

        // ��ô����Ŀ������Ŀ�����أ�
        Object retValue = methodProxy.invokeSuper(target, objects);

        // ������ǿ
        long end = System.currentTimeMillis();
        System.out.println("��ʱ" + (end - begin) + "����");

        return retValue;
    }
}
