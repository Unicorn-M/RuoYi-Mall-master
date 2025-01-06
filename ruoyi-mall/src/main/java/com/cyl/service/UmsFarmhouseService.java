package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsFarmhouse;
import com.cyl.mapper.UmsFarmhouseMapper;
import com.cyl.pojo.query.UmsFarmhouseQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * 农家乐增删改查Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsFarmhouseService {
    @Autowired
    private UmsFarmhouseMapper umsFarmhouseMapper;

    /**
     * 查询农家乐增删改查
     *
     * @param id 农家乐增删改查主键
     * @return 农家乐增删改查
     */
    public UmsFarmhouse selectById(Integer id) {
        return umsFarmhouseMapper.selectById(id);
    }

    /**
     * 查询农家乐增删改查列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 农家乐增删改查
     */
    public List<UmsFarmhouse> selectList(UmsFarmhouseQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsFarmhouse> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String pic = query.getPic();
        if (!StringUtils.isEmpty(pic)) {
            qw.eq("pic", pic);
        }
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
        return umsFarmhouseMapper.selectList(qw);
    }

    /**
     * 新增农家乐增删改查
     *
     * @param umsFarmhouse 农家乐增删改查
     * @return 结果
     */
    public int insert(UmsFarmhouse umsFarmhouse) {
        return umsFarmhouseMapper.insert(umsFarmhouse);
    }

    /**
     * 修改农家乐增删改查
     *
     * @param umsFarmhouse 农家乐增删改查
     * @return 结果
     */
    public int update(UmsFarmhouse umsFarmhouse) {
        return umsFarmhouseMapper.updateById(umsFarmhouse);
    }

    /**
     * 批量删除农家乐增删改查
     *
     * @param ids 需要删除的农家乐增删改查主键
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
        return umsFarmhouseMapper.deleteBatchIds(idList);
    }

    /**
     * 删除农家乐增删改查信息
     *
     * @param id 农家乐增删改查主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsFarmhouseMapper.deleteById(id);
    }
}
