package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 *
 * ClassName: UserService
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/23 12:09
 * @Version 1.0
 */
public interface UserService {

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
