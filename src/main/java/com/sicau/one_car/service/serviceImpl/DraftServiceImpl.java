package com.sicau.one_car.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicau.one_car.common.Const;
import com.sicau.one_car.dao.DraftDao;
import com.sicau.one_car.dao.LabelDao;
import com.sicau.one_car.dao.ReplyDao;
import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.dto.RepliesDto;
import com.sicau.one_car.entity.dto.ReplyDto;
import com.sicau.one_car.entity.po.Message;
import com.sicau.one_car.entity.po.User;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.DraftService;
import com.sicau.one_car.service.MessageService;
import com.sicau.one_car.util.DateUtil;
import com.sicau.one_car.util.IDUtil;
import com.sicau.one_car.util.ResultVOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private MessageService messageService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addDraft(DraftDto draftDto, List<Integer> labelsId) {
        try{
            boolean result1=draftDao.insertDraft(draftDto);
            boolean result2=labelDao.insertRelationWithDraft(draftDto.getDraftId(),labelsId);
            if(result1&&result2)
                return resultVOUtil.success(draftDto);
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
    @Transactional(rollbackFor = Exception.class)
    public ResultVO getDraftById(String id) {
        try{
            DraftDto draftDto=draftDao.selectDraftWithLabel(id);
            List<ReplyDto> replyDtoList=replyDao.selectReplyByDraft(draftDto.getDraftId());
            draftDto.setReplyList(replyDtoList);
            //观看数+1
            boolean result=draftDao.updateDraftViewNum(draftDto.getViewNum(),draftDto.getDraftId());
            if(draftDto!=null)
                return resultVOUtil.success(draftDto);
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
    @Transactional
    public ResultVO deleteDraft(String id) {
        try{
            boolean result1=draftDao.deleteDraft(id);
            boolean result2=replyDao.deleteAllReplyByDraft(id);
            boolean result3=labelDao.deleteAllRelation(id);
            if(result1&&result2&&result3)
                return resultVOUtil.success();
            else
            {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return resultVOUtil.fail();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return resultVOUtil.unknownError();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO likeDraft(String id, HttpServletRequest request) {
        try{
            User user=(User)request.getSession().getAttribute(Const.RoleEnum.USER.getRole());
            if(user==null)
                return resultVOUtil.fail("请重新登陆噢");
            DraftDto draftDto=draftDao.selectDraftWithLabel(id);
            System.out.println("----------------------"+draftDto.getLikeNum());
            draftDto.setLikeNum(draftDto.getLikeNum()+1);
            System.out.println("------------------------"+draftDto.getLikeNum());
            Message message=new Message();
            message.setMessageId(IDUtil.getUUID());
            message.setMessageContent(Const.MessageEnum.Like_Draft.getContent());
            message.setRelationType(Const.MessageEnum.Like_Draft.getCode());
            message.setRelationId(draftDto.getDraftId());
            message.setSendId(user.getUserId());
            message.setGetId(draftDao.selectUserIdByDraft(draftDto.getDraftId()));
            message.setCreateTime(DateUtil.FormateNowTime());
            ResultVO resultVO=messageService.sendMessage(message);
            boolean result=draftDao.updateDraftLikeNum(draftDto.getLikeNum(),draftDto.getDraftId());
            if(result&&resultVO.getCode()==1)
                 return resultVOUtil.success(draftDto);
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
    public ResultVO getDrafts() {
        try{
            List<DraftDto> draftDtos=draftDao.getDrafts();
            if(draftDtos!=null)
                return resultVOUtil.success(draftDtos);
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }

    @Override
    public ResultVO getUserDrafts(String userId) {
        try{
            List<DraftDto> draftDtos=draftDao.selectDraftsByUserId(userId);
            if(draftDtos!=null)
                return resultVOUtil.success(draftDtos);
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }
}
