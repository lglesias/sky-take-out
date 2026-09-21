package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺管理
 * ClassName: ShopController
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/21 15:32
 * @Version 1.0
 */
@Slf4j
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺管理")
public class ShopController {

    public static final String REDIS_KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 修改店铺状态
     *
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("修改店铺状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("修改店铺状态: {}", status);
        redisTemplate.opsForValue().set(REDIS_KEY, status);
        return Result.success();
    }

    /**
     * 获取店铺状态
     *
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(REDIS_KEY);
        log.info("获取店铺状态: {}", status);
        return Result.success(status);
    }
}
