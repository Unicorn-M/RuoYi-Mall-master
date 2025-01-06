package com.cyl.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 贫困身份申请 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsApplicationDTO {
    private Integer id;
    private Integer userId;
    private String applyContent;
    private LocalDateTime createtime;
    private String contentName;
    private Integer status;
    private String explanation;
}
