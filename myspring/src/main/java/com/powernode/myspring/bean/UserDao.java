package com.powernode.myspring.bean;

public class UserDao {

    @Override
    public String toString() {
        return "UserDao{}";
    }

    public void insert(){
        System.out.println("mysql数据库正在保存用户信息...");
    }
}
