package com.jackytest.demo.dto;

import com.jackytest.demo.entity.BaseEntityNew;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author JackyRoc
 * @date 2020/9/25 16:02
 */
@ApiModel(value = "用户注册类",description = "请求类")
@Data
public class AddTestUserDto extends BaseEntityNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",example = "username",required = true)
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",example = "12345678",required = true)
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",example = "email@123.com")
    private String email;

    /**
     * 自动生成用例job名称 不为空时表示已经创建job
     */
    @ApiModelProperty(value = "用例job名称",example = "abc")
    private String autoCreateCaseJobName;

    /**
     * 测试执行job名称 不为空时表示已经创建job
     */
    @ApiModelProperty(value = "执行job名称",example = "abc")
    private String startTestJobName;

    /**
     * 默认jenkins服务器
     */
    @ApiModelProperty(value = "jenkins服务器",example = "1.1.1.1")
    private Integer defaultJenkinsId;
}
