package com.sicau.one_car.service;

import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.DraftVO;
import com.sicau.one_car.entity.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 22:08 2019/11/13
 **/
public interface DraftService {

    ResultVO addDraft(DraftDto draftDto, List<Integer> labelsId);

    ResultVO getDraftById(String id);

    ResultVO deleteDraft(String id);

    ResultVO likeDraft(String id, HttpServletRequest request);

    ResultVO getDrafts(int pageNum, int pageSize);
}
