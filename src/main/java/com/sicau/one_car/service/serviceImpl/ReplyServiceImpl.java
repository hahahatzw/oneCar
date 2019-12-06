package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.dao.DraftDao;
import com.sicau.one_car.dao.ReplyDao;
import com.sicau.one_car.entity.po.Message;
import com.sicau.one_car.entity.po.Reply;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.MessageService;
import com.sicau.one_car.service.ReplyService;
import com.sicau.one_car.util.DateUtil;
import com.sicau.one_car.util.IDUtil;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.UUID;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 11:07 2019/11/30
 **/
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private DraftDao draftDao;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ResultVOUtil resultVOUtil;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addReply(Reply reply) {
        try{
            boolean result=replyDao.insert(reply);
            Message message=new Message();
            message.setMessageId(IDUtil.getUUID());
            message.setRelationType(Const.MessageEnum.Reply_Draft.getCode());
            message.setRelationId(reply.getDraftId());
            message.setMessageContent(Const.MessageEnum.Reply_Draft.getContent());
            message.setSendId(reply.getReplyUserId());
            message.setGetId(draftDao.selectUserIdByDraft(reply.getDraftId()));
            message.setCreateTime(DateUtil.FormateNowTime());
            ResultVO resultVO=messageService.sendMessage(message);
            if(result&&resultVO.getCode()==1)
                return resultVOUtil.success(reply);
            else
                return resultVOUtil.fail();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return resultVOUtil.unknownError();
        }

    }
}
