package com.YuuiAsuka.app1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import com.YuuiAsuka.app1.domain.User;
import javax.servlet.MultipartConfigElement;

@RestController
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan
@SpringBootConfiguration
@ServletComponentScan
public class Start {

    @RequestMapping("/test")
     String Home(){
        return "HelloWorld";
    }

    @RequestMapping("/test2")
    public Map<String, String> page(){
        Map <String, String> map = new HashMap<>();
        map.put("name", "JCShen");
        return map;
    }

    @GetMapping("/testjson")
    public Object testjson(){
        int i = 1/0;
        return new User("hhh", 15, "qqqqq", new Date());
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("10240KB"));
        factory.setMaxRequestSize(DataSize.parse("1024000KB"));
        return factory.createMultipartConfig();
    }


    public static void main(String[] args)throws Exception{

        SpringApplication.run(Start.class, args);

    }
}
