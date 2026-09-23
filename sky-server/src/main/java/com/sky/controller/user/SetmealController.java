package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Setmeal;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.DishItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * ClassName: SetmealController
 * Package: com.sky.controller.user
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/23 14:55
 * @Version 1.0
 */
@RestController("userSetmealController")
@RequestMapping("/user/setmeal")
@Slf4j
@Api(tags = "用户端套餐管理")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据分类ID查询套餐列表
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询套餐列表")
    public Result<List<Setmeal>> getSetmeal(Long categoryId){
        log.info("查询套餐列表，分类ID：{}", categoryId);
        Setmeal setmeal = new Setmeal();
        setmeal.setCategoryId(categoryId);
        setmeal.setStatus(StatusConstant.ENABLE);

        List<Setmeal> setmealList = setmealService.list(setmeal);
        return Result.success(setmealList);
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @GetMapping("/dish/{id}")
    @ApiOperation("查询套餐详情")
    public Result<List<DishItemVO>> getSetmealDish(@PathVariable Long id){
        log.info("查询套餐详情，套餐ID：{}", id);
        List<DishItemVO> dishItemVOList = setmealService.getSetmealDish(id);
        return Result.success(dishItemVOList);
    }
}
