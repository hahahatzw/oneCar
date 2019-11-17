package com.sicau.one_car.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * @author tzw
 * CreateTime 15:13 2019/11/17
 **/
public interface LabelDao {

    boolean insertRelationWithDraft(@Param("draftId") String draftId, List<Integer> labelsId);
}
