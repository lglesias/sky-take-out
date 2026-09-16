package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO：
 * ClassName: SetmealMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/15 15:58
 * @Version 1.0
 */
@Mapper
public interface SetmealMapper {
    /**
     * 根据分类id统计套餐数量
     * @param id
     * @return
     */
    Integer countByCategoryId(Long id);

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    Page<Setmeal> page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 新增套餐
     * @param setmeal
     */
    void insert(Setmeal setmeal);
}
