package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.dao.DraftDao;
import com.sicau.one_car.dao.LabelDao;
import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.DraftService;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

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
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addDraft(DraftDto draftDto, List<Integer> labelsId) {
        try{
            boolean result1=draftDao.insertDraft(draftDto);
            boolean result2=labelDao.insertRelationWithDraft(draftDto.getDraftId(),labelsId);
            if(result1&&result2)
                return resultVOUtil.success();
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return resultVOUtil.unknownError();
        }
    }

    @Override
    public ResultVO getDraftById(String id) {
        try{
            DraftDto draftDto=draftDao.selectDraftWithLabel(id);
            if(draftDto!=null)
                return resultVOUtil.success(draftDto);
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }
}
