package com.cyl.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 扶贫项目申请增删改查对象 ums_project
 * 
 * @author admin
 */
@ApiModel(description="扶贫项目申请增删改查对象")
@Data
@TableName("ums_project")
public class UmsProject implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId
    private Integer id;

    @ApiModelProperty("USERNAME")
    @Excel(name = "username")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private String username;

    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("USER_ID")
    @Excel(name = "USER_ID")
    private Integer userId;

    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("APPLY_CONTENT")
    @Excel(name = "APPLY_CONTENT")
    private String applyContent;

    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("CREATETIME")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;

    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("CONTENT_NAME")
    @Excel(name = "CONTENT_NAME")
    private String contentName;

    @ApiModelProperty("0表示审核不通过，1表示审核通过")
    @Excel(name = "0表示审核不通过，1表示审核通过")
    private Integer status;

    @ApiModelProperty("审核说明")
    @Excel(name = "审核说明")
    private String explanation;

}
