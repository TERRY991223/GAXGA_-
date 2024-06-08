package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

@Service("mailService")
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    // 단순 문자 메일 보내기
    public void sendSimpleMail(String mailTitle, String sender, String content, User user) {
        if(user != null){
            String newPass = createRandomGaPass();
            String encodedPass = bCryptPasswordEncoder.encode(newPass);
            user.setGaPass(encodedPass);
            userRepository.save(user);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(mailTitle);
            message.setFrom(sender);
            message.setTo(user.getGaEmail());
            message.setText(content + newPass);
            mailSender.send(message);
        }
    }

    // 랜덤 비밀번호 생성
    public String createRandomGaPass(){
        String[] text = new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T","U", "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t","u", "v", "w", "x", "y", "z"
        };
        String newGaPass = "";
        for(int i = 0; i < 8; i++){
            int randIndex = (int)(Math.random()*text.length);
            newGaPass += text[randIndex];
        }

        return newGaPass;
    }
}
