package org.myspringframework.core;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassPathXmlApplicationContext
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/1 15:20
 * @Version 1.0
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * @Description: ����springż�����ļ���Ȼ���ʼ�����е�bean����
     * @author: liuzeyu
     * @date: 2022/11/1 15:21
     * @param: configLocation spring�����ļ���·��
     * @return: null
     * ע�⣺ʹ��ClassPathXmlApplicationContext�������ļ�Ӧ���ŵ���·����
     */
    public ClassPathXmlApplicationContext(String configLocation) {

        // ����myspring.xml�ļ���Ȼ��ʵ����Bean����Bean��ŵ�singletonObjects���ϵ���

        try {
            // ����dmo4j����XML�ļ��ĺ��Ķ���
            SAXReader reader = new SAXReader();
            // ��ȡһ����������ָ�������ļ�
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // ���ļ�
            Document document = reader.read(in);
            // ��ȡ���е�bean��ǩ
            List<Node> nodes = document.selectNodes("//bean");
//            List<Node> nodes = this.getNodes(document);
            // ����bean��ǩ
            nodes.forEach(node -> {
                try {
                    // ����ת�͵�Ŀ����Ϊ��ʹ��Element�ӿ�����ӷḻ�ķ���
                    Element beanElt = (Element) node;
                    // ��ȡid����
                    String id = beanElt.attributeValue("id");
                    // ��ȡclass����
                    String className = beanElt.attributeValue("class");
                    logger.info("beanName = " + id);
                    logger.info("beanClassName = " + className);
                    // ͨ��������ƴ������󣬽���ŵ�Map�����У���ǰ�ع�
                    // ��ȡclass
                    Class<?> aClass = Class.forName(className);
                    // ��ȡ�޲������췽��
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    // �����޲������췽��ʵ����bean
                    Object bean = declaredConstructor.newInstance();
                    // ��bean�ع⣬����Map����
                    singletonObjects.put(id, bean);
                    // ��¼��־
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // �ٴ����°����е�bean��ǩ����һ�Σ���һ����Ҫ�Ǹ���������Ը�ֵ
            nodes.forEach(node -> {
                try {
                    Element beanElement = (Element) node;
                    // ��ȡid
                    String id = beanElement.attributeValue("id");
                    // ��ȡclassName
                    String className = beanElement.attributeValue("class");
                    // ��ȡclass
                    Class<?> aClass = Class.forName(className);
                    // ��ȡ��bean��ǩ�����е�����property��ǩ
                    List<Element> propertys = beanElement.elements("property");
                    // �������е����Ա�ǩ
                    propertys.forEach(property -> {
                        try {
                            // ��ȡ������propertyName
                            String propertyName = property.attributeValue("name");
                            // ��ȡ��������
                            Field field = aClass.getDeclaredField(propertyName);
                            logger.info("������" + propertyName);
                            // ��ȡset��������
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            // ��ȡset����
                            Method setmethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            // ��ȡ�����ֵ
                            String value = property.attributeValue("value");
                            Object actualValue = null; // ��ֵ
                            String ref = property.attributeValue("ref");
                            if (value != null) {
                                // ˵�����ֵ�Ǽ�����
                                // ����set����(set����û�з���ֵ��
                                // ����myspring�������һ�£�����ֻ��֧����Щ����Ϊ������
                                // byte short int long float double boolean char
                                // Byte Short Integer Long Float Double Boolean Charter
                                // String
                                // ��ȡ����������
                                String propertySimpleName = field.getType().getSimpleName();
                                switch (propertySimpleName){
                                    case "byte":
                                        actualValue = Byte.parseByte(value);
                                        break;
                                    case "short":
                                        actualValue = Short.parseShort(value);
                                        break;
                                    case "int":
                                        actualValue = Integer.parseInt(value);
                                        break;
                                    case "long":
                                        actualValue = Long.parseLong(value);
                                        break;
                                    case "float":
                                        actualValue = Float.parseFloat(value);
                                        break;
                                    case "double":
                                        actualValue = Float.parseFloat(value);
                                        break;
                                    case "boolean":
                                        actualValue = Boolean.parseBoolean(value);
                                        break;
                                    case "char":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "Charter":
                                        actualValue = Character.valueOf(value.charAt(0));
                                        break;
                                    case "String":
                                        actualValue = value;
                                        break;
                                }
                                setmethod.invoke(singletonObjects.get(id), actualValue);
                            }
                            if (ref != null) {
                                // ˵�����ֵ���Ǽ�����
                                // ����set����(set����û�з���ֵ��
                                setmethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }


    /**
     * @Description: ��ȡdocument�е�nodes
     * //TODO ������ʱ������dom4j�޷���ȡnode�������������xml�����ļ������ռ������
     * @author: liuzeyu
     * @date: 2022/11/1 15:54
     * @param: document
     * @return: List<Node>
     */
    public List<Node> getNodes(Document document) {
        Map map = new HashMap();
        // ��������ռ�
        String namespaceURI = document.getRootElement().getNamespaceURI();
        map.put("xmlns", namespaceURI);
        // ��������·������������ͨ�Ľ���·��ǰ�����map���keyֵ
        XPath x = document.createXPath("//xmlns:books/xmlns:books");
        x.setNamespaceURIs(map);

        List<Node> nodes = x.selectNodes(document);
        return nodes;
    }
}
