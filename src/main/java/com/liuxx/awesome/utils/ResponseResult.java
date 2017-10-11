package com.liuxx.awesome.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * 描述：通用返回封装类
 **/
@Getter
@Setter
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult {
    private int code;
    private String msg;
    private Object data;

    public ResponseResult() {
        super();
    }

    public static ResponseResult result(int code, String msg, Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setData(data);
        return responseResult;
    }
}
