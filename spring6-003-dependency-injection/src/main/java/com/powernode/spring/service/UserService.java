package com.powernode.spring.service;

import com.powernode.spring.dao.UserDao;

public class UserService {

    private UserDao userDao;

    // set注入的话，必须提供一个set方法
    // Spring容器会调用这个set方法，来给userDao属性赋值
    // 我自己写一个set方法，不使用IDEA生成的，不符合javabean规范
    // 至少这个这个方法是以set单词开始的。前三个字母不能随便写，必须是”set“
    public void setMySqlUserDao(UserDao xyz) {
        this.userDao = xyz;
    }

    // 这个set是IDEA生成的符合javabean规范
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void saveUser(){
        userDao.insert();
    }
}
