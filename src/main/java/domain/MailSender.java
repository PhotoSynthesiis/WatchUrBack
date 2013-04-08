package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mailSender")
public class MailSender {
    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendEmailTo(String email) {
        mailSender.send(buildMessage(email, "Your code has a bug", "Fuck, You are a loser"));
    }

    private SimpleMailMessage buildMessage(String emailAddress, String subject, String content) {
        String fromAddress = "admin@thebank.com";

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(emailAddress);
        mailMessage.setFrom(fromAddress);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        return mailMessage;
    }
}
