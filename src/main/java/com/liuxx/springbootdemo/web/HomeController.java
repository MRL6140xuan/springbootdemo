package com.liuxx.springbootdemo.web;

import com.liuxx.springbootdemo.domain.entity.ConfigBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:项目主页
 * Creator:liuxx
 * Date:2017/9/24 14:19
 */
@RestController
//@Configuration
//@PropertySource(value = "classpath:config/application-dev.yml")
@RequestMapping(value = "/home")

public class HomeController {
    @Autowired
    private ConfigBean bean;


    @RequestMapping()
    public String home() {
        return "Hello World";
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String home1() {
        return "Hello World - put";
    }

    @GetMapping("/get")
    public String home2() {
//        ConfigBean bean = new ConfigBean();
        return "value:" + bean.getValue() + "\nnumber:" + bean.getNumber() + "\nuuid:" + bean.getUuid();
    }


}
