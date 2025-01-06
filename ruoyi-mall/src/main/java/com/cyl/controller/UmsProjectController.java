package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsProjectConvert;
import com.cyl.domain.UmsProject;
import com.cyl.pojo.query.UmsProjectQuery;
import com.cyl.pojo.vo.UmsProjectVO;
import com.cyl.service.UmsProjectService;
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
 * 扶贫项目申请增删改查Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="扶贫项目申请增删改查接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsProject")
public class UmsProjectController extends BaseController {
    @Autowired
    private UmsProjectService service;
    @Autowired
    private UmsProjectConvert convert;

    @ApiOperation("查询扶贫项目申请增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsProject:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsProject>> list(@RequestBody UmsProjectQuery query, Pageable page) {
        List<UmsProject> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出扶贫项目申请增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsProject:export')")
    @Log(title = "扶贫项目申请增删改查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsProjectQuery query) {
        List<UmsProject> list = service.selectList(query, null);
        ExcelUtil<UmsProjectVO> util = new ExcelUtil<>(UmsProjectVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "扶贫项目申请增删改查数据"));
    }

    @ApiOperation("获取扶贫项目申请增删改查详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsProject:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsProject> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增扶贫项目申请增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsProject:add')")
    @Log(title = "扶贫项目申请增删改查", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsProject umsProject) {
        return ResponseEntity.ok(service.insert(umsProject));
    }

    @ApiOperation("修改扶贫项目申请增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsProject:edit')")
    @Log(title = "扶贫项目申请增删改查", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsProject umsProject) {
        return ResponseEntity.ok(service.update(umsProject));
    }

    @ApiOperation("删除扶贫项目申请增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsProject:remove')")
    @Log(title = "扶贫项目申请增删改查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
