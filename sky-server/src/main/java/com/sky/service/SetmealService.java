package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;

/**
 *
 * ClassName: SetmealService
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/16 13:37
 * @Version 1.0
 */
public interface SetmealService {
    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 新增套餐
     * @param setmealDTO
     */
    void save( SetmealDTO setmealDTO);

    /**
     * 修改套餐状态
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Long id);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    Setmeal getById(Long id);
}
