package com.powernode.spring.bean;

import java.util.Arrays;

public class QianDaYe {
    // 简单类型数组
    private String[] aiHaos;
    // 对象数组
    private Woman[] women;

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", women=" + Arrays.toString(women) +
                '}';
    }
}
