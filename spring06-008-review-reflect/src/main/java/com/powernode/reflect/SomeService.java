package com.powernode.reflect;

public class SomeService {

    public void doSome() {
        System.out.println("public void doSome()ִ��");
    }

    public String doSome(String s) {
        System.out.println("public String doSome(String s)ִ��");
        return s;
    }

    public String doSome(String s, int i) {
        System.out.println("public String doSome(String s, int i)ִ��");
        return s + i;
    }

}
