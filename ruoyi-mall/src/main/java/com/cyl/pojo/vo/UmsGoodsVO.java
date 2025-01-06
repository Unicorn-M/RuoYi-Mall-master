package com.cyl.pojo.vo;

import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 商品信息 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsGoodsVO  {
   /** ID */
    private Integer id;
   /** PIC */
    @Excel(name = "PIC")
    private String pic;
   /** NAME */
    @Excel(name = "NAME")
    private String name;
   /** PRICE */
    @Excel(name = "PRICE")
    private BigDecimal price;
   /** COUNT */
    @Excel(name = "COUNT")
    private Integer count;
   /** SALE_NUMBER */
    @Excel(name = "SALE_NUMBER")
    private Integer saleNumber;
}
