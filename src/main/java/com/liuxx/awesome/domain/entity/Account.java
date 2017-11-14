package com.liuxx.awesome.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:账户实体类
 *
 * @author :liuxx
 * Date:2017/9/28 15:33
 */
@Getter
@Setter
public class Account {
    private int id;
    private String name;
    private double money;

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Account() {
        super();
    }
}
