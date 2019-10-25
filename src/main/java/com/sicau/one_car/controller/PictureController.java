package com.sicau.one_car.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description:图像识别controller层
 * @author tzw
 * CreateTime 19:41 2019/10/25
 **/
@RestController
@Api(value = "图像识别接口",description = "用于图像识别上传文件返回结果接口")

public class PictureController {

    @ApiOperation(value = "上传图片" ,notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imgFile",value = "图片",required = true, dataType = "file",paramType ="query" ),
            @ApiImplicitParam(name = "type",value = "识别类型",required = true, dataType = "int",paramType ="query" )
    })
    @PostMapping("/picture")
    public String getPicture(MultipartFile file,int type)
    {
           return null;
    }

}
