package com.cyl.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyl.domain.UmsAdmin;
import com.cyl.mapper.UmsAdminMapper;
import com.cyl.pojo.query.UmsAdminQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表Service业务层处理
 *
 *
 * @author admin
 */
@Service
public class UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    /**
     * 查询用户信息表
     *
     * @param userId 用户信息表主键
     * @return 用户信息表
     */
    public UmsAdmin selectByUserId(Long userId) {
        return umsAdminMapper.selectById(userId);
    }

    /**
     * 查询用户信息表列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 用户信息表
     */
    public List<UmsAdmin> selectList(UmsAdminQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<UmsAdmin> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Long deptId = query.getDeptId();
        if (deptId != null) {
            qw.eq("dept_id", deptId);
        }
        String userNameLike = query.getUserNameLike();
        if (!StringUtils.isEmpty(userNameLike)) {
            qw.like("user_name", userNameLike);
        }
        String nickNameLike = query.getNickNameLike();
        if (!StringUtils.isEmpty(nickNameLike)) {
            qw.like("nick_name", nickNameLike);
        }
        String userType = query.getUserType();
        if (!StringUtils.isEmpty(userType)) {
            qw.eq("user_type", userType);
        }
        String email = query.getEmail();
        if (!StringUtils.isEmpty(email)) {
            qw.eq("email", email);
        }
        String phonenumber = query.getPhonenumber();
        if (!StringUtils.isEmpty(phonenumber)) {
            qw.eq("phonenumber", phonenumber);
        }
        String sex = query.getSex();
        if (!StringUtils.isEmpty(sex)) {
            qw.eq("sex", sex);
        }
        String avatar = query.getAvatar();
        if (!StringUtils.isEmpty(avatar)) {
            qw.eq("avatar", avatar);
        }
        String password = query.getPassword();
        if (!StringUtils.isEmpty(password)) {
            qw.eq("password", password);
        }
        String status = query.getStatus();
        if (!StringUtils.isEmpty(status)) {
            qw.eq("status", status);
        }
        String loginIp = query.getLoginIp();
        if (!StringUtils.isEmpty(loginIp)) {
            qw.eq("login_ip", loginIp);
        }
        LocalDateTime loginDate = query.getLoginDate();
        if (loginDate != null) {
            qw.eq("login_date", loginDate);
        }
        return umsAdminMapper.selectList(qw);
    }

    /**
     * 新增用户信息表
     *
     * @param umsAdmin 用户信息表
     * @return 结果
     */
    public int insert(UmsAdmin umsAdmin) {
        return umsAdminMapper.insert(umsAdmin);
    }

    /**
     * 修改用户信息表
     *
     * @param umsAdmin 用户信息表
     * @return 结果
     */
    public int update(UmsAdmin umsAdmin) {
        return umsAdminMapper.updateById(umsAdmin);
    }

    /**
     * 批量删除用户信息表
     *
     * @param userIds 需要删除的用户信息表主键
     * @return 结果
     */
    public int deleteByUserIds(Long[] userIds) {
        return umsAdminMapper.updateDelFlagByIds(userIds);
    }

    /**
     * 删除用户信息表信息
     *
     * @param userId 用户信息表主键
     * @return 结果
     */
    public int deleteByUserId(Long userId) {
        Long[] userIds = {userId};
        return umsAdminMapper.updateDelFlagByIds(userIds);
    }
}
