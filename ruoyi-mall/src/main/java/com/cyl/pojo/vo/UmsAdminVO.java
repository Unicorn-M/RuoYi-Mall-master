package com.cyl.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 用户信息表 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsAdminVO {
   /** 用户ID */
    private Long userId;
   /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;
   /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;
   /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;
   /** 用户类型（00系统用户） */
    @Excel(name = "用户类型", readConverterExp = "0=0系统用户")
    private String userType;
   /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;
   /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;
   /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;
   /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;
   /** 密码 */
    @Excel(name = "密码")
    private String password;
   /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;
   /** 最后登录IP */
    @Excel(name = "最后登录IP")
    private String loginIp;
   /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginDate;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
