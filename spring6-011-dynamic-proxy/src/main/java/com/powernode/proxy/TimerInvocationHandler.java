package com.powernode.proxy;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName TimerInvocationHandler
 * @Description ר�Ÿ����ʱ��һ�����ô�����������������ô��������б�д��ʱ��صĴ���
 * @Author lizueyu
 * @Date 2022/11/9 21:56
 * @Version 1.0
 **/
public class TimerInvocationHandler implements InvocationHandler {

    private Object target;

    public TimerInvocationHandler(Object target) {
        // ��ֵ����Ա����
        this.target = target;
    }

    /*
            1��Ϊʲôǿ��Ҫ�������ʵ��InvocationHandler�ӿڣ�
                ��Ϊһ����ʵ�ֽӿھ�Ӧ��ʵ�ֽӿ��еķ���
                �������������������invoke����ΪJKD�ײ����invoke()�����ĳ����Ѿ���ǰд���ˡ�
                ע�⣺invoke�����������ǳ���Ա������õģ���JDK������õ�
            2��invoke����ʲôʱ�򱻵����أ�
                �����������ô�������ʱ��ע����InvocationHandler���ô��������е�invoke()���������á�
            3��invoke()����������������
                invoke������JDK������õģ�����JDK�������������ʱ����Զ������Ǵ�������������
                ���ǿ�����invoke�����Ĵ�������ֱ�ӵ���
                ��һ��������Object proxy �����������ã���������õĺ���
                �ڶ���������Method method Ŀ������ϵ�Ŀ�귽������Ҫִ�е�Ŀ�귽����������
                ������������Object[] args Ŀ�귽���ϵ�ʵ��

                invoke����ִ�й����У�ʹ��method������Ŀ������Ŀ�귽��
         */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // ����ӿڵ�Ŀ�ľ���Ϊ�������еط�д��ǿ����
        long begin = System.currentTimeMillis();

        // ����Ŀ������Ŀ�귽��
        /*
            ���÷�������Ҫ�أ�
                �ĸ������ĸ���������ʲô����������ʲôֵ
         */
        Object retValue = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println("��ʱ" + (end - begin) + "����");

        // ע�����invoke�����ķ���ֵ��������������ô�����֮����Ҫ���ؽ���Ļ���invoke�������뽫Ŀ������Ŀ�귽����ִ�н����������
        return retValue;
    }
}
