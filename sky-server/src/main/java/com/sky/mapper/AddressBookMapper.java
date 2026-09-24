package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO：
 * ClassName: AddressBookMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/24 14:12
 * @Version 1.0
 */
@Mapper
public interface AddressBookMapper {
    /**
     * 查询当前登录用户的所有地址信息
     * @param addressBook
     * @return
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 保存地址信息
     * @param addressBook
     */
    void insert(AddressBook addressBook);
}
