package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息表 查询 对象
 *
 * @author admin
 */
@ApiModel(description="用户信息表 查询 对象")
@Data
public class UmsAdminQuery {
    @ApiModelProperty("部门ID 精确匹配")
    private Long deptId;

    @ApiModelProperty("用户账号 精确匹配")
    private String userNameLike;

    @ApiModelProperty("用户昵称 精确匹配")
    private String nickNameLike;

    @ApiModelProperty("用户类型（00系统用户） 精确匹配")
    private String userType;

    @ApiModelProperty("用户邮箱 精确匹配")
    private String email;

    @ApiModelProperty("手机号码 精确匹配")
    private String phonenumber;

    @ApiModelProperty("用户性别（0男 1女 2未知） 精确匹配")
    private String sex;

    @ApiModelProperty("头像地址 精确匹配")
    private String avatar;

    @ApiModelProperty("密码 精确匹配")
    private String password;

    @ApiModelProperty("帐号状态（0正常 1停用） 精确匹配")
    private String status;

    @ApiModelProperty("最后登录IP 精确匹配")
    private String loginIp;

    @ApiModelProperty("最后登录时间 精确匹配")
    private LocalDateTime loginDate;

}
