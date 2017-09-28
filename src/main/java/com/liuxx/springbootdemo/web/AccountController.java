package com.liuxx.springbootdemo.web;

import com.liuxx.springbootdemo.domain.entity.Account;
import com.liuxx.springbootdemo.service.AccountService;
import com.liuxx.springbootdemo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:账户controller
 * Creator:liuxx
 * Date:2017/9/28 16:17
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public ResponseResult getAccounts() {
        return ResponseResult.result(0, null, accountService.getAccounts());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseResult getAccountById(@PathVariable("id") int id) {
        return ResponseResult.result(0, null, accountService.getAccountById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseResult updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                        @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t = accountService.update(account);
        if (t == 1) {
            return ResponseResult.result(0, "修改用户信息成功", account);
        } else {
            return ResponseResult.result(1, "修改失败", null);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseResult postAccount(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        int t = accountService.add(account);
        if (t == 1) {
            return ResponseResult.result(0, "成功新增一个用户", account);
        } else {
            return ResponseResult.result(1, "新增失败", null);
        }

    }
}
