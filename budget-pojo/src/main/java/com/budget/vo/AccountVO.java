package com.budget.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO {
    private LocalDate recordDate;

    private String  name;

    private Long typeId;

    private Long categoryId;

    private double money;

    private String description;

    private String createMemberName;

    private LocalDateTime  createTime;
}
