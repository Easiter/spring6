package com.powernode.spring6.bean;

import java.util.Date;

public class Student {
    // java.util.Date��spring���б����������͡����Ǽ����͵Ļ���ע������ڴ̷�����ʽ��Ҫ��
    // java.util.Date��spring����Ҳ���Ա������ǷǼ�����
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
