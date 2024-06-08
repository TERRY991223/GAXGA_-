package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.entity.gabojago.Jjim;
import com.teamproject.gaxga.service.gabojago.GabojagoingService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ToString
@Controller
public class GabojagoingController {
    @Autowired
    private GabojagoingService gabojagoingService;

    @GetMapping("/gabojagoing/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Jjim jjim = new Jjim();

        return gabojagoingService.show(id, model);
    }
}