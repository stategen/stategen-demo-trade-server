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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;

import com.mycompany.biz.stream.Receive1;
import com.mycompany.biz.stream.Receive2;
 
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient // 表明是一个Nacos客户端，该注解是 SpringCloud 提供的原生注解。
@ServletComponentScan(basePackageClasses = { WebXml.class })
//@EnableWebMvc不能享受 @ApiRequestMappingAutoWithMethodName的便利
@Import({
        CodeConfigSpringBoot.class,
})
public class TradeAppApplication extends SpringBootServletInitializer {
    
    final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TradeAppApplication.class);
    
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
        
        ConfigurableApplicationContext application = SpringApplication.run(TradeAppApplication.class, args);
        WebXml.printEnv(application);
    }
   
    //Following sink is used as test consumer. It logs the data received through the consumer.
    
    public static class TestSink {
        final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TradeAppApplication.TestSink.class);
        
        @Bean
        public Receive1 receive1() {
            return new Receive1() {
                @Override
                public void accept(String t) {
                    log.info("Data received from customer-1..." + t);
                }
            };
        }

        @Bean
        public Receive2 receive2() {
            return data -> log.info("Data received from customer-2..." + data);
        }
    }

    
}