package com.cyl.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsPolicycomment;
import org.apache.ibatis.annotations.Param;


/**
 * 扶贫政策评论增删改查Mapper接口
 * 
 * @author admin
 */
public interface UmsPolicycommentMapper extends BaseMapper<UmsPolicycomment> {
    /**
     * 查询扶贫政策评论增删改查列表
     *
     * @param umsPolicycomment 扶贫政策评论增删改查
     * @return 扶贫政策评论增删改查集合
     */
    List<UmsPolicycomment> selectByEntity(UmsPolicycomment umsPolicycomment);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
