package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 扶贫项目申请增删改查 查询 对象
 *
 * @author admin
 */
@ApiModel(description="扶贫项目申请增删改查 查询 对象")
@Data
public class UmsProjectQuery {
    @ApiModelProperty("USER_ID 精确匹配")
    private Integer userId;

    @ApiModelProperty("APPLY_CONTENT 精确匹配")
    private String applyContent;

    @ApiModelProperty("CREATETIME 精确匹配")
    private LocalDateTime createtime;

    @ApiModelProperty("CONTENT_NAME 精确匹配")
    private String contentNameLike;

    @ApiModelProperty("0表示审核不通过，1表示审核通过 精确匹配")
    private Integer status;

    @ApiModelProperty("审核说明 精确匹配")
    private String explanation;

}
