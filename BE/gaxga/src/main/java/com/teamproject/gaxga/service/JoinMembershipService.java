package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JoinMembershipService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    public boolean joinPutData(JoinMembershipForm joinMembershipForm) {

        boolean isUserId = userRepository.existsByGaId(joinMembershipForm.getGaId());
        boolean isUserNick = userRepository.existsByGaNick(joinMembershipForm.getGaNick());
        boolean isUserPhone = userRepository.existsByGaPhone(joinMembershipForm.getGaPhone());
        if (isUserId || isUserNick || isUserPhone) {
            return false;
        }
        User data = new User();

        data.setGaId(joinMembershipForm.getGaId());
        data.setGaPass(bCryptPasswordEncoder.encode(joinMembershipForm.getGaPass()));
        data.setGaNick(joinMembershipForm.getGaNick());
        data.setGaPhone(joinMembershipForm.getGaPhone());
        data.setGaAddress(joinMembershipForm.getGaAddress());
        data.setGaDetailAddress(joinMembershipForm.getGaDetailAddress());
        data.setGaEmail(joinMembershipForm.getGaEmail());
        data.setGaP_Image(joinMembershipForm.getGaP_Image());
        userRepository.save(data);
        return true;
    }

    public boolean checkId(String userId) {
        return userRepository.existsByGaId(userId);
    }
    public boolean checkNick(String userNick) {
        return userRepository.existsByGaNick(userNick);
    }
    public boolean checkPhone(String userPhone) {
        return userRepository.existsByGaPhone(userPhone);
    }
}