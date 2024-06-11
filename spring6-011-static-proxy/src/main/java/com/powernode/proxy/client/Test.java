package com.powernode.proxy.client;

import com.powernode.proxy.service.OrderService;
import com.powernode.proxy.service.OrderServiceImpl;
import com.powernode.proxy.service.OrderServiceProxy;

/**
 * @ClassName Test
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/5 10:27
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
//        OrderService orderService = new OrderServiceImpl();
//        orderService.generate();
//        orderService.modify();
//        orderService.detail();

        // ����Ŀ�����
        OrderService target = new OrderServiceImpl();
        // �����������
        OrderService proxy = new OrderServiceProxy(target);
        // ���ô������Ĵ�����
        target.generate();
        target.modify();
        target.detail();
        System.out.println("==============================");
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
