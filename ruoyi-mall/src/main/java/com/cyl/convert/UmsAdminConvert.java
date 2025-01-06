package com.cyl.convert;

import com.cyl.domain.UmsAdmin;
import com.cyl.pojo.dto.UmsAdminDTO;
import com.cyl.pojo.vo.UmsAdminVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 用户信息表  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsAdminConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsAdminDTO do2dto(UmsAdmin source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsAdmin dto2do(UmsAdminDTO source);

    List<UmsAdminVO> dos2vos(List<UmsAdmin> list);
}
