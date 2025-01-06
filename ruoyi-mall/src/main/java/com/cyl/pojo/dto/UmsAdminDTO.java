package com.cyl.pojo.dto;

import java.time.LocalDateTime;

import lombok.Data;
/**
 * 用户信息表 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsAdminDTO{
    private Long userId;
    private Long deptId;
    private String userName;
    private String nickName;
    private String userType;
    private String email;
    private String phonenumber;
    private String sex;
    private String avatar;
    private String password;
    private String status;
    private String loginIp;
    private LocalDateTime loginDate;
    private String remark;
}
