package com.powernode.reflect;

public class Test {
    public static void main(String[] args) {
        // ��ʹ�÷�����Ƶ�����Щ����
        SomeService someService = new SomeService();

        someService.doSome();

        /*
            ��������һ���������к��м���Ҫ�أ��ĸ�Ҫ��
                ��һҪ�أ������ĸ�����
                �ڶ�Ҫ�أ����ö�����ĸ�����
                ����Ҫ�أ����÷�����ʱ��ʲô����
                ����Ҫ�أ�����ִ�н���֮��ķ���ֵ
            һ�仰�����������ĸ�������ĸ���������ʲô����������ʲôֵ
            ��ʹ��ʹ�÷�����Ƶ��÷�����ͬ������Ҫ���ĸ�Ҫ��
         */
        String s1 = someService.doSome("����");
        System.out.println(s1);

        String s2 = someService.doSome("����", 250);
        System.out.println(s2);
    }
}
