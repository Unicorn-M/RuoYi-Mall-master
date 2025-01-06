package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsUserConvert;
import com.cyl.domain.UmsUser;
import com.cyl.pojo.query.UmsUserQuery;
import com.cyl.pojo.vo.UmsUserVO;
import com.cyl.service.UmsUserService;
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
 * 农家信息增删改查Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="农家信息增删改查接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsUser")
public class UmsUserController extends BaseController {
    @Autowired
    private UmsUserService service;
    @Autowired
    private UmsUserConvert convert;

    @ApiOperation("查询农家信息增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsUser:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsUser>> list(@RequestBody UmsUserQuery query, Pageable page) {
        List<UmsUser> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出农家信息增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsUser:export')")
    @Log(title = "农家信息增删改查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsUserQuery query) {
        List<UmsUser> list = service.selectList(query, null);
        ExcelUtil<UmsUserVO> util = new ExcelUtil<>(UmsUserVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "农家信息增删改查数据"));
    }

    @ApiOperation("获取农家信息增删改查详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsUser:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsUser> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增农家信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsUser:add')")
    @Log(title = "农家信息增删改查", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsUser umsUser) {
        return ResponseEntity.ok(service.insert(umsUser));
    }

    @ApiOperation("修改农家信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsUser:edit')")
    @Log(title = "农家信息增删改查", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsUser umsUser) {
        return ResponseEntity.ok(service.update(umsUser));
    }

    @ApiOperation("删除农家信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsUser:remove')")
    @Log(title = "农家信息增删改查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
