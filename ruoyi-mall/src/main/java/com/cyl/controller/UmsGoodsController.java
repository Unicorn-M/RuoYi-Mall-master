package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsGoodsConvert;
import com.cyl.domain.UmsGoods;
import com.cyl.pojo.query.UmsGoodsQuery;
import com.cyl.pojo.vo.UmsGoodsVO;
import com.cyl.service.UmsGoodsService;
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
 * 商品信息Controller
 *
 * @author admin
 * @date 2025-01-06
 */
@Api(description ="商品信息接口列表")
@RestController
@RequestMapping("/mall/umsGoods")
public class UmsGoodsController extends BaseController {
    @Autowired
    private UmsGoodsService service;
    @Autowired
    private UmsGoodsConvert convert;

    @ApiOperation("查询商品信息列表")
    @PreAuthorize("@ss.hasPermi('mall:umsGoods:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsGoods>> list(@RequestBody UmsGoodsQuery query, Pageable page) {
        List<UmsGoods> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出商品信息列表")
    @PreAuthorize("@ss.hasPermi('mall:umsGoods:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsGoodsQuery query) {
        List<UmsGoods> list = service.selectList(query, null);
        ExcelUtil<UmsGoodsVO> util = new ExcelUtil<>(UmsGoodsVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "商品信息数据"));
    }

    @ApiOperation("获取商品信息详细信息")
    @PreAuthorize("@ss.hasPermi('mall:umsGoods:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsGoods> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增商品信息")
    @PreAuthorize("@ss.hasPermi('mall:umsGoods:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsGoods umsGoods) {
        return ResponseEntity.ok(service.insert(umsGoods));
    }

    @ApiOperation("修改商品信息")
    @PreAuthorize("@ss.hasPermi('mall:umsGoods:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsGoods umsGoods) {
        return ResponseEntity.ok(service.update(umsGoods));
    }

    @ApiOperation("删除商品信息")
    @PreAuthorize("@ss.hasPermi('mall:umsGoods:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
