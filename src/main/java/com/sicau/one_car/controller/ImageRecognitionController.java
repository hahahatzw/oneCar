package com.sicau.one_car.controller;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.ImageRecognitionService;
import com.sicau.one_car.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @ApiOperation(value = "上传图片" ,notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "识别类型",required = true, dataType = "int",paramType ="query" )
    })
    @PostMapping("/picture")
    public ResultVO getPicture(@RequestParam("filePath") String filePath,
                               @RequestParam("type") int type) throws IOException {



        //车辆检测
        if(type== Const.ImageRecognitionType.Vehicle_Detection.getCode())
        {
            return imageRecognitionService.vehicleDetection(filePath);
        }else return null;
    }

}
