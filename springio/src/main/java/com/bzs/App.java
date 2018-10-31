package com.bzs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bzs.service.FileWriterService;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        //加载spring的配置文件，创建容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //通过Bean的id来对FileWriterService进行注入
        FileWriterService fileWriterService = applicationContext.getBean("fileWriterService",FileWriterService.class);
        //调用业务逻辑
        fileWriterService.write("This is a test");
        //关闭容器
        ((ConfigurableApplicationContext)applicationContext).close();
    }
}