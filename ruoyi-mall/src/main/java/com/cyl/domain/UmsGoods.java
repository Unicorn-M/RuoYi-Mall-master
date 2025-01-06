package com.cyl.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 商品信息对象 ums_goods
 * 
 * @author admin
 */
@ApiModel(description="商品信息对象")
@Data
@TableName("ums_goods")
public class UmsGoods implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("PIC")
    @Excel(name = "PIC")
    private String pic;

    @ApiModelProperty("NAME")
    @Excel(name = "NAME")
    private String name;

    @ApiModelProperty("PRICE")
    @Excel(name = "PRICE")
    private BigDecimal price;

    @ApiModelProperty("COUNT")
    @Excel(name = "COUNT")
    private Integer count;

    @ApiModelProperty("SALE_NUMBER")
    @Excel(name = "SALE_NUMBER")
    private Integer saleNumber;

}
