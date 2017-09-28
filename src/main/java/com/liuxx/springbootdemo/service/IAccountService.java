package com.liuxx.springbootdemo.service;

import com.liuxx.springbootdemo.domain.entity.Account;

import java.util.List;

/**
 * Description:账户服务接口
 * Creator:liuxx
 * Date:2017/9/28 16:12
 */
public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int remove(int id);

    Account getAccountById(int id);

    List<Account> getAccounts();
}
