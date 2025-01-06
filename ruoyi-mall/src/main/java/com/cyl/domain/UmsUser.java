package com.cyl.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 农家信息增删改查对象 ums_user
 * 
 * @author admin
 */
@ApiModel(description="农家信息增删改查对象")
@Data
@TableName("ums_user")
public class UmsUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("头像")
    @Excel(name = "头像")
    private String pic;

    @ApiModelProperty("USERNAME")
    @Excel(name = "USERNAME")
    private String username;

    @ApiModelProperty("NICK_NAME")
    @Excel(name = "NICK_NAME")
    private String nickName;

    @ApiModelProperty("TELE")
    @Excel(name = "TELE")
    private String tele;

    @ApiModelProperty("EMAIL")
    @Excel(name = "EMAIL")
    private String email;

    @ApiModelProperty("0表示普通用户，1表示贫困户")
    @Excel(name = "0表示普通用户，1表示贫困户")
    private Integer isPoor;

    @ApiModelProperty("MONEY")
    @Excel(name = "MONEY")
    private String money;

}
