package com.cyl.pojo.query;
import java.math.BigDecimal;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单 查询 对象
 *
 * @author admin
 */
@ApiModel(description="订单 查询 对象")
@Data
public class UmsOrderQuery {
    @ApiModelProperty("PIC 精确匹配")
    private String pic;

    @ApiModelProperty("GOODS_NAME 精确匹配")
    private String goodsNameLike;

    @ApiModelProperty("USERNAME 精确匹配")
    private String usernameLike;

    @ApiModelProperty("ORDERID 精确匹配")
    private Integer orderid;

    @ApiModelProperty("PRICE 精确匹配")
    private BigDecimal price;

    @ApiModelProperty("STATUS 精确匹配")
    private String status;

    @ApiModelProperty("UID 精确匹配")
    private Integer uid;

}
