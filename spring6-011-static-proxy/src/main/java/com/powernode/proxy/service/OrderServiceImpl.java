package com.powernode.proxy.service;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/5 10:24
 * @Version 1.0
 **/
public class OrderServiceImpl implements OrderService{ // Ŀ�����
    @Override
    public void generate() { // Ŀ�귽��
        // ģ�����ɶ����ĺ�ʱ
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("����������~");
    }

    @Override
    public void modify() {  // Ŀ�귽��
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�������޸�~");
    }

    @Override
    public void detail() {  // Ŀ�귽��
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�뿴��������~");
    }
}
