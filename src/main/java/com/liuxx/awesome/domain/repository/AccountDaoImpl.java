package com.liuxx.awesome.domain.repository;

import com.liuxx.awesome.dao.IAcountDAO;
import com.liuxx.awesome.domain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:帐号DAP实现类
 *
 * @author :liuxx
 * Date:2017/9/28 15:24
 */
@Repository
public class AccountDaoImpl implements IAcountDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("INSERT INTO account (name,money) VALUE (?,?) ",
                account.getName(), account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE account SET `name` =? ,money=? WHERE id =? ",
                account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM account WHERE id=?", id);
    }

    /**
     * 通过id查找账户
     *
     * @param id
     * @return
     */
    @Override
    public Account findAccountById(int id) {
        List<Account> list = jdbcTemplate.query("SELECT * FROM account WHERE id =? ", new Object[]{id}, new BeanPropertyRowMapper<>(Account.class));
        if (list != null && list.size() > 0) {
            Account account = list.get(0);
            return account;
        } else {
            return null;
        }

    }

    /**
     * 获取所有账户
     *
     * @return
     */
    @Override
    public List<Account> findAccounts() {
        List<Account> list = jdbcTemplate.query("SELECT * FROM account ", new Object[]{}, new BeanPropertyRowMapper<>(Account.class));
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }
}
