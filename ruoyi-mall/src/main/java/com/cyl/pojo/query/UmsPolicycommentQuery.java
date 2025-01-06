package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 扶贫政策评论增删改查 查询 对象
 *
 * @author admin
 */
@ApiModel(description="扶贫政策评论增删改查 查询 对象")
@Data
public class UmsPolicycommentQuery {
    @ApiModelProperty("NICK_NAME 精确匹配")
    private String nickNameLike;

    @ApiModelProperty("CONTENT 精确匹配")
    private String content;

    @ApiModelProperty("POLICY_CONTENT 精确匹配")
    private String policyContent;

    @ApiModelProperty("CREATETIME 精确匹配")
    private LocalDateTime createtime;

}
