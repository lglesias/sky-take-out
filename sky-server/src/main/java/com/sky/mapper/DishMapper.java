package com.sky.mapper;

import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO：
 * ClassName: DishMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/15 15:54
 * @Version 1.0
 */
@Mapper
public interface DishMapper {
    /**
     * 根据分类id统计菜品数量
     * @param id
     * @return
     */
    Integer countByCategoryId(Long id);

    /**
     * 根据条件查询菜品列表
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);
}
