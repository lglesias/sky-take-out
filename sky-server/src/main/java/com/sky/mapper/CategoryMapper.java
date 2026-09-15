package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import com.sky.annotation.AutoFill;

/**
 * TODO：
 * ClassName: CategoryMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/15 14:58
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper {
    /**
     * 分页查询分类数据
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     *修改分类
     * @param categoryDTO
     */
    @AutoFill(OperationType.UPDATE)
    void update(Category category);
}
