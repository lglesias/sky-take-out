package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;

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
    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);
}
