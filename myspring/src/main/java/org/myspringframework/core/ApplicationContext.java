package org.myspringframework.core;

/**
 * @ClassName ApplicationContext
 * @Description myspring框架应用上下文接口
 * @Author lizueyu
 * @Date 2022/11/1 15:15
 * @Version 1.0
 **/
public interface ApplicationContext {

    /**
     * @Description:
     * @author: liuzeyu
     * @date: 2022/11/1 15:18
     * @param: beanName myspring配置文件中bean标签的id
     * @return: Object 对应单例bean对象
     */
    Object getBean(String beanName);
}
