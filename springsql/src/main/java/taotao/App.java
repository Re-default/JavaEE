package taotao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //加载Spring相关配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        //获取UserService实例
        UserService userService = applicationContext.getBean(UserService.class);
        //调用方法
        try {
            userService.add("ZhangSan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取ProductService实例
        ProductService productService = applicationContext.getBean(ProductService.class);
        //调用方法
        productService.del("Pen");

        ((ConfigurableApplicationContext)applicationContext).close();
    }

}
