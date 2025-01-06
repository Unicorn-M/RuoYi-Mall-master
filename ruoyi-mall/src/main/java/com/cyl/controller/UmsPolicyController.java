package com.cyl.controller;
import java.util.List;

import com.cyl.convert.UmsPolicyConvert;
import com.cyl.domain.UmsPolicy;
import com.cyl.pojo.query.UmsPolicyQuery;
import com.cyl.pojo.vo.UmsPolicyVO;
import com.cyl.service.UmsPolicyService;
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
 * 扶贫信息增删改查Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="扶贫信息增删改查接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsPolicy")
public class UmsPolicyController extends BaseController {
    @Autowired
    private UmsPolicyService service;
    @Autowired
    private UmsPolicyConvert convert;

    @ApiOperation("查询扶贫信息增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicy:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsPolicy>> list(@RequestBody UmsPolicyQuery query, Pageable page) {
        List<UmsPolicy> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出扶贫信息增删改查列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicy:export')")
    @Log(title = "扶贫信息增删改查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsPolicyQuery query) {
        List<UmsPolicy> list = service.selectList(query, null);
        ExcelUtil<UmsPolicyVO> util = new ExcelUtil<>(UmsPolicyVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "扶贫信息增删改查数据"));
    }

    @ApiOperation("获取扶贫信息增删改查详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicy:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsPolicy> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增扶贫信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicy:add')")
    @Log(title = "扶贫信息增删改查", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsPolicy umsPolicy) {
        return ResponseEntity.ok(service.insert(umsPolicy));
    }

    @ApiOperation("修改扶贫信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicy:edit')")
    @Log(title = "扶贫信息增删改查", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsPolicy umsPolicy) {
        return ResponseEntity.ok(service.update(umsPolicy));
    }

    @ApiOperation("删除扶贫信息增删改查")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsPolicy:remove')")
    @Log(title = "扶贫信息增删改查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
