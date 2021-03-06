package com.jackytest.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jackytest.demo.common.ResultDto;
import com.jackytest.demo.common.ServiceException;
import com.jackytest.demo.dto.AddTestUserDto;
import com.jackytest.demo.dto.UpdateTestUserDto;
import com.jackytest.demo.dto.UserDto;
import com.jackytest.demo.entity.TestUser;
import com.jackytest.demo.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("注册接口")
    @PostMapping("reg")
    public ResultDto<TestUser> reg(@RequestBody AddTestUserDto addTestUserDto){
        TestUser testUser = new TestUser();
        BeanUtils.copyProperties(addTestUserDto, testUser);

        if(StringUtils.isEmpty(addTestUserDto.getUserName())){
            return ResultDto.fail("用户名不能为空");
        }

        if(StringUtils.isEmpty(addTestUserDto.getPassword())){
            return ResultDto.fail("密码不能为空");
        }

        log.info("用户注册，请求入参："+ JSONObject.toJSONString(testUser));

        return testUserService.save(testUser);
    }
//    public String reg(@RequestBody UserDto userDto){
//        String reg = testUserService.reg(userDto);
//        return "成功注册：" + reg;
//    }

    @ApiOperation("用户信息修改接口")
    @PutMapping("updateUser")
    public ResultDto<TestUser> updateUserInfo(@RequestBody UpdateTestUserDto updateTestUserDto){
        TestUser testUser = new TestUser();
        BeanUtils.copyProperties(updateTestUserDto, testUser);

        if(StringUtils.isEmpty(updateTestUserDto.getUserName())){
            return ResultDto.fail("用户名不能为空");
        }

        if(StringUtils.isEmpty(updateTestUserDto.getPassword())){
            return ResultDto.fail("密码不能为空");
        }

        log.info("用户注册，请求入参："+ JSONObject.toJSONString(testUser));

        return testUserService.update(testUser);
    }

    @ApiOperation("业务接口-byId")
    @GetMapping("byId/{id}")
    public String getId(@PathVariable("id") Long id){
        System.out.println("id:"+id);
        return "id=" + id;
    }

    @ApiOperation("业务接口-byId2")
    @GetMapping("byId")
    public String byId(@RequestParam("id") Long id,@RequestParam(value = "user",required = false) String user){
        System.out.println("id="+id);
        System.out.println("user="+user);

        return "id=" + id + ",user=" + user;
    }

    @ApiOperation("查询接口-byName")
    @GetMapping("getByName")
    public ResultDto<List<TestUser>> getByName(@RequestParam(value = "userId", required = false) Integer userId, @RequestParam(value = "userName", required = false) String userName  ){
        TestUser testUser = new TestUser();
        testUser.setId(userId);
        testUser.setUserName(userName);

        log.info("用户查询，请求入参："+ JSONObject.toJSONString(testUser));

        return testUserService.getByName(testUser);
    }

    @ApiOperation("用户删除接口-byId")
    @DeleteMapping("deleteUser")
    public ResultDto<TestUser> deleteUser(@RequestParam(value = "userId") Integer userId){
        TestUser testUser = new TestUser();
        testUser.setId(userId);

        log.info("用户删除，请求入参："+ JSONObject.toJSONString(testUser));

        return testUserService.deleteUser(testUser);
    }

}
