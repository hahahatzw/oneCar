package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.DraftDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 14:44 2019/11/17
 **/

public interface DraftDao {

    boolean insertDraft(DraftDto draftDto);
}
