package com.powernode.reflect;

public class SomeService {

    public void doSome() {
        System.out.println("public void doSome()Ö´ÐÐ");
    }

    public String doSome(String s) {
        System.out.println("public String doSome(String s)Ö´ÐÐ");
        return s;
    }

    public String doSome(String s, int i) {
        System.out.println("public String doSome(String s, int i)Ö´ÐÐ");
        return s + i;
    }

}
