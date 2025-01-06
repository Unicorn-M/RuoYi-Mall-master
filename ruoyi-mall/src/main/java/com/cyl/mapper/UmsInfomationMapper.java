package com.cyl.mapper;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.domain.UmsInfomation;
import org.apache.ibatis.annotations.Param;


/**
 * 资讯信息增删改查Mapper接口
 * 
 * @author admin
 */
public interface UmsInfomationMapper extends BaseMapper<UmsInfomation> {
    /**
     * 查询资讯信息增删改查列表
     *
     * @param umsInfomation 资讯信息增删改查
     * @return 资讯信息增删改查集合
     */
    List<UmsInfomation> selectByEntity(UmsInfomation umsInfomation);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
