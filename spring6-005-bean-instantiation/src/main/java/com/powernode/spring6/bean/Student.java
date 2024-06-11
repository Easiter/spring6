package com.powernode.spring6.bean;

import java.util.Date;

public class Student {
    // java.util.Date在spring当中被当做简单类型。但是简单类型的话，注入的日期刺符传格式有要求
    // java.util.Date在spring当中也可以被当做是非简单类型
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
