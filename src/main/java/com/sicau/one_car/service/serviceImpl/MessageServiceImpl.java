package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.dao.MessageDao;
import com.sicau.one_car.entity.dto.MessageDto;
import com.sicau.one_car.entity.po.Message;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.MessageService;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 18:01 2019/12/4
 **/

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ResultVOUtil resultVOUtil;

    @Override
    public ResultVO sendMessage(Message message) {
        try{
            boolean result=messageDao.insertMessage(message);
            if(result)
                return resultVOUtil.success();
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }



    }

    @Override
    public ResultVO getMessageById(String id) {
        try{
            MessageDto messageDto=messageDao.selectMessageById(id);
            int status=1;
            boolean result=messageDao.updateStatus(status,id);
            if(messageDto!=null&&result)
                return resultVOUtil.success(messageDto);
            else
                return resultVOUtil.fail();

        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }

    @Override
    public ResultVO getUserMessages(String userId) {
        try{
            List<MessageDto> messageDtos=messageDao.selectMessageByUserId(userId);
            if(messageDtos!=null)
                return resultVOUtil.success(messageDtos);
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.fail();
        }
    }
}
