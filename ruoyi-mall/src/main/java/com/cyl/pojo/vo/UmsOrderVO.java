package com.cyl.pojo.vo;

import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 订单 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsOrderVO  {
   /** ID */
    private Integer id;
   /** PIC */
    @Excel(name = "PIC")
    private String pic;
   /** GOODS_NAME */
    @Excel(name = "GOODS_NAME")
    private String goodsName;
   /** USERNAME */
    @Excel(name = "USERNAME")
    private String username;
   /** ORDERID */
    @Excel(name = "ORDERID")
    private Integer orderid;
   /** PRICE */
    @Excel(name = "PRICE")
    private BigDecimal price;
   /** STATUS */
    @Excel(name = "STATUS")
    private String status;
   /** UID */
    @Excel(name = "UID")
    private Integer uid;
}
