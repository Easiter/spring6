package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/*
- 第一步：实例化Bean（调用无参构造方法）
- 第二步：Bean属性赋值（调用set方法）
- 第三步：初始化Bean（调用bean的init（）方法，注意：这个init（）方法要自己写）
- 第四步：使用Bean
- 第五步：销毁Bean（会调用bean的destroy（）方法，注意：这个destroy（）方法要自己写）
 */
public class User implements BeanNameAware, BeanClassLoaderAware,
        BeanFactoryAware, InitializingBean,DisposableBean {

    private String name;

    public User() {
        System.out.println("第一步：无参构造方法执行");
    }

    public void setName(String name) {
        System.out.println("第二步：给对象的属性赋值");
        this.name = name;
    }

    // 这个方法需要自己写，自己配，方法名字随意
    public void initBean() {
        System.out.println("第四步：初始化bean");
    }

    // 这个方法需要自己写，自己配，方法名字随意
    public void destroyBean() {
        System.out.println("第七步：销毁bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("这个类的加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个类的beanFactory对象是：" + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("这个bean的名字是：" + s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean的afterPropertiesSet方法执行了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean的destroy方法执行了");
    }
}
