package config;

//@SpringBootConfiguration
//@ServletComponentScan
public class AppApplicationBoot {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AppApplicationBoot.class);

//    public static void main(String[] args) {
//        //先生成关于servlet-spring相关的 ApplicationContext ,后面用这个启动
//        SpringApplicationBuilder servletBuilder = new SpringApplicationBuilder(AppApplicationBoot.class,
//            CodeConfigSpringBoot.BootServletConfig.class, CodeConfigAsWebXml.ServletContextConfig.class,
//            CodeConfigSpringBoot.ServletFactoryConfig.class);
//        servletBuilder.web(WebApplicationType.SERVLET);
//
//        //经上面的  applicatonContext设置parent
//        SpringApplicationBuilder applicationBuilder = servletBuilder.parent(CodeConfigAsWebXml.RootContextConfig.class);
//        applicationBuilder.web(WebApplicationType.NONE);
//
//        //启动
//        servletBuilder.run(args);
//
//        logger.info("AppApplicationBoot 启动了");
//    }

}
