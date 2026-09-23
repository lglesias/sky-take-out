package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.Removal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * ClassName: DishController
 * Package: com.sky.controller.user
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/23 14:39
 * @Version 1.0
 */
@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "用户端菜品管理")
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 条件查询菜品和口味
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("条件查询菜品和口味")
    public Result<List<DishVO>> list(Long categoryId){
        log.info("根据分类查询菜品列表，分类ID：{}", categoryId);
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);
        List<DishVO> dishVOList = dishService.listWithFlavor(dish);
        return Result.success(dishVOList);
    }
}
