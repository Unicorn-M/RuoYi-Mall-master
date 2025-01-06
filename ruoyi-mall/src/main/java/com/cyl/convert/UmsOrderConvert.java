package com.cyl.convert;

import com.cyl.domain.UmsOrder;
import com.cyl.pojo.dto.UmsOrderDTO;
import com.cyl.pojo.vo.UmsOrderVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 订单  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsOrderConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsOrderDTO do2dto(UmsOrder source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsOrder dto2do(UmsOrderDTO source);

    List<UmsOrderVO> dos2vos(List<UmsOrder> list);
}
