package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.mapper.UmsPolicycommentMapper;
import com.cyl.pojo.query.UmsPolicycommentQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.cyl.domain.UmsPolicycomment;
import javax.annotation.Resource;

/**
 * 扶贫政策评论增删改查Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsPolicycommentService {

    @Resource
    private UmsPolicycommentMapper umsPolicycommentMapper;

    /**
     * 查询扶贫政策评论增删改查
     *
     * @param id 扶贫政策评论增删改查主键
     * @return 扶贫政策评论增删改查
     */
    public UmsPolicycomment selectById(Integer id) {
        return umsPolicycommentMapper.selectById(id);
    }

    /**
     * 查询扶贫政策评论增删改查列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 扶贫政策评论增删改查
     */
    public List<UmsPolicycomment> selectList(UmsPolicycommentQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsPolicycomment> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String nickNameLike = query.getNickNameLike();
        if (!StringUtils.isEmpty(nickNameLike)) {
            qw.like("nick_name", nickNameLike);
        }
        String content = query.getContent();
        if (!StringUtils.isEmpty(content)) {
            qw.eq("content", content);
        }
        String policyContent = query.getPolicyContent();
        if (!StringUtils.isEmpty(policyContent)) {
            qw.eq("policy_content", policyContent);
        }
        LocalDateTime createtime = query.getCreatetime();
        if (createtime != null) {
            qw.eq("createtime", createtime);
        }
        return umsPolicycommentMapper.selectList(qw);
    }

    /**
     * 新增扶贫政策评论增删改查
     *
     * @param umsPolicycomment 扶贫政策评论增删改查
     * @return 结果
     */
    public int insert(UmsPolicycomment umsPolicycomment) {
        return umsPolicycommentMapper.insert(umsPolicycomment);
    }

    /**
     * 修改扶贫政策评论增删改查
     *
     * @param umsPolicycomment 扶贫政策评论增删改查
     * @return 结果
     */
    public int update(UmsPolicycomment umsPolicycomment) {
        return umsPolicycommentMapper.updateById(umsPolicycomment);
    }

    /**
     * 批量删除扶贫政策评论增删改查
     *
     * @param ids 需要删除的扶贫政策评论增删改查主键
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
        return umsPolicycommentMapper.deleteBatchIds(idList);
    }

    /**
     * 删除扶贫政策评论增删改查信息
     *
     * @param id 扶贫政策评论增删改查主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsPolicycommentMapper.deleteById(id);
    }
}
