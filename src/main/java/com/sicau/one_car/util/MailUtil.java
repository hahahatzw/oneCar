package com.sicau.one_car.util;

import com.sun.mail.util.MailSSLSocketFactory;


import javax.mail.*;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 15:36 2019/11/28
 **/
public class MailUtil {

    public static final String from="1339502082@qq.com";
    public static final String password="ztvmzghpwqribaac";


    /**
     * 发送邮件并将code返回
     * @param email  收件方
     * @return code  激活码
     */
    public static String run(String email) {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String code=IDUtil.getEmailCode();
        String from = "1339502082@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)

        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);


            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication(from, password); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("账号激活");
            // 2.4设置邮件内容
            String content ="<html><head></head><body><h1>欢迎注册,激活请复制如下激活码</h1>"
                    + " <p>激活码为："+code+"<p>"
                    + "</body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
            return  code;
        } catch (Exception e) {
            System.out.println("邮件成功失败!");
            e.printStackTrace();
            return null;
        }

    }
}
