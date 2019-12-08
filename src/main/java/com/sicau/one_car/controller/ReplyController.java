package com.sicau.one_car.controller;

import com.sicau.one_car.entity.dto.ReplyDto;
import com.sicau.one_car.entity.po.Reply;
import com.sicau.one_car.entity.vo.ReplyVO;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.ReplyService;
import com.sicau.one_car.util.CopyProperties;
import com.sicau.one_car.util.DateUtil;
import com.sicau.one_car.util.IDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 11:09 2019/11/30
 **/
@RestController
@Api(value = "评论管理",description = "评论回复...")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @ApiOperation(value = "评论增加")
    @PostMapping("/reply")
    public ResultVO addReply(
             ReplyVO replyVO
            ) throws ParseException {
        Reply reply= CopyProperties.copy(replyVO, Reply.class);
        reply.setReplyId(IDUtil.getUUID());
        reply.setCreateTime(DateUtil.FormateNowTime());
        return replyService.addReply(reply);
    }
}
