package com.cyl.controller;

import java.util.List;

import com.cyl.convert.UmsOrderConvert;
import com.cyl.domain.UmsOrder;
import com.cyl.pojo.query.UmsOrderQuery;
import com.cyl.pojo.vo.UmsOrderVO;
import com.cyl.service.UmsOrderService;
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
 * 订单Controller
 *
 * @author admin
 * @date 2025-01-06
 */
@Api(description ="订单接口列表")
@RestController
@RequestMapping("/mall/umsOrder")
public class UmsOrderController extends BaseController {
    @Autowired
    private UmsOrderService service;
    @Autowired
    private UmsOrderConvert convert;

    @ApiOperation("查询订单列表")
    @PreAuthorize("@ss.hasPermi('mall:umsOrder:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<UmsOrder>> list(@RequestBody UmsOrderQuery query, Pageable page) {
        List<UmsOrder> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出订单列表")
    @PreAuthorize("@ss.hasPermi('mall:umsOrder:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(UmsOrderQuery query) {
        List<UmsOrder> list = service.selectList(query, null);
        ExcelUtil<UmsOrderVO> util = new ExcelUtil<>(UmsOrderVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "订单数据"));
    }

    @ApiOperation("获取订单详细信息")
    @PreAuthorize("@ss.hasPermi('mall:umsOrder:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UmsOrder> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增订单")
    @PreAuthorize("@ss.hasPermi('mall:umsOrder:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody UmsOrder umsOrder) {
        return ResponseEntity.ok(service.insert(umsOrder));
    }

    @ApiOperation("修改订单")
    @PreAuthorize("@ss.hasPermi('mall:umsOrder:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody UmsOrder umsOrder) {
        return ResponseEntity.ok(service.update(umsOrder));
    }

    @ApiOperation("删除订单")
    @PreAuthorize("@ss.hasPermi('mall:umsOrder:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
