package com.budget.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AccountDTO implements Serializable {
    //记录id
    private Long id;

    private String memberName;
    //收支类型id
    private Long typeId;
    //收支分类id
    private Long categoryId;
    //成员id
    private Long memberId;
    //收支金额
    private BigDecimal money;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate accountDate;
    //描述信息
    private String description;


}
