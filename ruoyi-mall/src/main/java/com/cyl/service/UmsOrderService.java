package com.cyl.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsOrder;
import com.cyl.mapper.UmsOrderMapper;
import com.cyl.pojo.query.UmsOrderQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 订单Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsOrderService {
    @Autowired
    private UmsOrderMapper umsOrderMapper;

    /**
     * 查询订单
     *
     * @param id 订单主键
     * @return 订单
     */
    public UmsOrder selectById(Integer id) {
        return umsOrderMapper.selectById(id);
    }

    /**
     * 查询订单列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 订单
     */
    public List<UmsOrder> selectList(UmsOrderQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsOrder> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String pic = query.getPic();
        if (!StringUtils.isEmpty(pic)) {
            qw.eq("pic", pic);
        }
        String goodsNameLike = query.getGoodsNameLike();
        if (!StringUtils.isEmpty(goodsNameLike)) {
            qw.like("goods_name", goodsNameLike);
        }
        String usernameLike = query.getUsernameLike();
        if (!StringUtils.isEmpty(usernameLike)) {
            qw.like("username", usernameLike);
        }
        Integer orderid = query.getOrderid();
        if (orderid != null) {
            qw.eq("orderId", orderid);
        }
        BigDecimal price = query.getPrice();
        if (price != null) {
            qw.eq("price", price);
        }
        String status = query.getStatus();
        if (!StringUtils.isEmpty(status)) {
            qw.eq("status", status);
        }
        Integer uid = query.getUid();
        if (uid != null) {
            qw.eq("uid", uid);
        }
        return umsOrderMapper.selectList(qw);
    }

    /**
     * 新增订单
     *
     * @param umsOrder 订单
     * @return 结果
     */
    public int insert(UmsOrder umsOrder) {
        return umsOrderMapper.insert(umsOrder);
    }

    /**
     * 修改订单
     *
     * @param umsOrder 订单
     * @return 结果
     */
    public int update(UmsOrder umsOrder) {
        return umsOrderMapper.updateById(umsOrder);
    }

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    public int deleteByIds(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            // 如果传入的 ID 数组为空，直接返回 0
            return 0;
        }
        // 将数组转换为 List 类型
        List<Integer> idList = Arrays.asList(ids);
        // 调用 MyBatis-Plus 的批量删除方法
        return umsOrderMapper.deleteBatchIds(idList);
    }

    /**
     * 删除订单信息
     *
     * @param id 订单主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsOrderMapper.deleteById(id);
    }
}
