package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsAdmin;
import org.apache.ibatis.annotations.Param;


/**
 * 用户信息表Mapper接口
 * 
 * @author admin
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
    /**
     * 查询用户信息表列表
     *
     * @param umsAdmin 用户信息表
     * @return 用户信息表集合
     */
    List<UmsAdmin> selectByEntity(UmsAdmin umsAdmin);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
