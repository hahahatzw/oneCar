package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.ImageRecognitionService;
import com.sicau.one_car.util.AIutil;
import com.sicau.one_car.util.HttpUtil;
import com.sicau.one_car.util.ResultVOUtil;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 17:35 2019/11/5
 **/

@Service
public class ImageRecognitionServiceImpl implements ImageRecognitionService {

    @Autowired
    private ResultVOUtil resultVOUtil;


    @Override
    public ResultVO vehicleDetection(String imgSrc) {
        JSONObject jsonObject=AIutil.vehicleDetection(imgSrc);
        if(jsonObject==null)
            return resultVOUtil.fail();
        else
            return resultVOUtil.success(jsonObject);
    }

    @Override
    public ResultVO vehicleDamage(String imgSrc) {
        JSONObject jsonObject=AIutil.vehicleDamage(imgSrc);
        if(jsonObject==null)
            return resultVOUtil.fail();
        else
            return resultVOUtil.success(jsonObject);
    }

    @Override
    public ResultVO vehicleAttribute(String imgSrc) {
        JSONObject jsonObject=AIutil.vehicleAttribute(imgSrc);
        if(jsonObject==null)
            return resultVOUtil.fail();
        else
            return resultVOUtil.success(jsonObject);
    }

    @Override
    public ResultVO vehicleSegmentation(String imgSrc) {
//        JSONObject jsonObject=AIutil.vehicle(imgSrc);
//        if(jsonObject==null)
//            return resultVOUtil.fail();
//        else
//            return resultVOUtil.success(jsonObject);
        return null;
    }

    @Override
    public ResultVO vehicleDetect(String imgSrc) {
        JSONObject jsonObject=AIutil.vehicleDetect(imgSrc);
        if(jsonObject==null)
            return resultVOUtil.fail();
        else
            return resultVOUtil.success(jsonObject);
    }
}
