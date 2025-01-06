package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cyl.domain.UmsProject;
import com.cyl.mapper.UmsProjectMapper;
import com.cyl.pojo.query.UmsProjectQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 扶贫项目申请增删改查Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsProjectService {
    @Resource
    private UmsProjectMapper umsProjectMapper;

    /**
     * 查询扶贫项目申请增删改查
     *
     * @param id 扶贫项目申请增删改查主键
     * @return 扶贫项目申请增删改查
     */
    public UmsProject selectById(Integer id) {
        return umsProjectMapper.selectById(id);
    }

    /**
     * 查询扶贫项目申请增删改查列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 扶贫项目申请增删改查
     */
    public List<UmsProject> selectList(UmsProjectQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsProject> qw = new QueryWrapper<>();
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
        return umsProjectMapper.selectList(qw);
    }

    /**
     * 新增扶贫项目申请增删改查
     *
     * @param umsProject 扶贫项目申请增删改查
     * @return 结果
     */
    public int insert(UmsProject umsProject) {
        return umsProjectMapper.insert(umsProject);
    }

    /**
     * 修改扶贫项目申请
     *
     * @param umsProject 扶贫项目申请增删改查
     * @return 结果
     */
    public int update(UmsProject umsProject) {
        return umsProjectMapper.updateById(umsProject);
    }
//    public int update(UmsProject umsProject) {
//        UpdateWrapper<UmsProject> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("id", umsProject.getId());
//
//        if (umsProject.getStatus() != null) {
//            updateWrapper.set("status", umsProject.getStatus());
//        }
//        if (umsProject.getExplanation() != null) {
//            updateWrapper.set("explanation", umsProject.getExplanation());
//        }
//
//        return umsProjectMapper.update(null, updateWrapper);
//    }

    /**
     * 批量删除扶贫项目申请增删改查
     *
     * @param ids 需要删除的扶贫项目申请增删改查主键
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
        return umsProjectMapper.deleteBatchIds(idList);
    }

    /**
     * 删除扶贫项目申请增删改查信息
     *
     * @param id 扶贫项目申请增删改查主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        Integer[] ids = {id};
        return umsProjectMapper.updateDelFlagByIds(ids);
    }
}
