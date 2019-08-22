package util;



import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

import sun.font.CreatedFontTracker;



public class VerificationCode {
	public static String sendMail(String Receive) throws MessagingException {
		String code = "";
		Properties properties = System.getProperties();// 获取系统属性		 
        properties.setProperty("mail.smtp.host", "smtp.qq.com");// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证
        
		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	        
	        // 1.获取默认session对象
	        Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1023509171@qq.com", "kpjkmdgkngucbfif"); // 发件人邮箱账号、授权码
                }
            });
	        
	     // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress("1023509171@qq.com"));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(Receive));
            // 2.3设置邮件主题
            message.setSubject("账号激活");
            // 2.4设置邮件内容
            code = VerificationCode.createVerificationCode();
            String content = "<h1>Email地址验证<br/></h1>"+ 
            		"尊敬的用户您好：<br/>"+
            		"您收到这封邮件是融e购进行新用户注册或者用户忘记密码<br/>"+
            		"您此次的验证码为：<h3 style='color:red;'>" + code + "</h3><br/>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
			return code;
	
	}
	static String createVerificationCode(){
		Random random = new Random();
		String result="";
		for (int i=0;i<6;i++)
		{
			result+=random.nextInt(10);
		}
		return result;
	}
}
