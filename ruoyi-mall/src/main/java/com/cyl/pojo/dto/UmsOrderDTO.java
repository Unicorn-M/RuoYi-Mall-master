package com.cyl.pojo.dto;

import java.math.BigDecimal;
import lombok.Data;
/**
 * 订单 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsOrderDTO {
    private Integer id;
    private String pic;
    private String goodsName;
    private String username;
    private Integer orderid;
    private BigDecimal price;
    private String status;
    private Integer uid;
}
