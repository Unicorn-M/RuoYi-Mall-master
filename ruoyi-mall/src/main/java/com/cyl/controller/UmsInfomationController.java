package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsInfomationConvert;
import com.cyl.domain.UmsInfomation;
import com.cyl.pojo.query.UmsInfomationQuery;
import com.cyl.pojo.vo.UmsInfomationVO;
import com.cyl.service.UmsInfomationService;
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
 * 资讯信息增删改查Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="资讯信息增删改查接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsInfomation")
public class UmsInfomationController extends BaseController {
    @Autowired
    private UmsInfomationService service;
    @Autowired
    private UmsInfomationConvert convert;

    @ApiOperation("查询资讯信息增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsInfomation:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsInfomation>> list(@RequestBody UmsInfomationQuery query, Pageable page) {
        List<UmsInfomation> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出资讯信息增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsInfomation:export')")
    @Log(title = "资讯信息增删改查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsInfomationQuery query) {
        List<UmsInfomation> list = service.selectList(query, null);
        ExcelUtil<UmsInfomationVO> util = new ExcelUtil<>(UmsInfomationVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "资讯信息增删改查数据"));
    }

    @ApiOperation("获取资讯信息增删改查详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsInfomation:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsInfomation> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增资讯信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsInfomation:add')")
    @Log(title = "资讯信息增删改查", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsInfomation umsInfomation) {
        return ResponseEntity.ok(service.insert(umsInfomation));
    }

    @ApiOperation("修改资讯信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsInfomation:edit')")
    @Log(title = "资讯信息增删改查", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsInfomation umsInfomation) {
        return ResponseEntity.ok(service.update(umsInfomation));
    }

    @ApiOperation("删除资讯信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsInfomation:remove')")
    @Log(title = "资讯信息增删改查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
