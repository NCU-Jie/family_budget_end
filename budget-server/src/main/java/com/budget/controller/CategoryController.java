package com.budget.controller;

import com.budget.dto.CategoryDTO;
import com.budget.dto.CategoryPageQueryDTO;
import com.budget.exception.CategoryAlreadyExistsException;
import com.budget.result.PageResult;
import com.budget.result.Result;
import com.budget.service.CategoryService;
import com.budget.vo.CategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("budget/category")
@Slf4j
@Api(tags="分类相关接口")
public class CategoryController {
    @Autowired
    CategoryService  categoryService;
    @ApiOperation("添加分类")
    @PostMapping("/add")
    public Result add(@RequestBody CategoryDTO categoryDTO) {
        try {
            log.info("添加分类：{}", categoryDTO);
            categoryService.addCategory(categoryDTO);
            return Result.success();
        } catch (CategoryAlreadyExistsException e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("分页查询分类")
    @GetMapping("/pageQuery")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询分类：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @ApiOperation("根据id删除分类")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        log.info("根据id删除分类：{}", id);
        categoryService.delete(id);
        return Result.success();
    }

    @ApiOperation("修改分类")
    @PutMapping()
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类：{}", categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    @ApiOperation("根据字符串查找分类")
    @PostMapping("/findByName")
    public Result<List<CategoryVO>> findByName(@RequestBody CategoryDTO categoryDTO){
        log.info("根据字符串查找分类：{}", categoryDTO);
        List<CategoryVO> categoryVOList= categoryService.findByName(categoryDTO);
        return Result.success(categoryVOList);
    }


}
