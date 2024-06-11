package com.powernode.proxy.client;

import com.powernode.proxy.service.TimerMethodInterceptor;
import com.powernode.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName Client
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/10 17:09
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        // �����ֽ�����ǿ������
        // ���������CGLIB�⵱�еĺ��Ķ��󣬾��������������ɴ�����
        Enhancer enhancer = new Enhancer();

        // ����CGLIB������˭������CGLIBĿ������˭
        enhancer.setSuperclass(UserService.class);

        // ���ûص�����ͬ��JDK��̬�����еĵ��ô�����
        // ��CGLIB���в���InvocationHandler�ӿڣ��Ƿ����������ӿڣ�MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());

        // �����������
        /*
            ��һ�����������£�
                ��һ���£����ڴ�������UserService������࣬��ʵ���Ǵ�������ֽ���
                �ڶ����£������������
            ������UserService������Ҳһ����UserService
         */
        UserService userServiceProxy = (UserService) enhancer.create();

        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success ? "��½�ɹ�" : "��½ʧ��");

        userServiceProxy.logout();
    }
}
