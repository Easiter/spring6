package com.powernode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: �Զ���ע��
 * @author: liuzeyu
 * @date: 2022/11/2 8:50
 * @param: null
 * @return: null
 */

// ��עע���ע�⣬����Ԫע�⡣@Targetע����������@Component���Գ��ֵ�λ��
// һ���±�ʾ@Componentע����Գ��������Ϻ�������
@Target(ElementType.TYPE)
// ʹ��ĳ��ע���ʱ�����ע�����������value�Ļ����� value = ������ʡ��
// ʹ��ĳ��ע���ʱ�����ע�������ֵ�����飬����������ֻ��һ��Ԫ�أ������ſ���ʡ��

// @RetentionҲ��һ��Ԫע�⣬������ע@Componentע�����ձ�����class�ļ����У������ܹ���������ƶ�ȡ
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // ������������
    // String����������
    // value��������
    String value();
}


