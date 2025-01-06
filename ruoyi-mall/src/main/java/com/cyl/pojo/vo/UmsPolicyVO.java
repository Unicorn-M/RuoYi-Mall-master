package com.cyl.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 扶贫信息增删改查 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsPolicyVO  {
   /** ID */
    private Integer id;
   /** TITLE */
    @Excel(name = "TITLE")
    private String title;
   /** CONTENT */
    @Excel(name = "CONTENT")
    private String content;
   /** CREATETIME */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;
}
