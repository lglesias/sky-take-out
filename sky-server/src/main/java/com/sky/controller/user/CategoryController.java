package com.sky.controller.user;

import com.sky.entity.Category;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * ClassName: CategoryController
 * Package: com.sky.controller.user
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/23 14:34
 * @Version 1.0
 */
@RestController("userCategoryController")
@RequestMapping("/user/category")
@Api(tags = "分类管理")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据类型查询分类列表
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "分类列表")
    @Cacheable(value = "categoryCache", key = "#type")
    public Result<List<Category>> list(Integer type){
        log.info("查询分类列表: {}", type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}
