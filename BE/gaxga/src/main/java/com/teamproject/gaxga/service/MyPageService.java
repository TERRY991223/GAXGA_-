package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.gabowatdago.Cmt;
import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.entity.gabojago.Jjim;
import com.teamproject.gaxga.repository.gabowatdago.CmtRepository;
import com.teamproject.gaxga.repository.gabowatdago.GabowatdagoRepository;
import com.teamproject.gaxga.repository.gabowatdago.LikeRepository;
import com.teamproject.gaxga.repository.UserRepository;
import com.teamproject.gaxga.repository.gabojago.JjimRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MyPageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JjimRepository jjimRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;

    @Autowired
    private CmtRepository cmtRepository;

    @Value("D:\\upload")
    private String fileDir;


    public String showMyPage(@PathVariable Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        model.addAttribute("userDetail", userDetail);
        String userName = userDetail.getUser().getGaId();
        User userInfo = userRepository.findByGaId(userName);
        String userImage = userInfo.getGaP_Image();
        log.info("==============================userImage = " + userImage);
        model.addAttribute("userImage", userImage);
        model.addAttribute("userInfo", userInfo);
        log.info("==============================userInfo = " + userInfo);
        //가보자고
        User user = userDetail.getUser();
        Long userId = user.getUserCode();

        Long countOfJjim = jjimRepository.countByUserId(userId);
        List<Jjim> myList = jjimRepository.findByJjim();
        model.addAttribute("jjimCount", countOfJjim);
        //로그인을 한 사람의 userCode
        model.addAttribute("userCode", userId);
        model.addAttribute("myList", myList);

        //가봤다고 리스트
        List<Gabowatdago> myBoardList = gabowatdagoRepository.findByUserCode_UserCode(userId);
        model.addAttribute("myBoardList", myBoardList);

        List<Gabowatdago> bestBoardList = gabowatdagoRepository.findByUserCode_UserCodeOrderByLikeCountDesc(userId);
        model.addAttribute("bestBoardList", bestBoardList);
        Long likeCounts = gabowatdagoRepository.sumLikeCountByUserCode(userId);
        model.addAttribute("likeCounts", likeCounts);



        log.info("=====================================================userId = " + userId);
        log.info("=====================================================================myList" + myList);
        log.info("=====================================================================likeCounts" + likeCounts);

        return "private/accountManagement/myPage";
    }

    @Transactional
    public String fixMyInfo(JoinMembershipForm joinMembershipForm){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        User user = userDetail.getUser();
        String oldGaNick = user.getGaNick(); // 변경 전 닉네임 저장
        log.info("userInfo : " + user.getGaNick() + " " + user.getGaPhone() + " " + user.getGaEmail() + " " + user.getGaPass());
        log.info("joinInfo : " + joinMembershipForm.getGaNick() + " " + joinMembershipForm.getGaPhone() + " " + joinMembershipForm.getGaEmail() + " " + joinMembershipForm.getGaPass());
        if(!joinMembershipForm.getGaNick().equals(user.getGaNick())){
            if (joinMembershipForm.getGaNick().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaNick());
            } else {
                log.info("GaNick is after " + user.getGaNick());
                user.setGaNick(joinMembershipForm.getGaNick());
                log.info("GaNick is before " + user.getGaNick());
                // 가봤다고 게시글의 닉네임 업데이트시키기
                List<Gabowatdago> gabowatdagoEntity = gabowatdagoRepository.findByGaNick(oldGaNick);
                System.out.println("==========================gabowatdagoEntity" + gabowatdagoEntity);
                for (Gabowatdago gabowatdago : gabowatdagoEntity) {
                    gabowatdago.setGaNick(joinMembershipForm.getGaNick());
                    gabowatdagoRepository.save(gabowatdago);
                }
                //댓글 닉네임 업데이트 시키기
                List<Cmt> cmtEntity = cmtRepository.findByNickname(oldGaNick);
                for (Cmt cmt : cmtEntity) {
                    cmt.setNickname(joinMembershipForm.getGaNick());
                    cmtRepository.save(cmt);
                }
            }
        }
        if (!joinMembershipForm.getGaPhone().equals(user.getGaPhone())){
            if(joinMembershipForm.getGaPhone().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaPhone());
            } else {
                log.info("GaPhone is after " + user.getGaPhone());
                user.setGaPhone(joinMembershipForm.getGaPhone());
                log.info("GaPhone is before " + user.getGaPhone());
            }
        }
        if (!joinMembershipForm.getGaPass().equals(user.getGaPass())){
            if(joinMembershipForm.getGaPass().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaPass());
            } else {
                log.info("GaPass is after " + user.getGaPass());
                String changePass = joinMembershipForm.getGaPass();
                String encodedPass = bCryptPasswordEncoder.encode(changePass);
                user.setGaPass(encodedPass);
                log.info("GaPass is before " + encodedPass);
            }
        }
        if (!joinMembershipForm.getGaEmail().equals(user.getGaEmail())){
            if(joinMembershipForm.getGaEmail().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaEmail());
            } else {
                log.info("GaEmail is after " + user.getGaEmail());
                user.setGaEmail(joinMembershipForm.getGaEmail());
                log.info("GaEmail is before " + user.getGaEmail());
            }
        }
        if (!joinMembershipForm.getGaP_Image().equals(user.getGaP_Image())){
            if(joinMembershipForm.getGaP_Image().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaP_Image());
            } else {
                log.info("GaP_Image is after " + user.getGaP_Image());
                user.setGaP_Image(joinMembershipForm.getGaP_Image());
                log.info("GaP_Image is before " + user.getGaP_Image());
            }
        }
        userRepository.save(user);
        return "redirect:/myPage";
    }

    public void updateProfileImage(Long userCode, MultipartFile file) throws Exception {
        User user = userRepository.findById(userCode).orElseThrow(() -> new Exception("User not found"));
        if (file != null && !file.isEmpty()) {
            // 기존 파일 이름 가져오기
            String oldFileName = user.getGaP_Image();
            if (oldFileName != null && !oldFileName.isEmpty() && !oldFileName.equals("profile.png")) {
                deleteOldFile(oldFileName); // 기존 파일 삭제, "profile.png"는 제외
            }
            String fileName = saveFile(file);
            user.setGaP_Image(fileName);
        }
        // 파일이 비어있으면 기존 이미지 유지
        userRepository.save(user);
    }

    private void deleteOldFile(String fileName) throws IOException {
        Path directoryPath = Paths.get(fileDir); //
        Path filePath = directoryPath.resolve(fileName);
        Files.deleteIfExists(filePath); // 파일이 존재하면 삭제
    }

    private String saveFile(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("Failed to store empty file.");
        }
        Path directoryPath = Paths.get(fileDir); //
        boolean directoryExists = Files.exists(directoryPath) && Files.isDirectory(directoryPath);
        if (!directoryExists) {
            Files.createDirectories(directoryPath);
        }
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = directoryPath.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }
}


