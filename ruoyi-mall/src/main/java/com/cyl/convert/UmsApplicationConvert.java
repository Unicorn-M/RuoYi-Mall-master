package com.cyl.convert;

import com.cyl.domain.UmsApplication;
import com.cyl.pojo.dto.UmsApplicationDTO;
import com.cyl.pojo.vo.UmsApplicationVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 贫困身份申请  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsApplicationConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsApplicationDTO do2dto(UmsApplication source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsApplication dto2do(UmsApplicationDTO source);

    List<UmsApplicationVO> dos2vos(List<UmsApplication> list);
}
