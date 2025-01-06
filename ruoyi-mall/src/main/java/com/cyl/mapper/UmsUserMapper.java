package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsUser;
import org.apache.ibatis.annotations.Param;


/**
 * 农家信息增删改查Mapper接口
 * 
 * @author admin
 */
public interface UmsUserMapper extends BaseMapper<UmsUser> {
    /**
     * 查询农家信息增删改查列表
     *
     * @param umsUser 农家信息增删改查
     * @return 农家信息增删改查集合
     */
    List<UmsUser> selectByEntity(UmsUser umsUser);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
