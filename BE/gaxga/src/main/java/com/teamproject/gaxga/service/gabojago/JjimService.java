package com.teamproject.gaxga.service.gabojago;

import com.sun.jdi.request.DuplicateRequestException;
import com.teamproject.gaxga.dto.gabojago.JjimDto;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.entity.gabojago.Jjim;
import com.teamproject.gaxga.repository.UserRepository;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.JjimRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JjimService {
    private final JjimRepository jjimRepository;
    private final GpRepository gpRepository;
    private final UserRepository userRepository;

    @Transactional
    public void insert(JjimDto jjimDto) throws Exception {
        GP gp = gpRepository.findById(jjimDto.getGabojagoId())
                .orElseThrow(() -> new Exception("not found: " + jjimDto.getGabojagoId()));
        User user = userRepository.findById(jjimDto.getUserId())
                .orElseThrow(() -> new Exception("User not found: " + jjimDto.getUserId()));

        if(jjimRepository.findByGpidAndUser(gp, user).isPresent()){
            throw new DuplicateRequestException("already exist data my user id :" + user.getGaId()
                    + " ," + "gabojago id : " + gp.getId());
        }
        Jjim jjim = Jjim.builder()
                .gp(gp)
                .user(user)
                .build();
        gp.increaseJjimCount();
        gpRepository.save(gp);
        jjimRepository.save(jjim);
    }


    @Transactional
    public void delete(JjimDto jjimDto) throws Exception {
        User user = userRepository.findById(jjimDto.getUserId())
                .orElseThrow(() -> new Exception("Could not found User id: " + jjimDto.getUserId()));

        GP gp = gpRepository.findById(jjimDto.getGabojagoId())
                .orElseThrow(() -> new Exception("Could not found GP id: " + jjimDto.getGabojagoId()));

        Jjim jjim = jjimRepository.findByGpidAndUser(gp, user)
                .orElseThrow(() -> new Exception("Could not found jjim id"));
        gp.decreseJjimCount();
        gpRepository.save(gp);
        jjimRepository.delete(jjim);
    }
}