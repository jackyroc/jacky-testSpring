package com.jackytest.demo.service.impl;

import com.jackytest.demo.dto.UserDto;
import com.jackytest.demo.service.TestUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author JackyRoc
 * @version 1.0
 * @date 2020/9/15 14:17
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Override
    public String reg(UserDto userDto){
        System.out.println("userDto.Name:"+userDto.getName());
        System.out.println("userDto.Pwd:"+userDto.getPwd());

        return userDto.getName() + "--" + userDto.getPwd();
    }
}
