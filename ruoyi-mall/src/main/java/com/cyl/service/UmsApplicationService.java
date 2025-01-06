package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsApplication;
import com.cyl.mapper.UmsApplicationMapper;
import com.cyl.pojo.query.UmsApplicationQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 贫困身份申请Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsApplicationService {
    @Autowired
    private UmsApplicationMapper umsApplicationMapper;

    /**
     * 查询贫困身份申请
     *
     * @param id 贫困身份申请主键
     * @return 贫困身份申请
     */
    public UmsApplication selectById(Integer id) {
        return umsApplicationMapper.selectById(id);
    }

    /**
     * 查询贫困身份申请列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 贫困身份申请
     */
    public List<UmsApplication> selectList(UmsApplicationQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsApplication> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Integer userId = query.getUserId();
        if (userId != null) {
            qw.eq("user_id", userId);
        }
        String applyContent = query.getApplyContent();
        if (!StringUtils.isEmpty(applyContent)) {
            qw.eq("apply_content", applyContent);
        }
        LocalDateTime createtime = query.getCreatetime();
        if (createtime != null) {
            qw.eq("createtime", createtime);
        }
        String contentNameLike = query.getContentNameLike();
        if (!StringUtils.isEmpty(contentNameLike)) {
            qw.like("content_name", contentNameLike);
        }
        Integer status = query.getStatus();
        if (status != null) {
            qw.eq("status", status);
        }
        String explanation = query.getExplanation();
        if (!StringUtils.isEmpty(explanation)) {
            qw.eq("explanation", explanation);
        }
        return umsApplicationMapper.selectList(qw);
    }

    /**
     * 新增贫困身份申请
     *
     * @param umsApplication 贫困身份申请
     * @return 结果
     */
    public int insert(UmsApplication umsApplication) {
        return umsApplicationMapper.insert(umsApplication);
    }

    /**
     * 修改贫困身份申请
     *
     * @param umsApplication 贫困身份申请
     * @return 结果
     */
    public int update(UmsApplication umsApplication) {
        return umsApplicationMapper.updateById(umsApplication);
    }

    /**
     * 批量删除贫困身份申请
     *
     * @param ids 需要删除的贫困身份申请主键
     * @return 结果
     */
    public int deleteByIds(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            // 如果传入的 ID 数组为空，直接返回 0
            return 0;
        }
        // 将数组转换为 List 类型
        List<Integer> idList = Arrays.asList(ids);
        // 调用 MyBatis-Plus 的批量删除方法
        return umsApplicationMapper.deleteBatchIds(idList);
    }

    /**
     * 删除贫困身份申请信息
     *
     * @param id 贫困身份申请主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsApplicationMapper.deleteById(id);
    }
}
