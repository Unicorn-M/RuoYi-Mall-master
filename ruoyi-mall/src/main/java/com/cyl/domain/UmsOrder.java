package com.cyl.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 订单对象 ums_order
 * 
 * @author admin
 */
@ApiModel(description="订单对象")
@Data
@TableName("ums_order")
public class UmsOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("PIC")
    @Excel(name = "PIC")
    private String pic;

    @ApiModelProperty("GOODS_NAME")
    @Excel(name = "GOODS_NAME")
    private String goodsName;

    @ApiModelProperty("USERNAME")
    @Excel(name = "USERNAME")
    private String username;

    @ApiModelProperty("ORDERID")
    @Excel(name = "ORDERID")
    private Integer orderid;

    @ApiModelProperty("PRICE")
    @Excel(name = "PRICE")
    private BigDecimal price;

    @ApiModelProperty("STATUS")
    @Excel(name = "STATUS")
    private String status;

    @ApiModelProperty("UID")
    @Excel(name = "UID")
    private Integer uid;

}
