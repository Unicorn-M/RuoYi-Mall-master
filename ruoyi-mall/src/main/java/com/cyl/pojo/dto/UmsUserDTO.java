package com.cyl.pojo.dto;

import lombok.Data;
/**
 * 农家信息增删改查 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsUserDTO {
    private Integer id;
    private String pic;
    private String username;
    private String nickName;
    private String tele;
    private String email;
    private Integer isPoor;
    private String money;
}
