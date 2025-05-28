package com.budget.service.impl;

import com.budget.context.BaseContext;
import com.budget.dto.AccountDTO;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.dto.StatisticQueryDTO;
import com.budget.entity.Account;
import com.budget.mapper.MemberMapper;
import com.budget.mapper.AccountMapper;
import com.budget.result.PageResult;
import com.budget.service.AccountService;
import com.budget.vo.AccountVO;
import com.budget.vo.StatisticVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void addAccount(AccountDTO accountDTO) {
        Account account =new Account();
        BeanUtils.copyProperties(accountDTO, account);
        account.setFamilyId(BaseContext.getFamilyId());
        accountMapper.insert(account);
    }

    @Override
    public PageResult pageQuery(AccountPageQueryDTO accountPageQueryDTO) {
        PageHelper.startPage(accountPageQueryDTO.getPage(),  accountPageQueryDTO.getPageSize());
        accountPageQueryDTO.setFamilyId(BaseContext.getFamilyId());
        Page<AccountVO> page = accountMapper.pageQuery(accountPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Account> getAccountByCategoryId(Long categoryId) {
        Long familyId = BaseContext.getFamilyId();
        List<Account> accountList = accountMapper.getAccountByCategoryId(categoryId,familyId);
        return accountList;
    }

    @Override
    public void delete(Long id) {
        accountMapper.deleteById(id);
    }

    @Override
    public void updateAccount(AccountDTO accountDTO) {
        Account account =new Account();
        BeanUtils.copyProperties(accountDTO, account);
        accountMapper.update(account);
    }

    @Override
    public List<StatisticVO> summary(StatisticQueryDTO statisticQueryDTO) {
        statisticQueryDTO.setFamilyId(BaseContext.getFamilyId());
        return accountMapper.summary(statisticQueryDTO);
    }
}
