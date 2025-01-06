package com.cyl.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 扶贫信息增删改查 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsPolicyDTO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createtime;
}
