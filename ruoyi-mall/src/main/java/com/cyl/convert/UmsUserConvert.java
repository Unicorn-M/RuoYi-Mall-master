package com.cyl.convert;

import com.cyl.domain.UmsUser;
import com.cyl.pojo.dto.UmsUserDTO;
import com.cyl.pojo.vo.UmsUserVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 农家信息增删改查  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsUserConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsUserDTO do2dto(UmsUser source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsUser dto2do(UmsUserDTO source);

    List<UmsUserVO> dos2vos(List<UmsUser> list);
}
