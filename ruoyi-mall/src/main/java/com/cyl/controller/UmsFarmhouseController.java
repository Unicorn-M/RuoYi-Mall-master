package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsFarmhouseConvert;
import com.cyl.domain.UmsFarmhouse;
import com.cyl.pojo.query.UmsFarmhouseQuery;
import com.cyl.pojo.vo.UmsFarmhouseVO;
import com.cyl.service.UmsFarmhouseService;
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
 * 农家乐增删改查Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="农家乐增删改查接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsFarmhouse")
public class UmsFarmhouseController extends BaseController {
    @Autowired
    private UmsFarmhouseService service;
    @Autowired
    private UmsFarmhouseConvert convert;

    @ApiOperation("查询农家乐增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsFarmhouse:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsFarmhouse>> list(@RequestBody UmsFarmhouseQuery query, Pageable page) {
        List<UmsFarmhouse> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出农家乐增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsFarmhouse:export')")
    @Log(title = "农家乐增删改查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsFarmhouseQuery query) {
        List<UmsFarmhouse> list = service.selectList(query, null);
        ExcelUtil<UmsFarmhouseVO> util = new ExcelUtil<>(UmsFarmhouseVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "农家乐增删改查数据"));
    }

    @ApiOperation("获取农家乐增删改查详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsFarmhouse:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsFarmhouse> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增农家乐增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsFarmhouse:add')")
    @Log(title = "农家乐增删改查", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsFarmhouse umsFarmhouse) {
        return ResponseEntity.ok(service.insert(umsFarmhouse));
    }

    @ApiOperation("修改农家乐增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsFarmhouse:edit')")
    @Log(title = "农家乐增删改查", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsFarmhouse umsFarmhouse) {
        return ResponseEntity.ok(service.update(umsFarmhouse));
    }

    @ApiOperation("删除农家乐增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsFarmhouse:remove')")
    @Log(title = "农家乐增删改查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
