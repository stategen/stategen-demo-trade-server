package config;

import org.springframework.context.annotation.ImportResource;

public class CodeConfigSpringBoot {
    /***用自定义配置的tomcat*/
    @ImportResource("classpath*:servlet-factory.xml")
    public static class ServletFactoryConfig {

    }

//    public static class BootServletConfig {
//
//        /***springboot 启动一个自定义servlet,*/
//        @Bean
//        public ServletRegistrationBean<?> createServletConfig() {
//            DispatcherServlet dispatcherServlet = new DispatcherServlet();
//            StaticWebApplicationContext applicationContext = new StaticWebApplicationContext();
//            dispatcherServlet.setApplicationContext(applicationContext);
//
//            ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet, "/*");
//
//            servletRegistrationBean.setName("BootServletConfig");
//            return servletRegistrationBean;
//        }
//    }
}
