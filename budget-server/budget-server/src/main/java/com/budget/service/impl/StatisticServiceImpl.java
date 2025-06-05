package com.budget.service.impl;

import com.budget.context.BaseContext;
import com.budget.dto.StatisticQueryDTO;
import com.budget.mapper.AccountMapper;
import com.budget.service.StatisticService;
import com.budget.vo.StatisticCategoryVO;
import com.budget.vo.StatisticVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<StatisticVO> summary(StatisticQueryDTO statisticQueryDTO) {
        statisticQueryDTO.setFamilyId(BaseContext.getFamilyId());
        log.info("账单汇总统计:{}", statisticQueryDTO);
        return accountMapper.summary(statisticQueryDTO);
    }

    @Override
    public List<StatisticCategoryVO> summaryByType(StatisticQueryDTO statisticQueryDTO) {
        statisticQueryDTO.setFamilyId(BaseContext.getFamilyId());
        return accountMapper.summaryByType(statisticQueryDTO);
    }
}
