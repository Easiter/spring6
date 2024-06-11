package com.powernode.spring6.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class SpringBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringBean.class);

    public SpringBean() {
        System.out.println("SpringBean的无参构造方法执行了");
        logger.info("SpringBean的无参构造方法执行了");
    }


}
