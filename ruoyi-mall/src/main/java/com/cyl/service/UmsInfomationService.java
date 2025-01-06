package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsInfomation;
import com.cyl.mapper.UmsInfomationMapper;
import com.cyl.pojo.query.UmsInfomationQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 资讯信息增删改查Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsInfomationService {
    @Resource
    private UmsInfomationMapper umsInfomationMapper;

    /**
     * 查询资讯信息增删改查
     *
     * @param id 资讯信息增删改查主键
     * @return 资讯信息增删改查
     */
    public UmsInfomation selectById(Integer id) {
        return umsInfomationMapper.selectById(id);
    }

    /**
     * 查询资讯信息增删改查列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 资讯信息增删改查
     */
    public List<UmsInfomation> selectList(UmsInfomationQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsInfomation> qw = new QueryWrapper<>();
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
        return umsInfomationMapper.selectList(qw);
    }

    /**
     * 新增资讯信息增删改查
     *
     * @param umsInfomation 资讯信息增删改查
     * @return 结果
     */
    public int insert(UmsInfomation umsInfomation) {
        umsInfomation.setCreatetime(LocalDateTime.now());
        return umsInfomationMapper.insert(umsInfomation);
    }

    /**
     * 修改资讯信息增删改查
     *
     * @param umsInfomation 资讯信息增删改查
     * @return 结果
     */
    public int update(UmsInfomation umsInfomation) {
        return umsInfomationMapper.updateById(umsInfomation);
    }

    /**
     * 批量删除资讯信息增删改查
     *
     * @param ids 需要删除的资讯信息增删改查主键
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
        return umsInfomationMapper.deleteBatchIds(idList);
    }

    /**
     * 删除资讯信息增删改查信息
     *
     * @param id 资讯信息增删改查主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsInfomationMapper.deleteById(id);
    }
}
