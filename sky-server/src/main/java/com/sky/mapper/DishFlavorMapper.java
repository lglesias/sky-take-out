package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO：
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
}
