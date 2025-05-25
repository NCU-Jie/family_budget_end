package com.budget.service;

import com.budget.dto.AccountDTO;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.result.PageResult;

public interface AccountService {
    void addTransaction(AccountDTO accountDTO);

    PageResult pageQuery(AccountPageQueryDTO accountPageQueryDTO);
}
