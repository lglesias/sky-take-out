package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO：修改套餐   批量删除套餐 根据id查询套餐
 * ClassName: SetmealController
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/16 13:35
 * @Version 1.0
 */
@Slf4j
@Api(tags = "套餐管理")
@RestController
@RequestMapping(("/admin/setmeal"))
public class SetmealController {
    @Autowired
    private SetmealService setmealService;


    /**
     * 分页查询套餐数据
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("分页查询套餐数据: {}", setmealPageQueryDTO);
        PageResult pageResult = setmealService.page(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增套餐
     * @param setmealDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result save(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐: {}", setmealDTO);
        setmealService.save(setmealDTO);
        return Result.success();
    }

    /**
     * 修改套餐状态
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("修改套餐状态")
    public Result updateStatus(@PathVariable Integer status, Long id) {
        log.info("修改套餐状态: {} {}", status, id);
        setmealService.updateStatus(status, id);
        return Result.success();
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<Setmeal> getById(@PathVariable Long id) {
        log.info("根据id查询套餐: {}", id);
        Setmeal setmeal = setmealService.getById(id);
        return Result.success(setmeal);
    }
}
