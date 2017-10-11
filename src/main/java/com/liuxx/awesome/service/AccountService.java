package com.liuxx.awesome.service;

import com.liuxx.awesome.domain.entity.Account;
import com.liuxx.awesome.domain.repository.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:账户服务实现类
 * Creator:liuxx
 * Date:2017/9/28 16:13
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountDaoImpl accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int remove(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account getAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> getAccounts() {
        return accountDao.findAccounts();
    }
}
