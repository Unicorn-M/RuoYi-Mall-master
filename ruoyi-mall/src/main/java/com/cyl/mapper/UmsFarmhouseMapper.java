package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsFarmhouse;
import org.apache.ibatis.annotations.Param;


/**
 * 农家乐增删改查Mapper接口
 * 
 * @author admin
 */
public interface UmsFarmhouseMapper extends BaseMapper<UmsFarmhouse> {
    /**
     * 查询农家乐增删改查列表
     *
     * @param umsFarmhouse 农家乐增删改查
     * @return 农家乐增删改查集合
     */
    List<UmsFarmhouse> selectByEntity(UmsFarmhouse umsFarmhouse);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
