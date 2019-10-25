package com.sicau.one_car.util;

import com.sicau.one_car.entity.vo.MyX509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * Description:
 * @author tzw
 * CreateTime 21:09 2019/10/21
 **/
public class AIutil {

    public static Logger logger = LoggerFactory.getLogger(AIutil.class);

    //图像识别key及secret
    private static final String AccessKey="ABVskwCbBFsV6kj5uNQZXjM5";
    private static final String SecretKey="uQHlCQ9tjD81LhgViHGe4G2S8gvYQXf0";
    private static final String accessToken=getAccessToken(AccessKey,SecretKey);


    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl
     *            请求地址
     * @param requestMethod
     *            请求方式（GET、POST）
     * @param outputStr
     *            提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl,
                                         String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            logger.info("58");
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            logger.info("60");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            logger.info("66");
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
                    .openConnection();
            logger.info("69");
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                logger.info("83");
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("Weixin server connection timed out.");
            ce.printStackTrace();
        } catch (Exception e) {
            logger.error("https request error:{}",e);
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static String getAccessToken(String accessKey,String secretKey)
    {
        String url="https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id="+accessKey+"&client_secret="+secretKey;
        JSONObject jsonObject=httpRequest(url,"POST",null);
        if(jsonObject.containsKey("access_token"))
        {
            String accessToken=jsonObject.getString("access_token");
            return accessKey;
        }
        return null;
    }

    public static void main(String[] args) {


    }


}
