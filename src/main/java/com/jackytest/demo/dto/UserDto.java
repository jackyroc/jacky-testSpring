package com.jackytest.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author JackyRoc
 * @version 1.0
 * @date 2020/9/10 16:21
 */
@ApiModel(value = "用户数据",description = "请求类")
@Data
public class UserDto {
    @ApiModelProperty(value = "用户名",example = "username",required = true)
    private String name;
    @ApiModelProperty(value = "密码",example = "pwd12345",required = true)
    private String pwd;

}
