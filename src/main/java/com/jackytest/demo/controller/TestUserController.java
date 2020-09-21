package com.jackytest.demo.controller;

import com.jackytest.demo.common.ResultDto;
import com.jackytest.demo.common.ServiceException;
import com.jackytest.demo.dto.UserDto;
import com.jackytest.demo.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author JackyRoc
 * @version 1.0
 * @date 2020/9/10 15:58
 */
@Api(tags = "测试管理项目")
@RestController
@Slf4j
public class TestUserController {
    @Autowired
    private TestUserService testUserService;

    @Value("${url.url1}")
    private String url;

//    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation("登录接口")
    @PostMapping("login")
    public ResultDto<UserDto> login(@RequestBody UserDto userDto){
        System.out.println("userDto.Name:"+userDto.getName());
        System.out.println("userDto.Pwd:"+userDto.getPwd());
        if(userDto.getName().contains("error")){
            ServiceException.throwEx("用户名中含有error");
        }
        if(userDto.getName().contains("error2")){
            throw new NullPointerException();
        }

        return ResultDto.success("登录成功," + url, userDto);
    }

    @PostMapping("reg")
    public String reg(@RequestBody UserDto userDto){
        String reg = testUserService.reg(userDto);
        return "成功注册：" + reg;
    }

    @GetMapping("byId/{id}")
    public String getId(@PathVariable("id") Long id){
        System.out.println("id:"+id);
        return "id=" + id;
    }

    @GetMapping("byId")
    public String byId(@RequestParam("id") Long id,@RequestParam(value = "user",required = false) String user){
        System.out.println("id="+id);
        System.out.println("user="+user);

        return "id=" + id + ",user=" + user;
    }
}
