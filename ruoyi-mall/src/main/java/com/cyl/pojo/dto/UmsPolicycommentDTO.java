package com.cyl.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 扶贫政策评论增删改查 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsPolicycommentDTO {
    private Integer id;
    private String nickName;
    private String content;
    private String policyContent;
    private LocalDateTime createtime;
}
