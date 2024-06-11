package com.powernode.reflect;

public class Test {
    public static void main(String[] args) {
        // 不使用反射机制调用这些方法
        SomeService someService = new SomeService();

        someService.doSome();

        /*
            分析调用一个方法当中含有几个要素？四个要素
                第一要素：调用哪个对象
                第二要素：调用对象的哪个方法
                第三要素：调用方法的时候传什么参数
                第四要素：方法执行结束之后的返回值
            一句话概括：调用哪个对象的哪个方法，传什么参数，返回什么值
            即使是使用反射机制调用方法，同样这需要这四个要素
         */
        String s1 = someService.doSome("张三");
        System.out.println(s1);

        String s2 = someService.doSome("李四", 250);
        System.out.println(s2);
    }
}
