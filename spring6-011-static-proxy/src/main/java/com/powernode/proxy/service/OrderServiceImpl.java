package com.powernode.proxy.service;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/5 10:24
 * @Version 1.0
 **/
public class OrderServiceImpl implements OrderService{ // 目标对象
    @Override
    public void generate() { // 目标方法
        // 模拟生成订单的耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成~");
    }

    @Override
    public void modify() {  // 目标方法
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改~");
    }

    @Override
    public void detail() {  // 目标方法
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请看订单详情~");
    }
}
