package com.cyl.convert;

import com.cyl.domain.UmsFarmhouse;
import com.cyl.pojo.dto.UmsFarmhouseDTO;
import com.cyl.pojo.vo.UmsFarmhouseVO;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * 农家乐增删改查  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsFarmhouseConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsFarmhouseDTO do2dto(UmsFarmhouse source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsFarmhouse dto2do(UmsFarmhouseDTO source);

    List<UmsFarmhouseVO> dos2vos(List<UmsFarmhouse> list);
}
