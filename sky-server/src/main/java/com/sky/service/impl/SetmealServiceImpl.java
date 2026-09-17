package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.exception.SetmealEnableFailedException;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * ClassName: SetmealServiceImpl
 * Package: com.sky.service.impl
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/16 13:37
 * @Version 1.0
 */
@Service
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealMapper setmealMapper;

    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Autowired
    private DishMapper dishMapper;

    /**
     * 套餐分页查询
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
        Page<Setmeal> page = setmealMapper.page(setmealPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 新增套餐
     *
     * @param setmealDTO
     */
    @Override
    @Transactional
    public void save(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        //设置创建时间和更新时间
        setmeal.setCreateTime(LocalDateTime.now());
        setmeal.setUpdateTime(LocalDateTime.now());
        //设置创建人和更新人为当前登录员工的id
        setmeal.setCreateUser(BaseContext.getCurrentId());
        setmeal.setUpdateUser(BaseContext.getCurrentId());

        //向套餐表插入数据
        setmealMapper.insert(setmeal);

        //获取插入数据的id
        Long setmealId = setmeal.getId();

        //设置id
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        setmealDishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmealId);
        });
        //保存套餐和菜品的关联数据
        setmealDishMapper.insertBatch(setmealDishes);

    }

    /**
     * 修改套餐状态
     *
     * @param status
     * @param id
     */
    @Override
    @Transactional
    public void updateStatus(Integer status, Long id) {
        if (status == StatusConstant.ENABLE) {
            List<Dish> dishIds = dishMapper.getBySetmealId(id);
            if (dishIds != null && dishIds.size() > 0) {
                dishIds.forEach(dish -> {
                    if (StatusConstant.DISABLE == dish.getStatus()) {
                        throw new SetmealEnableFailedException(MessageConstant.SETMEAL_ENABLE_FAILED);
                    }
                });
            }
        }

        Setmeal setmeal = Setmeal.builder()
                .id(id)
                .status(status)
                .updateTime(LocalDateTime.now())
                .updateUser(BaseContext.getCurrentId())
                .build();
        setmealMapper.update(setmeal);
    }

    /**
     * 根据id查询套餐
     *
     * @param id
     * @return
     */
    @Override
    public SetmealVO getById(Long id) {
        SetmealVO setmealVO = new SetmealVO();

        //查询套餐基本信息
        Setmeal setmeal = setmealMapper.getById(id);
        BeanUtils.copyProperties(setmeal, setmealVO);

        //查询套餐和菜品的关联信息
        List<SetmealDish> setmealDishes = setmealDishMapper.getBySetmealId(id);
        setmealVO.setSetmealDishes(setmealDishes);
        return setmealVO;

    }

    /**
     * 修改套餐
     *
     * @param setmealDTO
     */
    @Override
    @Transactional
    public void update(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        //设置更新时间和更新人
        setmeal.setUpdateTime(LocalDateTime.now());
        setmeal.setUpdateUser(BaseContext.getCurrentId());
        //修改套餐
        setmealMapper.update(setmeal);
        //套餐id
        Long id = setmealDTO.getId();

        //删除套餐和菜品的关联数据
        setmealDishMapper.deleteBySetmealId(id);

        //设置id
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        setmealDishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(id);
        });
        //保存套餐和菜品的关联数据
        setmealDishMapper.insertBatch(setmealDishes);
    }

    /**
     * 批量删除套餐
     *
     * @param ids
     */
    @Override
    @Transactional
    public void delete(List<Long> ids) {
        //在售的套餐不能删除
        ids.forEach(id -> {
            Setmeal setmeal = setmealMapper.getById(id);
            if (StatusConstant.ENABLE == setmeal.getStatus()) {
                throw new SetmealEnableFailedException(MessageConstant.DISH_ON_SALE);
            }
        });
        ids.forEach(id -> {
            //删除菜品数据
            setmealMapper.delete(id);

            //删除套餐和菜品的关联数据
            setmealDishMapper.deleteBySetmealId(id);

        });
    }
}
