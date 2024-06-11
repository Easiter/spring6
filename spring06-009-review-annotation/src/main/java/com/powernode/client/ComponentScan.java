package com.powernode.client;

import com.powernode.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ComponentScan
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/2 15:06
 * @Version 1.0
 **/
public class ComponentScan {
    public static void main(String[] args) {
        // �������
        //      Ŀǰֻ֪��һ���������֣�ɨ��������µ����е��࣬
        //      �����������@Componentע���ʱ��ʵ�����ö���Ȼ��ŵ�Map������
        Map<String, Object> beanMap = new HashMap<>();
        String packageName = "com.powernode.bean";
        // ��ʼдɨ�����
        // .���������ʽ���������ַ��������"."����ʽһ����ͨ��"."�ַ�������ʽ������ʽ�е�"."
        // ��������ʽ������ô��ʾһ����ͨ��"."�ַ��أ�ʹ�� \. ������ʽ����һ����ͨ��"."�ַ�
        // java��\\��ʾ\
        String packagePath = packageName.replaceAll("\\.", "/");
        // System.out.println(packagePath);
        // comʵ����ĸ�·���µ�һ��Ŀ¼
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        // ��ȡ����·��
        String path = url.getPath();
        // System.out.println(path);
        File file = new File(path);
        File[] files = file.listFiles();

        Arrays.stream(files).forEach(f -> {
            try{
                // System.out.println(f.getName());
                // System.out.println(f.getName().split("\\.")[0]);
                String className = packageName + "." + f.getName().split("\\.")[0];
                // System.out.println(className);
                // ͨ��������ƽ���ע��
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    // �����ע��Ķ�Ҫ��������
                    Object obj = aClass.newInstance();
                    beanMap.put(id, obj);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        System.out.println(beanMap);
    }
}
