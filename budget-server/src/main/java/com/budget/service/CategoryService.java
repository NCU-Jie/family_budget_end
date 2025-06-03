package com.budget.service;

import com.budget.dto.CategoryDTO;
import com.budget.dto.CategoryPageQueryDTO;
import com.budget.result.PageResult;
import com.budget.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO categoryDTO);


    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void delete(Long id);

    void updateCategory(CategoryDTO categoryDTO);

    List<CategoryVO> findByName(CategoryDTO categoryDTO);

    List<CategoryVO> list(Long typeId);
}
