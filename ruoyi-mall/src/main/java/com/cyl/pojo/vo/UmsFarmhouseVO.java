package com.cyl.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 农家乐增删改查 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsFarmhouseVO  {
   /** ID */
    private Integer id;
   /** PIC */
    @Excel(name = "PIC")
    private String pic;
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
