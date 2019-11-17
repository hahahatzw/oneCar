package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.dao.DraftDao;
import com.sicau.one_car.dao.LabelDao;
import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.DraftService;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 22:09 2019/11/13
 **/
@Service
public class DraftServiceImpl implements DraftService {

    @Autowired
    private ResultVOUtil resultVOUtil;

    @Autowired
    private DraftDao draftDao;

    @Autowired
    private LabelDao labelDao;

    @Override
    public ResultVO addDraft(DraftDto draftDto) {
        try{
            boolean result1=draftDao.insertDraft(draftDto);
            boolean result2=labelDao.insertRelationWithDraft(draftDto.getId(),draftDto.getLabelsId());
             return null;
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }
}
