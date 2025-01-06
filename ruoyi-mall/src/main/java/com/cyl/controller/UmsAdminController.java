package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsAdminConvert;
import com.cyl.domain.UmsAdmin;
import com.cyl.pojo.query.UmsAdminQuery;
import com.cyl.pojo.vo.UmsAdminVO;
import com.cyl.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
/**
 * 用户信息表Controller
 *
 * @author admin
 * @date 2025-01-06
 */
@Api(description ="用户信息表接口列表")
@RestController
@RequestMapping("/mall/umsAdmin")
public class UmsAdminController extends BaseController {
    @Autowired
    private UmsAdminService service;
    @Autowired
    private UmsAdminConvert convert;

    @ApiOperation("查询用户信息表列表")
    @PreAuthorize("@ss.hasPermi('mall:umsAdmin:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsAdmin>> list(@RequestBody UmsAdminQuery query, Pageable page) {
        List<UmsAdmin> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出用户信息表列表")
    @PreAuthorize("@ss.hasPermi('mall:umsAdmin:export')")
    @Log(title = "用户信息表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsAdminQuery query) {
        List<UmsAdmin> list = service.selectList(query, null);
        ExcelUtil<UmsAdminVO> util = new ExcelUtil<>(UmsAdminVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "用户信息表数据"));
    }

    @ApiOperation("获取用户信息表详细信息")
    @PreAuthorize("@ss.hasPermi('mall:umsAdmin:query')")
    @GetMapping(value = "/{userId}")
    public ResponseEntity<UmsAdmin> getInfo(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.selectByUserId(userId));
    }

    @ApiOperation("新增用户信息表")
    @PreAuthorize("@ss.hasPermi('mall:umsAdmin:add')")
    @Log(title = "用户信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsAdmin umsAdmin) {
        return ResponseEntity.ok(service.insert(umsAdmin));
    }

    @ApiOperation("修改用户信息表")
    @PreAuthorize("@ss.hasPermi('mall:umsAdmin:edit')")
    @Log(title = "用户信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsAdmin umsAdmin) {
        return ResponseEntity.ok(service.update(umsAdmin));
    }

    @ApiOperation("删除用户信息表")
    @PreAuthorize("@ss.hasPermi('mall:umsAdmin:remove')")
    @Log(title = "用户信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] userIds) {
        return ResponseEntity.ok(service.deleteByUserIds(userIds));
    }
}
