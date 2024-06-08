package com.teamproject.gaxga.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
public class UserDetail implements UserDetails {

    private User user;
    public UserDetail(User user) {
        this.user = user;
    }
    public String getGaPImage(){
        return user.getGaP_Image();
    }

    public String getGaNick(){
        return user.getGaNick();
    }
    public String getGaPhone(){
        return user.getGaPhone();
    }
    public String getGaEmail(){
        return user.getGaEmail();
    }
    public String getGaPass(){
        String gaPass = user.getGaPass();
        return "*".repeat(gaPass.length());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getGaPass();
    }

    @Override
    public String getUsername() {
        return user.getGaId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
