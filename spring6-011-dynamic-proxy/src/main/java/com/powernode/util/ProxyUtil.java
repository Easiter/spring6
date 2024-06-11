package com.powernode.util;

import com.powernode.proxy.OrderService;
import com.powernode.proxy.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyUtil
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/10 14:39
 * @Version 1.0
 **/
public class ProxyUtil {
    /**
     * @Description: 封装一个工具方法，可以通过这个方法获取代理对象
     * @author: liuzeyu
     * @date: 2022/11/10 14:43
     * @param: target
     * @return: Object
     */
    public static Object newProxyInstance(Object target){
        return  (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}
