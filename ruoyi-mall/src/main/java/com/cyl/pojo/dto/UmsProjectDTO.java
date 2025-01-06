package com.cyl.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 扶贫项目申请增删改查 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsProjectDTO {
    private Integer id;
    private Integer userId;
    private String applyContent;
    private LocalDateTime createtime;
    private String contentName;
    private Integer status;
    private String explanation;
}
