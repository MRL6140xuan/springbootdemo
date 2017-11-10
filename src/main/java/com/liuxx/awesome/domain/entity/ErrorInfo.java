package com.liuxx.awesome.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义错误信息（返回前端）
 *
 * @author :liuxx
 * @date: 2017/11/10 15:43
 */
@Getter
@Setter
public class ErrorInfo<T> {
    /**
     * 错误代码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 数据
     */
    private T date;
    /**
     * 发生错误的页面
     */
    private StringBuffer url;

    public ErrorInfo(String code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }
}
