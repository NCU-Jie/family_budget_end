package com.budget.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
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

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;
}
