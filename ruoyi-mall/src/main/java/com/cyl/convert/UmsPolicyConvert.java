package com.cyl.convert;

import com.cyl.domain.UmsPolicy;
import com.cyl.pojo.dto.UmsPolicyDTO;
import com.cyl.pojo.vo.UmsPolicyVO;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * 扶贫信息增删改查  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsPolicyConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsPolicyDTO do2dto(UmsPolicy source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsPolicy dto2do(UmsPolicyDTO source);

    List<UmsPolicyVO> dos2vos(List<UmsPolicy> list);
}
