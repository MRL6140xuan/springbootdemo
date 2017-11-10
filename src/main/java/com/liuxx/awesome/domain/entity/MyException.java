package com.liuxx.awesome.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 * 封装自定义的ErrorInfo
 *
 * @author :liuxx
 * @date: 2017/11/10 15:48
 */
@Getter
@Setter
public class MyException extends Exception {
    private ErrorInfo errorInfo;

    public MyException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
