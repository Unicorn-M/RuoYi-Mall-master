package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsPolicy;
import org.apache.ibatis.annotations.Param;


/**
 * 扶贫信息增删改查Mapper接口
 * 
 * @author admin
 */
public interface UmsPolicyMapper extends BaseMapper<UmsPolicy> {
    /**
     * 查询扶贫信息增删改查列表
     *
     * @param umsPolicy 扶贫信息增删改查
     * @return 扶贫信息增删改查集合
     */
    List<UmsPolicy> selectByEntity(UmsPolicy umsPolicy);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
