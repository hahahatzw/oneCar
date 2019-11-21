package com.sicau.one_car.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.json.JSONObject;


import java.io.*;

import java.net.URLEncoder;

/**
 * Description:百度接口调用工具类
 * @author tzw
 * CreateTime 21:09 2019/10/21
 **/
public class AIutil {

    public static Logger logger = LoggerFactory.getLogger(AIutil.class);

    //图像识别key及secret
    private static final String AccessKey="ABVskwCbBFsV6kj5uNQZXjM5";
    private static final String SecretKey="uQHlCQ9tjD81LhgViHGe4G2S8gvYQXf0";
    private static final String accessToken=getAccessToken(AccessKey,SecretKey);



    public static String getAccessToken(String accessKey,String secretKey)
    {
        String url="https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id="+accessKey+"&client_secret="+secretKey;
        JSONObject jsonObject= null;
        try {
            jsonObject = HttpUtil.httpRequest(url,"POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(jsonObject.containsKey("access_token"))
        {
            String accessToken=jsonObject.getString("access_token");
            return accessToken;
        }
        return null;
    }

    public static JSONObject vehicleDetection(String imgStr)
    {
        JSONObject jsonObject=null;
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car";
        try {
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam + "&top_num=" + 5;

            String result = HttpUtil.post(url, accessToken, param);
            jsonObject=JSONObject.fromObject(result);
            System.out.println(result);
            return jsonObject;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {


    }


}
