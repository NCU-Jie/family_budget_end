package com.budget.controller;


import com.budget.dto.AccountDTO;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.result.PageResult;
import com.budget.result.Result;
import com.budget.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("budget/account")
@Slf4j
@Api(tags = "记录相关接口")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/add")
    @ApiOperation("添加记录")
    public Result addTransaction(@RequestBody AccountDTO accountDTO){
        log.info("添加记录：{}", accountDTO);
        accountService.addTransaction(accountDTO);
        log.info("添加记录成功");
        return Result.success();
    }

    @GetMapping("/pageQuery")
    @ApiOperation("记录分页查询")
    public Result<PageResult> PageQuery(AccountPageQueryDTO accountPageQueryDTO){
        log.info("记录分页查询：{}", accountPageQueryDTO);
        PageResult pageResult = accountService.pageQuery(accountPageQueryDTO);
        return Result.success(pageResult);
    }

}
