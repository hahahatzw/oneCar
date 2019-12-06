package com.sicau.one_car.controller;

import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 17:04 2019/12/4
 **/
@RestController
@Api(value = "消息controller")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "根据消息id获取消息",notes = "")
    @GetMapping("/message/{id}")
    public ResultVO getMessageById(@PathVariable("id") String id)
    {
        return messageService.getMessageById(id);
    }

    @ApiOperation(value = "获取某个用户所有接收的消息")
    @GetMapping("/userMessage/{userId}")
    public ResultVO getUserMessage(@PathVariable("userId") String userId)
    {
        return messageService.getUserMessages(userId);
    }

}
