package com.YuuiAsuka.app1.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix="test")

public class ServerSetting {
    //加上前缀之后会自动注入
    //@Value("${name}")
    private String name;

    //@Value("${domain}")
    private String domain;

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

//    public ServerSetting(String name, String domain) {
//        this.name = name;
//        this.domain = domain;
//    }
}
