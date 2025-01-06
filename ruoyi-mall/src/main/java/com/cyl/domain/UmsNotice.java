package com.cyl.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 公告信息对象 ums_notice
 *
 * @author admin
 */
@ApiModel(description="公告信息对象")
@Data
@TableName("ums_notice")
public class UmsNotice implements Serializable {
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

    @ApiModelProperty("CREATE_PERSON")
    @Excel(name = "CREATE_PERSON")
    private String createPerson;

    @ApiModelProperty("DEL_FLAG")
    private Integer delFlag;

}
