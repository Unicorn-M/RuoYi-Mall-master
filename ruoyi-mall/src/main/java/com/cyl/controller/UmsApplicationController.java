package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsApplicationConvert;
import com.cyl.domain.UmsApplication;
import com.cyl.pojo.query.UmsApplicationQuery;
import com.cyl.pojo.vo.UmsApplicationVO;
import com.cyl.service.UmsApplicationService;
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
 * 贫困身份申请Controller
 *
 * @author admin
 * @date 2025-01-04
 */
@Api(description ="贫困身份申请接口列表")
@RestController
@RequestMapping("/ruoyi-mall/umsApplication")
public class UmsApplicationController extends BaseController {
    @Autowired
    private UmsApplicationService service;
    @Autowired
    private UmsApplicationConvert convert;

    @ApiOperation("查询贫困身份申请列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsApplication:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsApplication>> list(@RequestBody UmsApplicationQuery query, Pageable page) {
        List<UmsApplication> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出贫困身份申请列表")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsApplication:export')")
    @Log(title = "贫困身份申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsApplicationQuery query) {
        List<UmsApplication> list = service.selectList(query, null);
        ExcelUtil<UmsApplicationVO> util = new ExcelUtil<>(UmsApplicationVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "贫困身份申请数据"));
    }

    @ApiOperation("获取贫困身份申请详细信息")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsApplication:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsApplication> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增贫困身份申请")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsApplication:add')")
    @Log(title = "贫困身份申请", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsApplication umsApplication) {
        return ResponseEntity.ok(service.insert(umsApplication));
    }

    @ApiOperation("修改贫困身份申请")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsApplication:edit')")
    @Log(title = "贫困身份申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsApplication umsApplication) {
        return ResponseEntity.ok(service.update(umsApplication));
    }

    @ApiOperation("删除贫困身份申请")
    @PreAuthorize("@ss.hasPermi('ruoyi-mall:umsApplication:remove')")
    @Log(title = "贫困身份申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
