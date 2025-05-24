package com.budget.service.impl;

import com.budget.dto.TransactionDTO;
import com.budget.entity.Transaction;
import com.budget.mapper.TransactionMapper;
import com.budget.service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public void addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction=new Transaction();
        BeanUtils.copyProperties(transactionDTO,transaction);
        transactionMapper.insert(transaction);
    }
}
