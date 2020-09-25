package com.jackytest.demo.service.impl;

import com.jackytest.demo.common.ResultDto;
import com.jackytest.demo.dao.TestUserMapper;
import com.jackytest.demo.dto.UserDto;
import com.jackytest.demo.entity.TestUser;
import com.jackytest.demo.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public String update(UserDto userDto){
        System.out.println("userDto.Name:"+userDto.getName());
        System.out.println("userDto.Pwd:"+userDto.getPwd());

        return userDto.getName() + "--" + userDto.getPwd();
    }
}
