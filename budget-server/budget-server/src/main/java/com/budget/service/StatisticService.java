package com.budget.service;

import com.budget.dto.StatisticQueryDTO;
import com.budget.vo.StatisticCategoryVO;
import com.budget.vo.StatisticVO;

import java.util.List;

public interface StatisticService {
    List<StatisticVO> summary(StatisticQueryDTO statisticQueryDTO);

    List<StatisticCategoryVO> summaryByType(StatisticQueryDTO statisticQueryDTO);
}
