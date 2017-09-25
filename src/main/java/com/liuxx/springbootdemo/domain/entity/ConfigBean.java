package com.liuxx.springbootdemo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description:配置Bean测试实体类
 * Creator:liuxx
 * Date:2017/9/25 9:28
 */
@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:config/application-dev.yml")
@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean {
    private String value;
    private String number;
    private int uuid;
}
