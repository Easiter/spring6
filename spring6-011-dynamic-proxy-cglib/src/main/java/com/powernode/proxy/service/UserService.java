package com.powernode.proxy.service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/10 17:03
 * @Version 1.0
 **/
public class UserService {

    // Ŀ�귽��
    public boolean login(String username, String password) {
        System.out.println("ϵͳ������֤���...");
        if ("admin".equals(username) && "123".equals(password)) {
            return true;
        }
        return false;
    }

    // Ŀ�귽��
    public void logout(){
        System.out.println("ϵͳ�����˳�...");
    }

}
