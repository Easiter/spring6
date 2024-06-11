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
    // �ͻ��˳���
    public static void main(String[] args) {

        // ����Ŀ�����
        OrderService target = new OrderServiceImpl();
        // �����������
        /*
            1��newProxyInstance ����Ϊ���½��������Ҳ��˵��ͨ����������������Դ����������
               �����ϣ����newProxyInstance()������ִ�У������������飺
                        ��һ�����飺���ڴ��ж�̬��������һ����������ֽ���class
                        �ڶ������飺new�����ˡ�ͨ���ڴ������ɵĴ�����������룬ʵ�����˴������
            2������newProxyInstance()������������Ҫ������ÿ��ʲô���壬��ʲô�ã�
                ��һ��������ClassLoader loader
                    ���������������������ʲô���أ�
                        ���ڴ浱�����ɵ��ֽ���Ҳ��class�ļ���Ҫִ��Ҳ���ȼ��ص��ڴ浱�С����������Ҫ�������������������Ҫָ���������
                        ����JDKҪ��Ŀ����������������ʹ�������������ʹ��ͬһ��!!!
                �ڶ���������Class<?>[] interfaces
                    �������Ŀ����Ҫʵ��ͬһ������ͬһЩ�ӿڡ�
                    ���ڴ������ɴ������ʱ�������������Ҫ�������ʵ����Щ�ӿ�
                ������������InvocationHandler h
                    InvocationHandler ������Ϊ�����ô���������һ���ӿڡ�
                    �ڵ��ô������ӿ��б�д�ľ��ǣ���ǿ����
                    ��Ϊ����Ҫ��ǿʲô���룬JDK��̬���������ǲ²����ġ�û����ô��
                    ��Ȼ�ǽӿڣ���Ҫд�ӿڵ�ʵ���ࡣ

                    ���ܻ������ʣ�
                        �Լ���Ҫ����д���ô������ӿڵ�ʵ���࣬��������౬ը�𣿲���
                        ��Ϊ���ֵ��ô�����дһ�ξͺ���

                ע�⣺��������Ŀ�궼����ʵ�ֵĽӿ�һ�������Կ�������ת��

         */
//        OrderService proxyObj = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new TimerInvocationHandler(target));
        // �������ͨ��������ķ�װ�ͼ����
        OrderService proxyObj = (OrderService) ProxyUtil.newProxyInstance(target);
        // ���ô������Ĵ�����
        // ע�⣺���ô������Ĵ�������ʱ�������Ҫ����ǿ�Ļ���Ŀ������Ŀ�귽���ñ�֤ת��
        proxyObj.generate();
        proxyObj.detail();
        proxyObj.modify();
        String name = proxyObj.getName();
        System.out.println(name);

    }
}
