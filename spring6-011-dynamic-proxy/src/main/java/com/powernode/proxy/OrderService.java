package com.powernode.proxy;

/*
    ����ҵ��ӿ�
 */
public interface OrderService {  //��������Ŀ�����Ĺ����ӿ�

    /*
      ���ɶ���
    */
    void generate();

    /*
      �޸Ķ�����Ϣ
    */
    void modify();

    /*
      �鿴��������
    */
    void detail();

    String getName();

}
