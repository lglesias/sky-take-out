package com.sky.controller.admin;

import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO：
 * ClassName: DishController
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/16 14:10
 * @Version 1.0
 */
@RequestMapping("/admin/dish")
@RestController
@Slf4j
@Api(tags = "菜品管理")
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 根据分类id查询菜品
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> list(Long categoryId){
        log.info("根据分类id查询菜品:{}", categoryId);
        List<Dish> dishList = dishService.list(categoryId);
        return Result.success(dishList);
    }
}
