package com.teamproject.gaxga.controller.main;

import com.teamproject.gaxga.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @Autowired
    UserDetailService userDetailService;

    @GetMapping("/main")
    public String showMain() {
        return "public/main/main2";
    }

    @GetMapping("/")
    public String showMainPage() {
        return "public/main/main2";
    }
}
