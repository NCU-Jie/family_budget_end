package com.budget.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class AccountPageQueryDTO implements Serializable {
    private int page;

    private int pageSize;

    private Long familyId;

    private Long categoryId;

    private Long typeId;

    private List<Long> memberIds;

    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
