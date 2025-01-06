package com.cyl.pojo.query;

import java.math.BigDecimal;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品信息 查询 对象
 *
 * @author admin
 */
@ApiModel(description="商品信息 查询 对象")
@Data
public class UmsGoodsQuery {
    @ApiModelProperty("PIC 精确匹配")
    private String pic;

    @ApiModelProperty("NAME 精确匹配")
    private String nameLike;

    @ApiModelProperty("PRICE 精确匹配")
    private BigDecimal price;

    @ApiModelProperty("COUNT 精确匹配")
    private Integer count;

    @ApiModelProperty("SALE_NUMBER 精确匹配")
    private Integer saleNumber;

}
