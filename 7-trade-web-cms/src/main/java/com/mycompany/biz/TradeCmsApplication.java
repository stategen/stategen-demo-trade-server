package com.mycompany.biz;

import java.net.UnknownHostException;

import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient // 表明是一个Nacos客户端，该注解是 SpringCloud 提供的原生注解。
@ServletComponentScan(basePackageClasses = { WebXml.class })
//@EnableWebMvc不能享受 @ApiRequestMappingAutoWithMethodName的便利
@Import({
        CodeConfigSpringBoot.class,
})
public class TradeCmsApplication extends SpringBootServletInitializer {
    
    final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TradeCmsApplication.class);
    
    @Override
    protected WebApplicationContext createRootApplicationContext(ServletContext servletContext) {
        WebApplicationContext createRootApplicationContext = super.createRootApplicationContext(servletContext);
        WebXml.printEnv(createRootApplicationContext);
        return createRootApplicationContext;
    }
    
    public static void main(String[] args) throws UnknownHostException {
        if (log.isInfoEnabled()) {
            log.info("从main启动");
            for (int i = 0; i < args.length; i++) {
                log.info(i + "<===========>:" + args[i]);
            }
        }
        
        ConfigurableApplicationContext application = SpringApplication.run(TradeCmsApplication.class, args);
        WebXml.printEnv(application);
    }
    
}