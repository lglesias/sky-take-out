package com.sky.controller.admin;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO：修改套餐  分页查询 套餐起售、停售 批量删除套餐 新增套餐 根据id查询套餐
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
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("分页查询套餐数据: {}", setmealPageQueryDTO);
        PageResult pageResult = setmealService.page(setmealPageQueryDTO);
        return Result.success(pageResult);
    }
}
