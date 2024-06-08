package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.service.MyPageService;
import com.teamproject.gaxga.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class MyPageController {

    @Autowired
    UserDetailService userDetailService;
    @Autowired
    MyPageService myPageService;

    @GetMapping("/myPage")
    public String showMyPage(Model model){
        return myPageService.showMyPage(model);
    }

    @PostMapping("/myPage")
    public String fixMyInfo(JoinMembershipForm joinMembershipForm){
        return myPageService.fixMyInfo(joinMembershipForm);
        
    }

    @PostMapping("/updateProfileImage")
    public String updateProfileImage(@RequestParam("userCode") Long userCode, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            myPageService.updateProfileImage(userCode, file);
            return "redirect:/myPage";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating profile image: " + e.getMessage());
            return "redirect:/myPage?error=true";
        }
    }
}
