package com.liuxx.springbootdemo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
@Configuration
@PropertySource(value = "classpath:application-dev.yml")
@RequestMapping(value = "/home")
public class HomeController {
    @Value("${my.value}")
    private String value;
    private String number;
    private String uuid;

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
        return "value:"+this.value+"\nnumber:"+this.number+"\nuuid:"+this.uuid;
    }


}
