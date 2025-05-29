package com.budget.service.impl;

import com.budget.context.BaseContext;
import com.budget.dto.CategoryDTO;
import com.budget.dto.CategoryPageQueryDTO;
import com.budget.entity.Category;
import com.budget.exception.CategoryAlreadyExistsException;
import com.budget.mapper.CategoryMapper;
import com.budget.result.PageResult;
import com.budget.service.CategoryService;
import com.budget.vo.CategoryVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        String name = categoryDTO.getName();
        int typeId = categoryDTO.getTypeId();
        log.info("typeId:{}",  typeId);

        CategoryVO existingCategoryVO = categoryMapper.getByNameAndTypeId(name, typeId);
        if (existingCategoryVO != null) {
            throw new CategoryAlreadyExistsException("分类 " + name + " 已存在");
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setFamilyId(BaseContext.getFamilyId());
        categoryMapper.insert(category);
    }


    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),  categoryPageQueryDTO.getPageSize());
        categoryPageQueryDTO.setFamilyId(BaseContext.getFamilyId());
        Page<CategoryVO> page = categoryMapper.pageQuery(categoryPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteById(id);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        categoryMapper.update(category);
    }

    @Override
    public List<CategoryVO> findByName(CategoryDTO categoryDTO) {
        categoryDTO.setFamilyId(BaseContext.getFamilyId());
        return categoryMapper.findByName(categoryDTO);
    }
}
