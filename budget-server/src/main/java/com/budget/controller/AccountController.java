package com.budget.controller;


import com.budget.dto.AccountDTO;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.dto.StatisticQueryDTO;
import com.budget.result.PageResult;
import com.budget.result.Result;
import com.budget.service.AccountService;
import com.budget.vo.StatisticVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("budget/account")
@Slf4j
@Api(tags = "记录相关接口")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/add")
    @ApiOperation("添加记录")
    public Result addAccount(@RequestBody AccountDTO accountDTO){
        log.info("添加记录：{}", accountDTO);
        accountService.addAccount(accountDTO);
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



    @ApiOperation("根据记录id删除记录")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        log.info("根据记录id删除记录:{}",id);
        accountService.delete(id);
        return Result.success();
    }

    @ApiOperation("更新记录")
    @PutMapping("/update")
    public Result update(@RequestBody AccountDTO accountDTO){
        log.info("更新记录:{}",accountDTO);
        accountService.updateAccount(accountDTO);
        return Result.success();
    }

    @ApiOperation("账单汇总统计")
    @GetMapping("/summary")
    public Result<List<StatisticVO>> summary(StatisticQueryDTO statisticQueryDTO){
        log.info("账单汇总统计:{}",statisticQueryDTO);
        List<StatisticVO> statisticQueryVOList = accountService.summary(statisticQueryDTO);
        return Result.success(statisticQueryVOList);
    }
}
