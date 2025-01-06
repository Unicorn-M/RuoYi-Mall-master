package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsGoods;
import org.apache.ibatis.annotations.Param;


/**
 * 商品信息Mapper接口
 * 
 * @author admin
 */
public interface UmsGoodsMapper extends BaseMapper<UmsGoods> {
    /**
     * 查询商品信息列表
     *
     * @param umsGoods 商品信息
     * @return 商品信息集合
     */
    List<UmsGoods> selectByEntity(UmsGoods umsGoods);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
