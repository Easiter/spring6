package com.powernode.spring.service;

import com.powernode.spring.dao.OrderDao;

public class OrderService {

    private OrderDao orderDao;

    // 通过set方法给属性赋值
    public void setAa(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }
}
