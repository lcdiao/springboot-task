package cn.lcdiao.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setSubject("通知-今晚开会");
        simpleMailMessage.setText("今晚7:30开会");
        simpleMailMessage.setTo("javalcdiao@163.com");
        simpleMailMessage.setFrom("120879566@qq.com");
        //发送邮件
        javaMailSender.send(simpleMailMessage);
    }


    //发送复杂邮件
    @Test
    public void test02() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("通知-有情况");
        helper.setText("<b style='color:red'>今晚吃啥？？？</b>",true);
        helper.setTo("javalcdiao@163.com");
        //helper.setTo("2544971181@qq.com");
        helper.setFrom("120879566@qq.com");
        //上传文件
        helper.addAttachment("1.jpg",new File("D:/root/images/1.jpg"));
        helper.addAttachment("2.jpg",new File("D:/root/images/2.jpg"));


        //发送邮件
        javaMailSender.send(message);
    }

}
