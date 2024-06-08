package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.FindInfoService;
import com.teamproject.gaxga.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class FindInfoController {

    @Autowired
    private FindInfoService findInfoService;

    @Autowired
    private MailService mailService;

    @GetMapping("/findInfo")
    public String showFindInfo() {
        return "public/accountManagement/findInfo";
    }

    @PostMapping("/findInfo/ID")
    public String findId(User user, RedirectAttributes redirectAttributes){
        User data = findInfoService.findUserInfoId(user);
        if(data == null){
            redirectAttributes.addFlashAttribute("msg", "회원정보가 없습니다.");
            return "redirect:/findInfo";
        } else{
            redirectAttributes.addFlashAttribute("msg", "회원님의 ID는 : " + data.getGaId());
            return "redirect:/findInfo";
        }
    }
    @PostMapping("/findInfo/Pass")
    public String findPass(User user, RedirectAttributes redirectAttributes){
        User data = findInfoService.findUserInfoPass(user);
        if(data == null){
            redirectAttributes.addFlashAttribute("msg", "입력하신 정보가 틀립니다.");
            return "redirect:/findInfo";
        } else{
            mailService.sendSimpleMail("[GA X GA] 임시 비밀번호 발송", "inseon0806@gmail.com", "임시 비밀번호입니다. 마이페이지에서 비밀번호 변경해주세요", data);
            redirectAttributes.addFlashAttribute("msg", "회원가입에 입력하신 이메일로 임시 비밀번호 보내드렸습니다.");
            return "redirect:/login";
        }
    }
}