package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.cyl.domain.UmsNotice;

/**
 * 公告信息Mapper接口
 *
 * @author admin
 */
public interface UmsNoticeMapper extends BaseMapper<UmsNotice> {
    /**
     * 查询公告信息列表
     *
     * @param umsNotice 公告信息
     * @return 公告信息集合
     */
    List<UmsNotice> selectByEntity(UmsNotice umsNotice);

    /**
     * 批量软删除
     * @param ids
     * @return
     */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}

