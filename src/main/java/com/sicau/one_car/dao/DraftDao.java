package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.DraftVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 14:44 2019/11/17
 **/

public interface DraftDao {

    boolean insertDraft(DraftDto draftDto);

    DraftDto selectDraftWithLabel(@Param("id") String id);
}
