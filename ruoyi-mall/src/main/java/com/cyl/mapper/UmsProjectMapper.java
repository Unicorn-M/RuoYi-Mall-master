package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsProject;
import org.apache.ibatis.annotations.Param;

/**
 * 扶贫项目申请增删改查Mapper接口
 * 
 * @author admin
 */
public interface UmsProjectMapper extends BaseMapper<UmsProject> {
    /**
     * 查询扶贫项目申请增删改查列表
     *
     * @param umsProject 扶贫项目申请增删改查
     * @return 扶贫项目申请增删改查集合
     */
    List<UmsProject> selectByEntity(UmsProject umsProject);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Integer[] ids);
}
