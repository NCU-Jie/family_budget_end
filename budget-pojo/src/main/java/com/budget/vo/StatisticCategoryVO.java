package com.budget.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticCategoryVO {
    private String categoryId;
    private String categoryName;
    private BigDecimal income;
    private BigDecimal expense;
    private Long groupCount;
}