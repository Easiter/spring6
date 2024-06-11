package com.powernode.proxy.service;

/**
 * @ClassName OrderServiceProxy
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/5 10:55
 * @Version 1.0
 **/
// ������󣨴�������Ŀ����������ͬ����Ϊ������Ҫʵ��ͬһ������ͬһЩ�ӿ�
// �ͻ���ʹ�ô�������ʱ�����ʹ��Ŀ�����һ��
public class OrderServiceProxy implements OrderService {

    // ��Ŀ�������Ϊ��������һ�����ԡ����ֹ�ϵ����������ϵ���ȼ̳й�ϵ����϶ȵͣ�
    // ��������к���Ŀ���������ã�������ϵ
    // ע�⣺����Ҫдһ�������ӿڣ���Ϊ�����ӿ���϶ȵ�
    private OrderService target; // �����Ŀ�����Ŀ�����һ����ʵ����OrderService�ӿڵ�

    // ������������ʱ�򣬴�һ��Ŀ�������������
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {  // ������
        // ��ǿ
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("��ʱ" + (end - begin) + "����");
    }

    @Override
    public void modify() {   // ������
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("��ʱ" + (end - begin) + "����");
    }

    @Override
    public void detail() {   // ������
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("��ʱ" + (end - begin) + "����");
    }
}
