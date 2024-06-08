package com.teamproject.gaxga.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;

@Slf4j
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        String errorMsg;

        if (e instanceof BadCredentialsException || e instanceof InternalAuthenticationServiceException){
            errorMsg="아이디 또는 비밀번호가 맞지 않습니다.";
        }else if (e instanceof UsernameNotFoundException){
            errorMsg="존재하지 않는 아이디 입니다.";
        }
        else{
            errorMsg="알 수 없는 이유로 로그인이 안되고 있습니다.";
        }

        String encodedErrorMsg = URLEncoder.encode(errorMsg,"UTF-8");

        setDefaultFailureUrl("/login/Result?error=true&exception=" + encodedErrorMsg);
        log.info("customMsg = " + encodedErrorMsg);
        super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
    }
}
