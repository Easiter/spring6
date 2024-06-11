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
        // 提出需求：
        //      目前只知道一个包的名字，扫描这个包下的所有的类，
        //      当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中
        Map<String, Object> beanMap = new HashMap<>();
        String packageName = "com.powernode.bean";
        // 开始写扫描程序
        // .这个正则表达式代表任意字符。这里的"."必须式一个普通的"."字符，不能式正则表达式中的"."
        // 再正则表达式当中怎么表示一个普通的"."字符呢？使用 \. 正则表达式代表一个普通的"."字符
        // java中\\表示\
        String packagePath = packageName.replaceAll("\\.", "/");
        // System.out.println(packagePath);
        // com实在类的根路径下的一个目录
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        // 获取绝对路径
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
                // 通过反射机制解析注解
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    // 有这个注解的都要创建对象
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
