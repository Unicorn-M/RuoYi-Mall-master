package com.cyl.convert;

import com.cyl.domain.UmsProject;
import com.cyl.pojo.dto.UmsProjectDTO;
import com.cyl.pojo.vo.UmsProjectVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 扶贫项目申请增删改查  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsProjectConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsProjectDTO do2dto(UmsProject source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsProject dto2do(UmsProjectDTO source);

    List<UmsProjectVO> dos2vos(List<UmsProject> list);
}
