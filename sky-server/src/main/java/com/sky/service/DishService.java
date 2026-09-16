package com.sky.service;

import com.sky.entity.Dish;

import java.util.List;

/**
 * TODO：
 * ClassName: DishService
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/16 14:14
 * @Version 1.0
 */
public interface DishService {
    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> list(Long categoryId);

}
