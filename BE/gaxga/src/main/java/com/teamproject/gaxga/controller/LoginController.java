package com.teamproject.gaxga.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(HttpServletRequest request) {
        String username = "";
        boolean isSaveIdChecked = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("saveUserId".equals(cookie.getName())) {
                    username = cookie.getValue();
                    isSaveIdChecked = true;
                    break;
                }
            }
        }
        request.setAttribute("saveUserId", username);
        request.setAttribute("isSaveIdChecked", isSaveIdChecked);
        return "public/accountManagement/login";
    }
}