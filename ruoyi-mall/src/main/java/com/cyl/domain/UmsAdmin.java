package com.cyl.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 用户信息表对象 sys_user
 * 
 * @author admin
 */
@ApiModel(description="用户信息表对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class UmsAdmin implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("部门ID")
    @Excel(name = "部门ID")
    private Long deptId;

    @ApiModelProperty("用户账号")
    @Excel(name = "用户账号")
    private String userName;

    @ApiModelProperty("用户昵称")
    @Excel(name = "用户昵称")
    private String nickName;

    @ApiModelProperty("用户类型（00系统用户）")
    @Excel(name = "用户类型", readConverterExp = "0=0系统用户")
    private String userType;

    @ApiModelProperty("用户邮箱")
    @Excel(name = "用户邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    @Excel(name = "手机号码")
    private String phonenumber;

    @ApiModelProperty("用户性别（0男 1女 2未知）")
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    @ApiModelProperty("头像地址")
    @Excel(name = "头像地址")
    private String avatar;

    @ApiModelProperty("密码")
    @Excel(name = "密码")
    private String password;

    @ApiModelProperty("帐号状态（0正常 1停用）")
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    @ApiModelProperty("最后登录IP")
    @Excel(name = "最后登录IP")
    private String loginIp;

    @ApiModelProperty("最后登录时间")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginDate;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;


}
