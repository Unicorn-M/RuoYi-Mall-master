package com.cyl.convert;

import com.cyl.domain.UmsPolicycomment;
import com.cyl.pojo.dto.UmsPolicycommentDTO;
import com.cyl.pojo.vo.UmsPolicycommentVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 扶贫政策评论增删改查  DO <=> DTO <=> VO / BO / Query
 *
 * @author admin
 */
@Mapper(componentModel = "spring")
public interface UmsPolicycommentConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    UmsPolicycommentDTO do2dto(UmsPolicycomment source);

    /**
     * @param source DTO
     * @return DO
     */
    UmsPolicycomment dto2do(UmsPolicycommentDTO source);

    List<UmsPolicycommentVO> dos2vos(List<UmsPolicycomment> list);
}
