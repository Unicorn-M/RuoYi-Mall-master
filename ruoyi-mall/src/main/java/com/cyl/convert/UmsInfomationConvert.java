package com.cyl.convert;

import com.cyl.domain.UmsInfomation;
import com.cyl.pojo.dto.UmsInfomationDTO;
import com.cyl.pojo.vo.UmsInfomationVO;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * 资讯信息增删改查  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsInfomationConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsInfomationDTO do2dto(UmsInfomation source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsInfomation dto2do(UmsInfomationDTO source);

    List<UmsInfomationVO> dos2vos(List<UmsInfomation> list);
}
