package com.cyl.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 资讯信息增删改查对象 ums_infomation
 * 
 * @author admin
 */
@ApiModel(description="资讯信息增删改查对象")
@Data
@TableName("ums_infomation")
public class UmsInfomation implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("TITLE")
    @Excel(name = "TITLE")
    private String title;

    @ApiModelProperty("CONTENT")
    @Excel(name = "CONTENT")
    private String content;

    @ApiModelProperty("CREATETIME")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;

}
