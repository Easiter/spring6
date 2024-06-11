package com.powernode.spring6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description 编写一个类代替spring的配置文件
 * @Author lizueyu
 * @Date 2022/11/2 18:12
 * @Version 1.0
 **/
@Configuration
@ComponentScan({"com.powernode.spring6.bean"})
public class SpringConfig {
}
