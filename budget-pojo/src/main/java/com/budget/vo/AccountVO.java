package com.budget.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO {
    private LocalDate recordDate;

    private String  name;

    private int typeId;

    private Long categoryId;

    private double money;

    private String description;
}
