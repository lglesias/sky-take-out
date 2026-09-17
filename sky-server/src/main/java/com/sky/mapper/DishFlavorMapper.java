package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: DishFlavorMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/17 15:19
 * @Version 1.0
 */
@Mapper
public interface DishFlavorMapper {
    /**
     * 根据菜品id查询口味数据
     * @param id
     * @return
     */
    List<DishFlavor> getFlavorsById(Long id);

    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味数据
     * @param id
     */
    void deleteByDishId(Long id);

    /**
     * 根据菜品id删除口味数据
     * @param id
     */
    void deleteByDishIds(Long id);
}
