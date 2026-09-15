package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

/**
 * TODO：
 * ClassName: CategoryService
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/15 14:58
 * @Version 1.0
 */
public interface CategoryService {
    /**
     * 分页查询分类数据
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 启用禁用分类
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);
}
