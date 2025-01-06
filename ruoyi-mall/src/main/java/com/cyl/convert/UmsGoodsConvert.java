package com.cyl.convert;
import com.cyl.domain.UmsGoods;
import com.cyl.pojo.dto.UmsGoodsDTO;
import com.cyl.pojo.vo.UmsGoodsVO;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * 商品信息  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsGoodsConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsGoodsDTO do2dto(UmsGoods source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsGoods dto2do(UmsGoodsDTO source);

    List<UmsGoodsVO> dos2vos(List<UmsGoods> list);
}
