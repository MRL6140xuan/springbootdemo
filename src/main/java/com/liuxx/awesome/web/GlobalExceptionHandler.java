package com.liuxx.awesome.web;

import com.liuxx.awesome.domain.entity.ErrorInfo;
import com.liuxx.awesome.domain.entity.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 *
 * @author :liuxx
 * @date: 2017/11/10 9:48
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 返回错误页面
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mv = new ModelAndView(DEFAULT_ERROR_VIEW);
        mv.addObject("exception", e);
        mv.addObject("url", req.getRequestURL());
        mv.addObject("name", "liuxx");
        return mv;
    }

    /**
     * 返回JSON格式的错误信息
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo myExceptionHandler(HttpServletRequest req, MyException e) {
        ErrorInfo errorInfo = e.getErrorInfo();
        errorInfo.setUrl(req.getRequestURL());
        return errorInfo;
    }
}
