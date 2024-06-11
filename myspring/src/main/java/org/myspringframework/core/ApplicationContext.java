package org.myspringframework.core;

/**
 * @ClassName ApplicationContext
 * @Description myspring���Ӧ�������Ľӿ�
 * @Author lizueyu
 * @Date 2022/11/1 15:15
 * @Version 1.0
 **/
public interface ApplicationContext {

    /**
     * @Description:
     * @author: liuzeyu
     * @date: 2022/11/1 15:18
     * @param: beanName myspring�����ļ���bean��ǩ��id
     * @return: Object ��Ӧ����bean����
     */
    Object getBean(String beanName);
}
