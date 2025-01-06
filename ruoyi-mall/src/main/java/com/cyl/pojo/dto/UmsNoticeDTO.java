package com.cyl.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 公告信息 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsNoticeDTO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createtime;
    private String createPerson;
}

