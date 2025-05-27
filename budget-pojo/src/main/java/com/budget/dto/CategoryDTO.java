package com.budget.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;

    private String name;

    private Long familyId;

    private int typeId;
}
