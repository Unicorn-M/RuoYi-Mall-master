package com.cyl.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 农家乐增删改查对象 ums_farmhouse
 * 
 * @author admin
 */
@ApiModel(description="农家乐增删改查对象")
@Data
@TableName("ums_farmhouse")
public class UmsFarmhouse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("PIC")
    @Excel(name = "PIC")
    private String pic;

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
