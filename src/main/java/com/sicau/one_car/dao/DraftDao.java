package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.DraftVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 14:44 2019/11/17
 **/

public interface DraftDao {

    boolean insertDraft(DraftDto draftDto);

    DraftDto selectDraftWithLabel(@Param("id") String id);

    boolean deleteDraft(@Param("id") String id);

    boolean updateDraftViewNum(@Param("viewNum") int viewNum,@Param("draftId") String draftId);

    boolean updateDraftLikeNum(@Param("likeNum") int likeNum, @Param("draftId") String draftId);

    String selectUserIdByDraft(@Param("draftId") String draftId);

    List<DraftDto> getDrafts();
}
