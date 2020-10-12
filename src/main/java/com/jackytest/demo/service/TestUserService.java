package com.jackytest.demo.service;

import com.jackytest.demo.common.ResultDto;
import com.jackytest.demo.dto.UserDto;
import com.jackytest.demo.entity.TestUser;

import java.util.List;

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
    ResultDto<TestUser> save(TestUser testUser);

    /**
     * 更新数据
     * @param testUser
     * @return
     */
    ResultDto<TestUser> update(TestUser testUser);

    /**
     * 根据Id和Name模糊查询
     * @param testUser
     * @return
     */
    ResultDto<List<TestUser>> getByName(TestUser testUser);

    /**
     * 根据Id和Name删除用户
     * @param testUser
     * @return
     */
    ResultDto<TestUser> deleteUser(TestUser testUser);
}
