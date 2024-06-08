package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.JoinMembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class JoinMembershipController {
    @Autowired
    private JoinMembershipService joinMembershipService;

    @GetMapping("/joinMembership")
    public String showJoinMembership(){
        return "public/accountManagement/joinMembership";
    }

    @PostMapping("/joinMembership/create")
    public String createJoinMembership(JoinMembershipForm joinMembershipForm,
                                       RedirectAttributes redirectAttributes){
        if(joinMembershipForm.getGaP_Image() == null)
        {
            User user = new User();
            user.setGaP_Image("/img/profile.png");
        }

        boolean success = joinMembershipService.joinPutData(joinMembershipForm);
        boolean checkId = joinMembershipService.checkId(joinMembershipForm.getGaId());
        boolean checkNick = joinMembershipService.checkNick(joinMembershipForm.getGaNick());
        boolean checkPhone = joinMembershipService.checkPhone(joinMembershipForm.getGaPhone());
        if(success){
            redirectAttributes.addFlashAttribute("msg", "회원가입에 성공했습니다");
            return "redirect:/login";

        } else {
             if(checkId){
                redirectAttributes.addFlashAttribute("msg", "중복된 아이디가 있습니다.");
                return "redirect:/joinMembership";
            } else if(checkNick){
                redirectAttributes.addFlashAttribute("msg", "중복된 닉네임이 있습니다.");
                return "redirect:/joinMembership";
            } else if (checkPhone) {
                redirectAttributes.addFlashAttribute("msg", "중복된 핸드폰 번호가 있습니다.");
                return "redirect:/joinMembership";
            } else{
                redirectAttributes.addFlashAttribute("msg", "회원가입에 실패했습니다");
                return "redirect:/joinMembership";
            }
        }
    }

}