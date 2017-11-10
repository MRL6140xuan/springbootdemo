package com.liuxx.awesome.web;

import com.liuxx.awesome.domain.entity.Account;
import com.liuxx.awesome.service.AccountService;
import com.liuxx.awesome.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author :liuxx
 * @date: 2017/11/10 19:28
 */
@RestController
@RequestMapping("/swagger")
public class TestSwagger2Api {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "获取用户列表", notes = "notes")
    @GetMapping("/list")
    public ResponseResult getAccounts() {
        return ResponseResult.result(0, null, accountService.getAccounts());
    }

    @ApiOperation(value = "获取用户详情", notes = "通过ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseResult getAccountById(@PathVariable("id") int id) {
        return ResponseResult.result(0, null, accountService.getAccountById(id));
    }

    @ApiOperation(value = "更新用户详情", notes = "修改姓名，money")
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

    @ApiOperation(value = "新增一个用户", notes = "根据Account对象创建")
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
