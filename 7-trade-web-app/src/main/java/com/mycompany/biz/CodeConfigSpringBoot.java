package com.mycompany.biz;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.service.impl.HelloBean;

public class CodeConfigSpringBoot {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CodeConfigSpringBoot.class);
    /***用自定义配置的tomcat*/
    @ImportResource("classpath:servlet-factory.xml")
    public static class ServletFactoryConfig {

    }

    @Configuration
    public static class BootServletConfig {

        /***springboot 启动一个自定义servlet,*/
        @Bean
        public ServletRegistrationBean<?> createServletConfig() {
            DispatcherServlet dispatcherServlet = new DispatcherServlet();
            StaticWebApplicationContext applicationContext = new StaticWebApplicationContext();
            dispatcherServlet.setApplicationContext(applicationContext);

            ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet, "/*");

            servletRegistrationBean.setName("BootServletConfig");
            return servletRegistrationBean;
        }
    }
    
    
    public static void printEnv(ConfigurableApplicationContext application) throws UnknownHostException {
        //https://blog.csdn.net/rongbo91/article/details/109645729
        System.out.println("项目启动成功 *^_^* \n" + " .-------.       ____     __        \n"
                + " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n"
                + " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n"
                + " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n"
                + " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        AbstractServletWebServerFactory servletWebServerFactory = application.getBean(AbstractServletWebServerFactory.class);
        HelloBean bean = application.getBean(HelloBean.class);
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuilder("输出info信息: bean:").append(bean).toString());
        }
        
        int port = servletWebServerFactory.getPort();//env.getProperty("tradeApp.port");
        String path = servletWebServerFactory.getContextPath();//env.getProperty("server.servlet.context-path");
        if (StringUtil.isEmpty(path)) {
            path = "";
        }
        logger.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "servletWebServerFactory  类型："+servletWebServerFactory.getClass().getName()+":\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
    }
}
