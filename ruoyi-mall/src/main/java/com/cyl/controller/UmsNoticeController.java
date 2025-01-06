package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsNoticeConvert;
import com.cyl.domain.UmsNotice;
import com.cyl.pojo.query.UmsNoticeQuery;
import com.cyl.pojo.vo.UmsNoticeVO;
import com.cyl.service.UmsNoticeService;
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
 * 公告信息Controller
 *
 * @author admin
 * @date 2025-01-05
 */
@Api(description ="公告信息接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsNotice")
public class UmsNoticeController extends BaseController {
    @Autowired
    private UmsNoticeService service;
    @Autowired
    private UmsNoticeConvert convert;

    @ApiOperation("查询公告信息列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsNotice:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsNotice>> list(@RequestBody UmsNoticeQuery query, Pageable page) {
        List<UmsNotice> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出公告信息列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsNotice:export')")
    @Log(title = "公告信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsNoticeQuery query) {
        List<UmsNotice> list = service.selectList(query, null);
        ExcelUtil<UmsNoticeVO> util = new ExcelUtil<>(UmsNoticeVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "公告信息数据"));
    }

    @ApiOperation("获取公告信息详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsNotice:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsNotice> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增公告信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsNotice:add')")
    @Log(title = "公告信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsNotice umsNotice) {
        return ResponseEntity.ok(service.insert(umsNotice));
    }

    @ApiOperation("修改公告信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsNotice:edit')")
    @Log(title = "公告信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsNotice umsNotice) {
        return ResponseEntity.ok(service.update(umsNotice));
    }

    @ApiOperation("删除公告信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsNotice:remove')")
    @Log(title = "公告信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}

