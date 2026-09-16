package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO：
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
}
