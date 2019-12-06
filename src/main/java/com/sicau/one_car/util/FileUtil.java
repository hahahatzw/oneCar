package com.sicau.one_car.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSS;
import com.sicau.one_car.common.Const;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Description:图片处理
 * @author tzw
 * CreateTime 21:55 2019/10/23
 **/
public class FileUtil {



    /**
     * 图片转为Base64格式编码
     */

    public static String transImageToBase64(MultipartFile file) throws IOException {

        BASE64Encoder base64Encoder =new BASE64Encoder();
        String base64EncoderImg=base64Encoder.encode(file.getBytes());
         return base64EncoderImg;
    }

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        }

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流
        FileInputStream fis = new FileInputStream(filePath);
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];
        // 用于保存实际读取的字节数
        int hasRead = 0;
        while ( (hasRead = fis.read(bbuf)) > 0 ) {
            sb.append(new String(bbuf, 0, hasRead));
        }
        fis.close();
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }


    /**
     * 上传图片至oss
     */
    public static String uploadImage(MultipartFile file)
    {
        if(file.getSize() > Const.FileEnum.File_Size.getCode()){
            return Const.FileEnum.File_Size.getMsg();
        }
        String type = file.getOriginalFilename().split("\\.")[1];
        if(!"jpg".equals(type) && !"png".equals(type)){
            return Const.FileEnum.File_Type_Error.getMsg();
        }
        /**
         * aliyun对象存储oss管理的RAM账号
         */
        String endpoint="http://oss-cn-beijing.aliyuncs.com";
        String accessKeyID="LTAI4FndULytb2AXzBUBecCU";
        String accessKeySecret="LNhUfXY8J0RmqwONMayDu76l0RSvS0";
        String bucketName="tzw-store";
        OSS ossClient = new OSSClient(endpoint,accessKeyID,accessKeySecret);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(date);
        String fileName = time + "." + file.getOriginalFilename().split("\\.")[1];
        String objectName="one_car/"+fileName;
        try{
            ossClient.putObject(bucketName,objectName,file.getInputStream());
            return fileName;
        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }finally {
            ossClient.shutdown();
        }
    }



}
