package com.budget.mapper;


import com.budget.annotation.AutoFill;
import com.budget.dto.CategoryPageQueryDTO;
import com.budget.entity.Category;
import com.budget.enumeration.OperationType;
import com.budget.vo.CategoryVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

    @AutoFill(OperationType.INSERT)
    void insert(Category category);

    CategoryVO getByNameAndTypeId(String name, int typeId);

    Page<CategoryVO> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void deleteById(Long id);

    void update(Category category);
}
