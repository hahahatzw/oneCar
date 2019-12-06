package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.RepliesDto;
import com.sicau.one_car.entity.dto.ReplyDto;
import com.sicau.one_car.entity.po.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 11:03 2019/11/30
 **/
public interface ReplyDao {

    boolean deleteAllReplyByDraft(@Param("id") String id);

    boolean insert(Reply reply);

    ReplyDto selectReply(String replyId);

    List<ReplyDto> selectReplyByDraft(@Param("draftId") String draftId);

    List<RepliesDto> selectReplies(@Param("replyId") String replyId);
}
