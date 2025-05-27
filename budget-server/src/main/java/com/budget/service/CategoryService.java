package com.budget.service;

import com.budget.dto.CategoryDTO;
import com.budget.dto.CategoryPageQueryDTO;
import com.budget.result.PageResult;

public interface CategoryService {
    void addCategory(CategoryDTO categoryDTO);


    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void delete(Long id);

    void updateCategory(CategoryDTO categoryDTO);
}
