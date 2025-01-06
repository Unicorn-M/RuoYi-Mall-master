package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯信息增删改查 查询 对象
 *
 * @author admin
 */
@ApiModel(description="资讯信息增删改查 查询 对象")
@Data
public class UmsInfomationQuery {
    @ApiModelProperty("TITLE 精确匹配")
    private String title;

    @ApiModelProperty("CONTENT 精确匹配")
    private String content;

    @ApiModelProperty("CREATETIME 精确匹配")
    private LocalDateTime createtime;

}
