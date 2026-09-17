package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * ClassName: SetmealDishMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/16 14:36
 * @Version 1.0
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 批量插入套餐菜品数据
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 判断当前菜品是否被套餐关联了
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> ids);

    /**
     * 删除套餐和菜品的关联数据
     * @param id
     */
    void deleteBySetmealId(Long id);

    /**
     * 根据菜品id查询套餐
     * @param id
     * @return
     */
    List<SetmealDish> getBySetmealId(Long id);
}
