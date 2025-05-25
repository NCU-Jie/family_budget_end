package com.budget.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountPageQueryDTO implements Serializable {
    private int page;

    private int pageSize;

    private Long familyId;

    private Long categoryId;
}
