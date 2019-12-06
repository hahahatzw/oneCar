package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.MessageDto;
import com.sicau.one_car.entity.po.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 20:33 2019/12/4
 **/
public interface MessageDao {

    boolean insertMessage(Message message);

    MessageDto selectMessageById(@Param("id") String id);

    List<MessageDto> selectMessageByUserId(String userId);

    boolean updateStatus(@Param("status") int status,@Param("id") String id);

}
