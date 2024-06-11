package com.powernode.spring.service;

import com.powernode.spring.dao.UserDao;
import com.powernode.spring.dao.VipDao;

public class CustomerService {

    private UserDao userDao;
    private VipDao vipDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    //    public CustomerService(UserDao userDao, VipDao vipDao) {
//        this.userDao = userDao;
//        this.vipDao = vipDao;
//    }

    public void save() {
        userDao.insert();
        vipDao.insert();

    }
}
