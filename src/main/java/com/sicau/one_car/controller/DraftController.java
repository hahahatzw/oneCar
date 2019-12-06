package com.sicau.one_car.controller;

import com.sicau.one_car.entity.dto.DraftDto;
import com.sicau.one_car.entity.vo.DraftVO;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.DraftService;
import com.sicau.one_car.service.ImageRecognitionService;
import com.sicau.one_car.util.CopyProperties;
import com.sicau.one_car.util.DateUtil;
import com.sicau.one_car.util.FileUtil;
import com.sicau.one_car.util.IDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            @ApiParam("file") MultipartFile file,
            @RequestParam("labelsId")List<Integer> labelsId,
            DraftVO draftVO
            ) throws ParseException {
        draftVO.setViewNum(0);
        draftVO.setLikeNum(0);
        DraftDto draftDto=CopyProperties.copy(draftVO,DraftDto.class);
        draftDto.setCreateTime(DateUtil.FormateNowTime());
        draftDto.setDraftId(IDUtil.getUUID());
        String filename= FileUtil.uploadImage(file);
        String img="https://tzw-store.oss-cn-beijing.aliyuncs.com/one_car/"+filename;
        draftDto.setImgSrc(img);
        draftDto.setImgSrc(filename);
        return draftService.addDraft(draftDto,labelsId);
    }

    @GetMapping("/draft/{id}")
    public ResultVO getDraftById(@PathVariable("id") String id)
    {
        return draftService.getDraftById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResultVO deleteDraftId(@PathVariable("id") String id)
    {
        return draftService.deleteDraft(id);
    }

    @GetMapping("/draft/like/{id}")
    @ApiOperation(value = "喜欢+1")
    public ResultVO likeDraft(@PathVariable("id") String id,
                              HttpServletRequest request)
    {
        return draftService.likeDraft(id,request);
    }

    @ApiOperation(value = "获取帖子列表")
    @GetMapping("/drafts")
    public ResultVO getDraft(@RequestParam("pageNum")int pageNum,
                             @RequestParam("pageSize")int pageSize)
    {
        return draftService.getDrafts(pageNum,pageSize);
    }


}
