package com.powernode.spring6.bean;

// �򵥹���ģʽ�еĹ������ɫ
public class StarFactory {

    // ����������һ����̬����
    //  �򵥹���ģʽ�ֽ�����̬����ģʽ
    public static Star get() {
        // ���Star��������ʵ���ϴ�����ʱ�������Ǹ���new�Ķ���
        return new Star();
    }
}
