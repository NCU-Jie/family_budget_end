package com.budget.service.impl;

import com.budget.context.BaseContext;
import com.budget.dto.CategoryDTO;
import com.budget.dto.CategoryPageQueryDTO;
import com.budget.entity.Category;
import com.budget.exception.CategoryAlreadyExistsException;
import com.budget.mapper.AccountMapper;
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
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void addCategory(CategoryDTO categoryDTO) {

        Category category=new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setFamilyId(BaseContext.getFamilyId());
        CategoryVO existingCategoryVO = categoryMapper.select(category);
        if (existingCategoryVO != null) {
            throw new CategoryAlreadyExistsException("分类 " + category.getName() + " 已存在");
        }
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
        //删除该分类下的所有记录
        accountMapper.deleteByCategotyId(id);
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

    @Override
    public List<CategoryVO> list(Long typeId) {
        return categoryMapper.list(typeId, BaseContext.getFamilyId());
    }
}
