package com.powernode.spring6.bean2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @ClassName A
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/2 16:17
 * @Version 1.0
 **/
@Component
public class A {
    public A() {
        System.out.println("A���޲������췽��ִ��");
    }
}

@Controller
class B{
    public B() {
        System.out.println("B���޲������췽��ִ��");
    }
}

@Service
class C{
    public C() {
        System.out.println("C���޲������췽��ִ��");
    }
}

@Repository
class D{
    public D() {
        System.out.println("D���޲������췽��ִ��");
    }
}

@Controller
class E{
    public E() {
        System.out.println("E���޲������췽��ִ��");
    }
}