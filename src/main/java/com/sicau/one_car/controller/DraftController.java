package com.sicau.one_car.controller;

import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.DraftVO;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.DraftService;
import com.sicau.one_car.service.ImageRecognitionService;
import com.sicau.one_car.util.CopyProperties;
import com.sicau.one_car.util.IDUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:论坛帖子问题发表
 * @author tzw
 * CreateTime 21:40 2019/11/10
 **/

@RestController
@Api(value = "论坛帖子信息",description = "论坛帖子的增删查改")
public class DraftController {

    @Autowired
    private DraftService draftService;

    @PostMapping("/draft")
    public ResultVO addDraft(
            @RequestBody DraftVO draftVO,
            @RequestParam("lablelist")List<Integer> lablelist
            ){
        draftVO.setViewNum(0);
        draftVO.setLikeNum(0);
        DraftDto draftDto= CopyProperties.copy(draftVO, DraftDto.class);
        draftDto.setId(IDUtil.getUUID());
        draftDto.setLabelsId(lablelist);
        return draftService.addDraft(draftDto);
    }


}
