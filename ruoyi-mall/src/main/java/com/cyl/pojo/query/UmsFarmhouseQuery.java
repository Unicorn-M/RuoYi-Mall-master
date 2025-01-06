package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 农家乐增删改查 查询 对象
 *
 * @author admin
 */
@ApiModel(description="农家乐增删改查 查询 对象")
@Data
public class UmsFarmhouseQuery {
    @ApiModelProperty("PIC 精确匹配")
    private String pic;

    @ApiModelProperty("TITLE 精确匹配")
    private String title;

    @ApiModelProperty("CONTENT 精确匹配")
    private String content;

    @ApiModelProperty("CREATETIME 精确匹配")
    private LocalDateTime createtime;

}
