package com.liuxx.awesome.web;

import com.liuxx.awesome.domain.entity.ConfigBean;
import com.liuxx.awesome.domain.entity.ErrorInfo;
import com.liuxx.awesome.domain.entity.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:项目主页
 *
 * @author :liuxx
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
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("name", "liuxx");
        mv.addObject("password", "123456");
        return mv;
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

    @GetMapping("/exception")
    public String exceptionT() throws Exception {
        throw new Exception("自定义异常");
    }

    @GetMapping("/myexception")
    public String myException() throws Exception {

        throw new MyException(new ErrorInfo<>("1000", "JSON格式的错误信息", "这是泛型的数据包"));
    }

}
