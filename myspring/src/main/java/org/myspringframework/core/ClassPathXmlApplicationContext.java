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
     * @Description: 解析spring偶配置文件，然后初始化所有的bean对象
     * @author: liuzeyu
     * @date: 2022/11/1 15:21
     * @param: configLocation spring配置文件的路径
     * @return: null
     * 注意：使用ClassPathXmlApplicationContext，配置文件应当放到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {

        // 解析myspring.xml文件，然后实例化Bean，将Bean存放到singletonObjects集合当中

        try {
            // 这是dmo4j解析XML文件的核心对象
            SAXReader reader = new SAXReader();
            // 获取一个输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // 读文件
            Document document = reader.read(in);
            // 获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
//            List<Node> nodes = this.getNodes(document);
            // 遍历bean标签
            nodes.forEach(node -> {
                try {
                    // 向下转型的目的是为了使用Element接口里更加丰富的方法
                    Element beanElt = (Element) node;
                    // 获取id属性
                    String id = beanElt.attributeValue("id");
                    // 获取class属性
                    String className = beanElt.attributeValue("class");
                    logger.info("beanName = " + id);
                    logger.info("beanClassName = " + className);
                    // 通过反射机制创建对象，将其放到Map集合中，提前曝光
                    // 获取class
                    Class<?> aClass = Class.forName(className);
                    // 获取无参数构造方法
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    // 调用无参数构造方法实例化bean
                    Object bean = declaredConstructor.newInstance();
                    // 将bean曝光，加入Map集合
                    singletonObjects.put(id, bean);
                    // 记录日志
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再次重新把所有的bean标签遍历一次，这一次主要是给对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElement = (Element) node;
                    // 获取id
                    String id = beanElement.attributeValue("id");
                    // 获取className
                    String className = beanElement.attributeValue("class");
                    // 获取class
                    Class<?> aClass = Class.forName(className);
                    // 获取该bean标签下所有的属性property标签
                    List<Element> propertys = beanElement.elements("property");
                    // 遍历所有的属性标签
                    propertys.forEach(property -> {
                        try {
                            // 获取属性名propertyName
                            String propertyName = property.attributeValue("name");
                            // 获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            logger.info("属性名" + propertyName);
                            // 获取set方法名字
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            // 获取set方法
                            Method setmethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            // 获取具体的值
                            String value = property.attributeValue("value");
                            Object actualValue = null; // 真值
                            String ref = property.attributeValue("ref");
                            if (value != null) {
                                // 说明这个值是简单类型
                                // 调用set方法(set方法没有返回值）
                                // 我们myspring框架声明一下：我们只和支持这些类型为简单类型
                                // byte short int long float double boolean char
                                // Byte Short Integer Long Float Double Boolean Charter
                                // String
                                // 获取属性类型名
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
                                // 说明这个值不是简单类型
                                // 调用set方法(set方法没有返回值）
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
     * @Description: 获取document中的nodes
     * //TODO 关于有时候利用dom4j无法获取node的情况，可能是xml配置文件命名空间的问题
     * @author: liuzeyu
     * @date: 2022/11/1 15:54
     * @param: document
     * @return: List<Node>
     */
    public List<Node> getNodes(Document document) {
        Map map = new HashMap();
        // 获得命名空间
        String namespaceURI = document.getRootElement().getNamespaceURI();
        map.put("xmlns", namespaceURI);
        // 创建解析路径，就是在普通的解析路径前面加上map里的key值
        XPath x = document.createXPath("//xmlns:books/xmlns:books");
        x.setNamespaceURIs(map);

        List<Node> nodes = x.selectNodes(document);
        return nodes;
    }
}
