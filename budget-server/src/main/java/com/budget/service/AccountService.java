package com.budget.service;

import com.budget.dto.AccountDTO;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.dto.StatisticQueryDTO;
import com.budget.entity.Account;
import com.budget.result.PageResult;
import com.budget.vo.AccountVO;
import com.budget.vo.StatisticVO;

import java.util.List;

public interface AccountService {
    void addAccount(AccountDTO accountDTO);

    PageResult pageQuery(AccountPageQueryDTO accountPageQueryDTO);

    List<Account> getAccountByCategoryId(Long categoryId);

    void delete(Long id);

    void updateAccount(AccountDTO accountDTO);


    AccountVO getById(Long id);

}
