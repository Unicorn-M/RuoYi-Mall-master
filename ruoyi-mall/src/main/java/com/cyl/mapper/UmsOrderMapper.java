package com.cyl.mapper;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsOrder;
import org.apache.ibatis.annotations.Param;


/**
 * 订单Mapper接口
 * 
 * @author admin
 */
public interface UmsOrderMapper extends BaseMapper<UmsOrder> {
    /**
     * 查询订单列表
     *
     * @param umsOrder 订单
     * @return 订单集合
     */
    List<UmsOrder> selectByEntity(UmsOrder umsOrder);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
