package com.budget.dto;

import lombok.Data;

@Data
public class CategoryPageQueryDTO {
    private int page;

    private int pageSize;

    private Long familyId;

    private Long typeId;
}
