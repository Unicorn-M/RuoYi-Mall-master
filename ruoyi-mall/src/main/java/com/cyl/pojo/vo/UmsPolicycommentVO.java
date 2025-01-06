package com.cyl.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 扶贫政策评论增删改查 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsPolicycommentVO  {
   /** ID */
    private Integer id;
   /** NICK_NAME */
    @Excel(name = "NICK_NAME")
    private String nickName;
   /** CONTENT */
    @Excel(name = "CONTENT")
    private String content;
   /** POLICY_CONTENT */
    @Excel(name = "POLICY_CONTENT")
    private String policyContent;
   /** CREATETIME */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;
}
