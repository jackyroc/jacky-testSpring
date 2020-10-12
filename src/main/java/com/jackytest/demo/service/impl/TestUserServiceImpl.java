package com.jackytest.demo.service.impl;

import com.jackytest.demo.common.ResultDto;
import com.jackytest.demo.dao.TestUserMapper;
import com.jackytest.demo.entity.TestUser;
import com.jackytest.demo.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author JackyRoc
 * @version 1.0
 * @date 2020/9/15 14:17
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private TestUserMapper testUserMapper;

    /**
     * 保存数据
     * @param testUser
     * @return
     */
    @Override
    public ResultDto<TestUser> save(TestUser testUser){

        testUser.setCreateTime(new Date());
        testUser.setUpdateTime(new Date());
        testUserMapper.insertUseGeneratedKeys(testUser);

        return ResultDto.success("注册成功", testUser);
    }

    @Override
    public ResultDto<TestUser> update(TestUser testUser) {

        testUser.setUpdateTime(new Date());
        testUserMapper.updateByPrimaryKeySelective(testUser);

        return ResultDto.success("修改成功", testUser);
    }

    @Override
    public ResultDto<List<TestUser>> getByName(TestUser testUser) {

//        List<TestUser> testUserList = testUserMapper.select(testUser);
        List<TestUser> testUserList = testUserMapper.getByName(testUser.getUserName(),testUser.getId());
        return ResultDto.success("查询成功", testUserList);
    }

    @Override
    public ResultDto<TestUser> deleteUser(TestUser testUser) {

        testUserMapper.deleteByPrimaryKey(testUser);

        return ResultDto.success("删除成功", testUser);
    }


}
