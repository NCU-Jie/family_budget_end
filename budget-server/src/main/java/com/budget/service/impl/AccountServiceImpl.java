package com.budget.service.impl;

import com.budget.context.BaseContext;
import com.budget.dto.AccountDTO;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.entity.Account;
import com.budget.mapper.MemberMapper;
import com.budget.mapper.AccountMapper;
import com.budget.result.PageResult;
import com.budget.service.AccountService;
import com.budget.vo.AccountVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void addTransaction(AccountDTO accountDTO) {
        Account account =new Account();
        BeanUtils.copyProperties(accountDTO, account);
        account.setFamilyId(BaseContext.getFamilyId());
        accountMapper.insert(account);
    }

    @Override
    public PageResult pageQuery(AccountPageQueryDTO accountPageQueryDTO) {
        PageHelper.startPage(accountPageQueryDTO.getPage(),  accountPageQueryDTO.getPageSize());
        Page<AccountVO> page = accountMapper.pageQuery(accountPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
