package com.cyl.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公告信息 查询 对象
 *
 * @author admin
 */
@ApiModel(description="公告信息 查询 对象")
@Data
public class UmsNoticeQuery {
@ApiModelProperty("TITLE 精确匹配")
private String title;

@ApiModelProperty("CONTENT 精确匹配")
private String content;

@ApiModelProperty("CREATETIME 精确匹配")
private LocalDateTime createtime;

@ApiModelProperty("CREATE_PERSON 精确匹配")
private String createPerson;

}

