package com.sicau.one_car.controller;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.ImageRecognitionService;
import com.sicau.one_car.util.Base64Util;
import com.sicau.one_car.util.FileUtil;
import com.sicau.one_car.util.ResultVOUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

/**
 * Description:图像识别controller层
 * @author tzw
 * CreateTime 19:41 2019/10/25
 **/
@RestController
@Api(value = "图像识别接口",description = "用于图像识别上传文件返回结果接口")

public class ImageRecognitionController {

    @Autowired
    private ImageRecognitionService imageRecognitionService;

    @ApiOperation(value = "图片识别1" ,notes = "由图片路径获取图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "识别类型",required = true, dataType = "int",paramType ="query" )
    })
    @GetMapping("/picture1")
    public ResultVO PictureRecognition1(@RequestParam("filePath") String filePath,
                               @RequestParam("type") int type) throws IOException {



         byte[] imgData = FileUtil.readFileByBytes(filePath);
         String  imgSrc= Base64Util.encode(imgData);
        //车辆检测
        if(type== Const.ImageRecognitionType.Vehicle_Detection.getCode())
        {
            return imageRecognitionService.vehicleDetection(imgSrc);
        }
        //else if()
        return null;
    }

    @ApiOperation(value = "图片识别2" ,notes = "由图片上传获取图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "识别类型",required = true, dataType = "int",paramType ="query" )
    })
    @PostMapping("/picture2")
    public ResultVO PictureRecognition2(@ApiParam("file") MultipartFile file,
                               @RequestParam("type") int type) throws IOException {


        String imgSrc= Base64Util.encode(file.getBytes());
        //车辆检测
        if(type== Const.ImageRecognitionType.Vehicle_Detection.getCode())
        {
            return imageRecognitionService.vehicleDetection(imgSrc);
        }
        else if(type== Const.ImageRecognitionType.Vehicle_Damage.getCode())
        {
            return imageRecognitionService.vehicleDamage(imgSrc);
        }
        else if(type== Const.ImageRecognitionType.Vehicle_Attributes.getCode())
        {
            return imageRecognitionService.vehicleAttribute(imgSrc);
        }
        else if(type== Const.ImageRecognitionType.Vehicle_Segmentation.getCode())
        {
            return imageRecognitionService.vehicleSegmentation(imgSrc);
        }
        else if(type==Const.ImageRecognitionType.Vehicle_Detect.getCode())
        {
            return imageRecognitionService.vehicleDetect(imgSrc);
        }
        else
            return new ResultVOUtil().fail("无其余识别类型");
    }
}
