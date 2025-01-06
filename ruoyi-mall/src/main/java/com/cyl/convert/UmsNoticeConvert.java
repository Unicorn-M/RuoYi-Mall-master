package com.cyl.convert;

import com.cyl.domain.UmsNotice;
import com.cyl.pojo.dto.UmsNoticeDTO;
import com.cyl.pojo.vo.UmsNoticeVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 公告信息  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsNoticeConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsNoticeDTO do2dto(UmsNotice source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsNotice dto2do(UmsNoticeDTO source);

    List<UmsNoticeVO> dos2vos(List<UmsNotice> list);
}

