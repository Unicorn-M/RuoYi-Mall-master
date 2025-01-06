package com.cyl.service;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsGoods;
import com.cyl.mapper.UmsGoodsMapper;
import com.cyl.pojo.query.UmsGoodsQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 商品信息Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsGoodsService {
    @Resource
    private UmsGoodsMapper umsGoodsMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    public UmsGoods selectById(Integer id) {
        return umsGoodsMapper.selectById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 商品信息
     */
    public List<UmsGoods> selectList(UmsGoodsQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsGoods> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String pic = query.getPic();
        if (!StringUtils.isEmpty(pic)) {
            qw.eq("pic", pic);
        }
        String nameLike = query.getNameLike();
        if (!StringUtils.isEmpty(nameLike)) {
            qw.like("name", nameLike);
        }
        BigDecimal price = query.getPrice();
        if (price != null) {
            qw.eq("price", price);
        }
        Integer count = query.getCount();
        if (count != null) {
            qw.eq("count", count);
        }
        Integer saleNumber = query.getSaleNumber();
        if (saleNumber != null) {
            qw.eq("sale_number", saleNumber);
        }
        return umsGoodsMapper.selectList(qw);
    }

    /**
     * 新增商品信息
     *
     * @param umsGoods 商品信息
     * @return 结果
     */
    public int insert(UmsGoods umsGoods) {
        return umsGoodsMapper.insert(umsGoods);
    }

    /**
     * 修改商品信息
     *
     * @param umsGoods 商品信息
     * @return 结果
     */
    public int update(UmsGoods umsGoods) {
        return umsGoodsMapper.updateById(umsGoods);
    }

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键
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
        return umsGoodsMapper.deleteBatchIds(idList);
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsGoodsMapper.deleteById(id);
    }
}
