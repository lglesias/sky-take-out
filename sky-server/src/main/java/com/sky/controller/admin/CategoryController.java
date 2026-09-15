package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO：
 * ClassName: CategoryController
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/15 14:57
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询分类数据
     *
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询分类数据: {}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改分类
     *
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result<String> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类: {}", categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用分类
     *
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        log.info("修改分类状态: {}", status);
        categoryService.startOrStop(status, id);
        return Result.success();
    }
}
