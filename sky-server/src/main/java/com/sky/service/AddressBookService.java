package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

/**
 * TODO：
 * ClassName: AddressBookService
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/24 14:13
 * @Version 1.0
 */
public interface AddressBookService {
    /**
     * 查询当前登录用户的所有地址信息
     * @param addressBook
     * @return
     */
    List<AddressBook> list(AddressBook addressBook);
}
