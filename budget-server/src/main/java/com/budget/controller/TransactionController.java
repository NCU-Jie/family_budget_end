package com.budget.controller;


import com.budget.dto.TransactionDTO;
import com.budget.result.Result;
import com.budget.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("budget/transaction")
@Slf4j
@Api(tags = "记录相关接口")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    @ApiOperation("添加记录")
    public Result addTransaction(@RequestBody TransactionDTO transactionDTO){
        log.info("添加记录：{}",transactionDTO);
        transactionService.addTransaction(transactionDTO);
        log.info("添加记录成功");
        return Result.success();
    }
}
