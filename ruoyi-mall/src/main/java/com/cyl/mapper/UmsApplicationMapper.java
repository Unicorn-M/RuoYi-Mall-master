package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsApplication;
import org.apache.ibatis.annotations.Param;


/**
 * 贫困身份申请Mapper接口
 * 
 * @author admin
 */
public interface UmsApplicationMapper extends BaseMapper<UmsApplication> {
    /**
     * 查询贫困身份申请列表
     *
     * @param umsApplication 贫困身份申请
     * @return 贫困身份申请集合
     */
    List<UmsApplication> selectByEntity(UmsApplication umsApplication);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
