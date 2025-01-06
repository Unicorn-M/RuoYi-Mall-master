package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsPolicy;
import com.cyl.mapper.UmsPolicyMapper;
import com.cyl.pojo.query.UmsPolicyQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 扶贫信息增删改查Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsPolicyService {
    @Resource
    private UmsPolicyMapper umsPolicyMapper;

    /**
     * 查询扶贫信息增删改查
     *
     * @param id 扶贫信息增删改查主键
     * @return 扶贫信息增删改查
     */
    public UmsPolicy selectById(Integer id) {
        return umsPolicyMapper.selectById(id);
    }

    /**
     * 查询扶贫信息增删改查列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 扶贫信息增删改查
     */
    public List<UmsPolicy> selectList(UmsPolicyQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsPolicy> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String title = query.getTitle();
        if (!StringUtils.isEmpty(title)) {
            qw.eq("title", title);
        }
        String content = query.getContent();
        if (!StringUtils.isEmpty(content)) {
            qw.eq("content", content);
        }
        LocalDateTime createtime = query.getCreatetime();
        if (createtime != null) {
            qw.eq("createtime", createtime);
        }
        return umsPolicyMapper.selectList(qw);
    }

    /**
     * 新增扶贫信息增删改查
     *
     * @param umsPolicy 扶贫信息增删改查
     * @return 结果
     */
    public int insert(UmsPolicy umsPolicy) {
        return umsPolicyMapper.insert(umsPolicy);
    }

    /**
     * 修改扶贫信息增删改查
     *
     * @param umsPolicy 扶贫信息增删改查
     * @return 结果
     */
    public int update(UmsPolicy umsPolicy) {
        return umsPolicyMapper.updateById(umsPolicy);
    }

    /**
     * 批量删除扶贫信息增删改查
     *
     * @param ids 需要删除的扶贫信息增删改查主键
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
        return umsPolicyMapper.deleteBatchIds(idList);
    }

    /**
     * 删除扶贫信息增删改查信息
     *
     * @param id 扶贫信息增删改查主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsPolicyMapper.deleteById(id);
    }
}
