package com.cyl.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 贫困身份申请 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsApplicationVO  {
   /** ID */
    private Integer id;
   /** USER_ID */
    @Excel(name = "USER_ID")
    private Integer userId;
   /** APPLY_CONTENT */
    @Excel(name = "APPLY_CONTENT")
    private String applyContent;
   /** CREATETIME */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "CREATETIME", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;
   /** 上传贫困资料的名字 */
    @Excel(name = "上传贫困资料的名字")
    private String contentName;
   /** 0表示待审核，1表示审核通过 */
    @Excel(name = "0表示待审核，1表示审核通过")
    private Integer status;
   /** 审核说明 */
    @Excel(name = "审核说明")
    private String explanation;
}
