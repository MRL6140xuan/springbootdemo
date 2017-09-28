package com.liuxx.springbootdemo.dao;

import com.liuxx.springbootdemo.domain.entity.Account;

import java.util.List;

/**
 * Description:帐号DAO
 * Creator:liuxx
 * Date:2017/9/28 15:32
 */
public interface IAcountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccounts();
}
