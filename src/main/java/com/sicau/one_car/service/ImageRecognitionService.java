package com.sicau.one_car.service;

import com.sicau.one_car.entity.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 17:35 2019/11/5
 **/
public interface ImageRecognitionService {

    ResultVO vehicleDetection(String filePath);
}
