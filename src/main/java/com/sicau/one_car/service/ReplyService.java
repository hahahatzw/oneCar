package com.sicau.one_car.service;

import com.sicau.one_car.entity.po.Reply;
import com.sicau.one_car.entity.vo.ResultVO;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 11:07 2019/11/30
 **/
public interface ReplyService {

    ResultVO addReply(Reply reply);
}
