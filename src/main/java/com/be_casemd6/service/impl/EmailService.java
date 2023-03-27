package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.EmailDetails;
import com.be_casemd6.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendSimpleMail(EmailDetails details, String subject,String text) {
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(text);
            mailMessage.setSubject(subject);
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendHTMLEmail(Account account) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            String htmlMsg = "Dear "+account.getFullName()+",<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"http://103.57.220.123/verify/"+account.getVerificationCode()+"\""+"target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "Dating Website.";;
            helper.setText(htmlMsg, true);
            helper.setTo(account.getEmail());
            helper.setSubject("Thư hệ thống: Website Thuê người yêu.");
            helper.setFrom(sender);
            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully...";
        }
        catch (Exception e){
            return "Error while Sending Mail";
        }
    }
}
