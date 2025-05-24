package com.budget.service.impl;

import com.budget.context.BaseContext;
import com.budget.dto.TransactionDTO;
import com.budget.entity.Transaction;
import com.budget.mapper.MemberMapper;
import com.budget.mapper.TransactionMapper;
import com.budget.service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public void addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction=new Transaction();
        BeanUtils.copyProperties(transactionDTO,transaction);
        Long familyId = memberMapper.getFamilyIdById(BaseContext.getCurrentId());
        transaction.setFamilyId(familyId);
        transactionMapper.insert(transaction);
    }
}
