package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsPolicycommentConvert;
import com.cyl.domain.UmsPolicycomment;
import com.cyl.pojo.query.UmsPolicycommentQuery;
import com.cyl.pojo.vo.UmsPolicycommentVO;
import com.cyl.service.UmsPolicycommentService;
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
 * 扶贫政策评论增删改查Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="扶贫政策评论增删改查接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsPolicycomment")
public class UmsPolicycommentController extends BaseController {
    @Autowired
    private UmsPolicycommentService service;
    @Autowired
    private UmsPolicycommentConvert convert;

    @ApiOperation("查询扶贫政策评论增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicycomment:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsPolicycomment>> list(@RequestBody UmsPolicycommentQuery query, Pageable page) {
        List<UmsPolicycomment> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出扶贫政策评论增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicycomment:export')")
    @Log(title = "扶贫政策评论增删改查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsPolicycommentQuery query) {
        List<UmsPolicycomment> list = service.selectList(query, null);
        ExcelUtil<UmsPolicycommentVO> util = new ExcelUtil<>(UmsPolicycommentVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "扶贫政策评论增删改查数据"));
    }

    @ApiOperation("获取扶贫政策评论增删改查详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicycomment:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsPolicycomment> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增扶贫政策评论增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicycomment:add')")
    @Log(title = "扶贫政策评论增删改查", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsPolicycomment umsPolicycomment) {
        return ResponseEntity.ok(service.insert(umsPolicycomment));
    }

    @ApiOperation("修改扶贫政策评论增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicycomment:edit')")
    @Log(title = "扶贫政策评论增删改查", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsPolicycomment umsPolicycomment) {
        return ResponseEntity.ok(service.update(umsPolicycomment));
    }

    @ApiOperation("删除扶贫政策评论增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicycomment:remove')")
    @Log(title = "扶贫政策评论增删改查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
