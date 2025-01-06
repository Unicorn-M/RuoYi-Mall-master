package com.cyl.pojo.query;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 农家信息增删改查 查询 对象
 *
 * @author admin
 */
@ApiModel(description="农家信息增删改查 查询 对象")
@Data
public class UmsUserQuery{
    @ApiModelProperty("头像 精确匹配")
    private String pic;

    @ApiModelProperty("USERNAME 精确匹配")
    private String usernameLike;

    @ApiModelProperty("NICK_NAME 精确匹配")
    private String nickNameLike;

    @ApiModelProperty("TELE 精确匹配")
    private String tele;

    @ApiModelProperty("EMAIL 精确匹配")
    private String email;

    @ApiModelProperty("0表示普通用户，1表示贫困户 精确匹配")
    private Integer isPoor;

    @ApiModelProperty("MONEY 精确匹配")
    private String money;

}
