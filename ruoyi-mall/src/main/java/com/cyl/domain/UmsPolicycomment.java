package com.cyl.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 扶贫政策评论增删改查对象 ums_policycomment
 * 
 * @author admin
 */
@ApiModel(description="扶贫政策评论增删改查对象")
@Data
@TableName("ums_policycomment")
public class UmsPolicycomment implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("NICK_NAME")
    @Excel(name = "NICK_NAME")
    private String nickName;

    @ApiModelProperty("CONTENT")
    @Excel(name = "CONTENT")
    private String content;

    @ApiModelProperty("POLICY_CONTENT")
    @Excel(name = "POLICY_CONTENT")
    private String policyContent;

    @ApiModelProperty("CREATETIME")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;

}
