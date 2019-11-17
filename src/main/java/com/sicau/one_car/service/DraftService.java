package com.sicau.one_car.service;

import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.ResultVO;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 22:08 2019/11/13
 **/
public interface DraftService {

    ResultVO addDraft(DraftDto draftDto);
}
