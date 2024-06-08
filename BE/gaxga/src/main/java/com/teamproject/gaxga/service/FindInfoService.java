package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FindInfoService {

    @Autowired
    private UserRepository userRepository;

    public User findUserInfoId(User user){
        User data = userRepository.findByGaNickAndGaPhone(user.getGaNick(), user.getGaPhone());
        if(data == null){
            System.out.println("회원정보가 없습니다.");
            return null;
        }else{
            System.out.println("회원정보 ID : " + data.getGaId());
            return data;
        }
    }

    public User findUserInfoPass(User user){
        User data = userRepository.findByGaIdAndGaPhone(user.getGaId(), user.getGaPhone());
        if(data == null){
            System.out.println("아이디나 비밀번호가 틀렸습니다. id :  " +user.getGaId() + ", phone :  " +user.getGaPhone());
            return null;
        }else{
            System.out.println("비밀번호 찾기 임시이메일 발송");
            return data;
        }
    }
}
