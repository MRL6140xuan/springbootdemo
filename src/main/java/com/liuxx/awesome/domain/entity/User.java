package com.liuxx.awesome.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * mybatis 测试实体类
 *
 * @author :liuxx
 * @date: 2017/11/13 10:30
 */
@Setter
@Getter
public class User {
    private Long id;
    private String name;
    private Integer age;
}
