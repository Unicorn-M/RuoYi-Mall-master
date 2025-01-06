package com.cyl.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 农家乐增删改查 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsFarmhouseDTO {
    private Integer id;
    private String pic;
    private String title;
    private String content;
    private LocalDateTime createtime;
}
