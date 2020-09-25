package com.jackytest.demo.service;

import com.jackytest.demo.common.ResultDto;
import com.jackytest.demo.dto.UserDto;
import com.jackytest.demo.entity.TestUser;

/**
 * @author JackyRoc
 * @version 1.0
 * @date 2020/9/15 14:17
 */
public interface TestUserService {

    /**
     * 保存数据
     * @param testUser
     * @return
     */
    public ResultDto<TestUser> save(TestUser testUser);

    public String update(UserDto userDto);
}
