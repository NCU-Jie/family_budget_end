package com.budget.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDTO {
    //记录id
    private Long id;

    //收支分类id
    private Long categoryId;
    //成员id
    private Long memberId;
    //收支金额
    private BigDecimal money;
    //描述信息
    private String description;


}
