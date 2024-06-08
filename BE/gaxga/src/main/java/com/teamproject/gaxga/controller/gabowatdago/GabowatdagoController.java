package com.teamproject.gaxga.controller.gabowatdago;

import com.teamproject.gaxga.dto.gabowatdago.GabowatdagoForm;
import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import com.teamproject.gaxga.entity.UserDetail;

import com.teamproject.gaxga.repository.gabowatdago.GabowatdagoRepository;
import com.teamproject.gaxga.service.gabowatdago.GabowatdagoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Slf4j
@Controller
public class GabowatdagoController {

    @Autowired
    private GabowatdagoService gabowatdagoService;
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;

    @GetMapping("/gabowatdagoing_p")
    public String newForm(Model model){
     return gabowatdagoService.newForm(model);
    }
    @PostMapping("/gabowatdago/create")
    public String create(GabowatdagoForm form) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal(); //로그인한사람 정보 가져오기
        Long userCode = userDetail.getUser().getUserCode(); // 가져와서 userCode 추출

        return gabowatdagoService.create(form, userCode); // 게시글 작성 메서드로 보내기
    }

    @GetMapping("/gabowatdago/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        return gabowatdagoService.show(id, model);
    }

    @GetMapping("/gabowatdago")
    public String index(Model model){
        return gabowatdagoService.index(model);
    }

    @GetMapping("/gabowatdago/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal(); //로그인한사람 정보 가져오기
        Gabowatdago writerInfo = gabowatdagoRepository.findById(id).orElse(null);
        System.out.println("========================writerInfo" + writerInfo + "=================userGaId"+ userDetail.getUser().getGaId());
        if (userDetail.getUser().getGaId().equals(writerInfo.getGaId())){   //getmapping 으로인해 외부 사용자가 다른 사용자의 게시글 수정페이지로 접속할 수 없도록 조건 걸기
            return gabowatdagoService.edit(id, model);
        }else {
            return "redirect:/gabowatdago";
        }

    }

    @PostMapping("/gabowatdago/update")
    public String update(GabowatdagoForm form) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal(); //로그인한사람 정보 가져오기
        Long userCode = userDetail.getUser().getUserCode(); // 가져와서 userCode 추출
        return gabowatdagoService.update(form, userCode);
    }

    @GetMapping("gabowatdago/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal(); //로그인한사람 정보 가져오기
        Gabowatdago writerInfo = gabowatdagoRepository.findById(id).orElse(null);
        if (userDetail.getUser().getGaId().equals(writerInfo.getGaId())){   //getmapping 으로인해 외부 사용자가 다른 사용자의 게시글 삭제할 수 없도록 조건 걸기
            return gabowatdagoService.delete(id);
        }else {
            return "redirect:/gabowatdago";
        }

    }
}
