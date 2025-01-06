package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 贫困身份申请 查询 对象
 *
 * @author admin
 */
@ApiModel(description="贫困身份申请 查询 对象")
@Data
public class UmsApplicationQuery {
    @ApiModelProperty("USER_ID 精确匹配")
    private Integer userId;

    @ApiModelProperty("APPLY_CONTENT 精确匹配")
    private String applyContent;

    @ApiModelProperty("CREATETIME 精确匹配")
    private LocalDateTime createtime;

    @ApiModelProperty("上传贫困资料的名字 精确匹配")
    private String contentNameLike;

    @ApiModelProperty("0表示待审核，1表示审核通过 精确匹配")
    private Integer status;

    @ApiModelProperty("审核说明 精确匹配")
    private String explanation;

}
