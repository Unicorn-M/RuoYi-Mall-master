package com.cyl.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 农家信息增删改查 数据视图对象
 * 
 * @author admin
 */
@Data
public class UmsUserVO  {
   /** ID */
    private Integer id;
   /** 头像 */
    @Excel(name = "头像")
    private String pic;
   /** USERNAME */
    @Excel(name = "USERNAME")
    private String username;
   /** NICK_NAME */
    @Excel(name = "NICK_NAME")
    private String nickName;
   /** TELE */
    @Excel(name = "TELE")
    private String tele;
   /** EMAIL */
    @Excel(name = "EMAIL")
    private String email;
   /** 0表示普通用户，1表示贫困户 */
    @Excel(name = "0表示普通用户，1表示贫困户")
    private Integer isPoor;
   /** MONEY */
    @Excel(name = "MONEY")
    private String money;
}
