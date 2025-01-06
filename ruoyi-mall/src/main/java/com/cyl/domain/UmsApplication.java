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
 * 贫困身份申请对象 ums_application
 * 
 * @author admin
 */
@ApiModel(description="贫困身份申请对象")
@Data
@TableName("ums_application")
public class UmsApplication implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId
    private Integer id;

    @ApiModelProperty("USER_ID")
    @Excel(name = "USER_ID")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private Integer userId;

    @ApiModelProperty("USERNAME")
    @Excel(name = "username")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private String username;

    @ApiModelProperty("APPLY_CONTENT")
    @Excel(name = "APPLY_CONTENT")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private String applyContent;

    @ApiModelProperty("CREATETIME")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private LocalDateTime createtime;

    @ApiModelProperty("上传贫困资料的名字")
    @Excel(name = "上传贫困资料的名字")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private String contentName;

    @ApiModelProperty("0表示待审核，1表示审核通过")
    @Excel(name = "0表示待审核，1表示审核通过")
    private Integer status;

    @ApiModelProperty("审核说明")
    @Excel(name = "审核说明")
    private String explanation;

}
