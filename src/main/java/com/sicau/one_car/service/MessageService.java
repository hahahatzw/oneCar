package com.sicau.one_car.service;

import com.sicau.one_car.entity.po.Message;
import com.sicau.one_car.entity.vo.ResultVO;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 17:49 2019/12/4
 **/
public interface MessageService {

    ResultVO sendMessage(Message message);

    ResultVO getMessageById(String id);

    ResultVO getUserMessages(String userId);
}
