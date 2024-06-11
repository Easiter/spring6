package com.powernode.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    // 注入List集合
    private List<String> names;
    // 注入Set集合
    private Set<String> addresses;
    // 注入Map集合
    private Map<Integer, String> phones;
    // 注入属性类对象
    // Properties本质上也是一个Map集合
    // Properties的父类是Hashtable，Hashtable实现了Map接口
    // 虽然这个也是一个Map集合，但是和Map的注入方式有点像，但是不同
    // Properties的key和value只能是字符串，不能是其他类型
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addresses=" + addresses +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }
}

