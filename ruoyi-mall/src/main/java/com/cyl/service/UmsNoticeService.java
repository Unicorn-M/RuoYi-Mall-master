package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsNotice;
import com.cyl.mapper.UmsNoticeMapper;
import com.cyl.pojo.query.UmsNoticeQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 公告信息Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsNoticeService {
    @Resource
    private UmsNoticeMapper umsNoticeMapper;

    /**
     * 查询公告信息
     *
     * @param id 公告信息主键
     * @return 公告信息
     */
    public UmsNotice selectById(Integer id) {
        return umsNoticeMapper.selectById(id);
    }

    /**
     * 查询公告信息列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 公告信息
     */
    public List<UmsNotice> selectList(UmsNoticeQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsNotice> qw = new QueryWrapper<>();
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
        String createPerson = query.getCreatePerson();
        if (!StringUtils.isEmpty(createPerson)) {
            qw.eq("create_person", createPerson);
        }
        return umsNoticeMapper.selectList(qw);
    }

    /**
     * 新增公告信息
     *
     * @param umsNotice 公告信息
     * @return 结果
     */
    public int insert(UmsNotice umsNotice) {
        umsNotice.setDelFlag(0);
        umsNotice.setCreatePerson("admin");
        umsNotice.setCreatetime(LocalDateTime.now());
        return umsNoticeMapper.insert(umsNotice);
    }

    /**
     * 修改公告信息
     *
     * @param umsNotice 公告信息
     * @return 结果
     */
    public int update(UmsNotice umsNotice) {
        return umsNoticeMapper.updateById(umsNotice);
    }

    /**
     * 批量删除公告信息
     *
     * @param ids 需要删除的公告信息主键
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
        return umsNoticeMapper.deleteBatchIds(idList);
    }

    /**
     * 删除公告信息信息
     *
     * @param id 公告信息主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsNoticeMapper.deleteById(id);
    }
}

