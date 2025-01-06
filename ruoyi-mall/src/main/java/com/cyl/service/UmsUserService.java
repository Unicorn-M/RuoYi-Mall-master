package com.cyl.service;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsUser;
import com.cyl.mapper.UmsUserMapper;
import com.cyl.pojo.query.UmsUserQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 农家信息增删改查Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsUserService {

    @Resource
    private UmsUserMapper umsUserMapper;

    /**
     * 查询农家信息增删改查
     *
     * @param id 农家信息增删改查主键
     * @return 农家信息增删改查
     */
    public UmsUser selectById(Integer id) {
        return umsUserMapper.selectById(id);
    }

    /**
     * 查询农家信息增删改查列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 农家信息增删改查
     */
    public List<UmsUser> selectList(UmsUserQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsUser> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String pic = query.getPic();
        if (!StringUtils.isEmpty(pic)) {
            qw.eq("pic", pic);
        }
        String usernameLike = query.getUsernameLike();
        if (!StringUtils.isEmpty(usernameLike)) {
            qw.like("username", usernameLike);
        }
        String nickNameLike = query.getNickNameLike();
        if (!StringUtils.isEmpty(nickNameLike)) {
            qw.like("nick_name", nickNameLike);
        }
        String tele = query.getTele();
        if (!StringUtils.isEmpty(tele)) {
            qw.eq("tele", tele);
        }
        String email = query.getEmail();
        if (!StringUtils.isEmpty(email)) {
            qw.eq("email", email);
        }
        Integer isPoor = query.getIsPoor();
        if (isPoor != null) {
            qw.eq("is_poor", isPoor);
        }
        String money = query.getMoney();
        if (!StringUtils.isEmpty(money)) {
            qw.eq("money", money);
        }
        return umsUserMapper.selectList(qw);
    }

    /**
     * 新增农家信息增删改查
     *
     * @param umsUser 农家信息增删改查
     * @return 结果
     */
    public int insert(UmsUser umsUser) {
        return umsUserMapper.insert(umsUser);
    }

    /**
     * 修改农家信息增删改查
     *
     * @param umsUser 农家信息增删改查
     * @return 结果
     */
    public int update(UmsUser umsUser) {
        return umsUserMapper.updateById(umsUser);
    }

    /**
     * 批量删除农家信息
     *
     * @param ids 需要删除的农家信息主键数组
     * @return 受影响的行数
     */
    public int deleteByIds(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            // 如果传入的 ID 数组为空，直接返回 0
            return 0;
        }
        // 将数组转换为 List 类型
        List<Integer> idList = Arrays.asList(ids);
        // 调用 MyBatis-Plus 的批量删除方法
        return umsUserMapper.deleteBatchIds(idList);
    }

    /**
     * 删除农家信息增删改查信息
     *
     * @param id 农家信息增删改查主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return umsUserMapper.deleteById(id);
    }
}
