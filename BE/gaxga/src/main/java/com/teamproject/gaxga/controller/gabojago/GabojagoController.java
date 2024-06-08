package com.teamproject.gaxga.controller.gabojago;


import com.teamproject.gaxga.service.gabojago.GabojagoService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@ToString
@Slf4j
@Controller
public class GabojagoController {

    @Autowired
    private GabojagoService gabojagoService;

    @GetMapping("/gabojago")
    public String loc(Model model){
        return gabojagoService.gaboShow(model);
    }
    
}
