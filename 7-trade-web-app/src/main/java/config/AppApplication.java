package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication application=  new SpringApplication(AppApplication.class);
        application.run(args);
        System.out.println("xxxxxxxxxxxxxSB");
    }

}
