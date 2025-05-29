package com.budget.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long familyId;
    //记录id
    private Long id;
    //收支id
    private int typeId;

    private String MemberName;

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

    private LocalDate recordDate;

    private Long createUser;

    private Long updateUser;
}
