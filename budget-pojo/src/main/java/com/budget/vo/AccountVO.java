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
    private Long id;
    private LocalDate accountDate;
    private Long memberId;
    private String  memberName;

    private Long typeId;

    private Long categoryId;
    private String categoryName;

    private double money;

    private String description;

    private String recordMemberName;

    private LocalDateTime  createTime;
}
