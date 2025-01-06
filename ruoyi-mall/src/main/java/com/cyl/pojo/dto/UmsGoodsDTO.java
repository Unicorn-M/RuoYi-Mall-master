package com.cyl.pojo.dto;

import java.math.BigDecimal;
import lombok.Data;
/**
 * 商品信息 DTO 对象
 *
 * @author admin
 */
@Data
public class UmsGoodsDTO {
    private Integer id;
    private String pic;
    private String name;
    private BigDecimal price;
    private Integer count;
    private Integer saleNumber;
}
