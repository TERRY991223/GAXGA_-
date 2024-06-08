package com.teamproject.gaxga.service.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
@Service
public class GabojagoService {

    @Autowired
    private GpRepository gpRepository;

    @Autowired
    private GtRepository gtRepository;

    @Autowired
    private GrRepository grRepository;

    public String gaboShow(Model model){
        List<String> location = grRepository.findAllNames();
        model.addAttribute("locations", location);

        List<String> thema = gtRepository.findAllNames();
        model.addAttribute("themas", thema);

        List<GP> GPList = gpRepository.findAll();
        model.addAttribute("GPList", GPList);

        List<GP> Gangwon = gpRepository.findByGangwon();
        model.addAttribute("Gangwon", Gangwon);

        List<GP> Gyeonggi = gpRepository.findByGyeonggi();
        model.addAttribute("Gyeonggi", Gyeonggi);

        List<GP> Gyeongnam = gpRepository.findByGyeongnam();
        model.addAttribute("Gyeongnam", Gyeongnam);

        List<GP> Gyeongbuk = gpRepository.findByGyeongbuk();
        model.addAttribute("Gyeongbuk", Gyeongbuk);

        List<GP> Gwangju = gpRepository.findByGwangju();
        model.addAttribute("Gwangju", Gwangju);

        List<GP> Daejeon = gpRepository.findByDaejeon();
        model.addAttribute("Daejeon", Daejeon);

        List<GP> Daegu = gpRepository.findByDaegu();
        model.addAttribute("Daegu", Daegu);

        List<GP> Busan = gpRepository.findByBusan();
        model.addAttribute("Busan", Busan);

        List<GP> Seoul = gpRepository.findBySeoul();
        model.addAttribute("Seoul", Seoul);

        List<GP> Sejong = gpRepository.findBySejong();
        model.addAttribute("Sejong", Sejong);

        List<GP> Ulsan  = gpRepository.findByUlsan();
        model.addAttribute("Ulsan", Ulsan);

        List<GP> Incheon = gpRepository.findByIncheon();
        model.addAttribute("Incheon", Incheon);

        List<GP> Jeonnam = gpRepository.findByJeonnam();
        model.addAttribute("Jeonnam", Jeonnam);

        List<GP> Jeonbuk = gpRepository.findByJeonbuk();
        model.addAttribute("Jeonbuk", Jeonbuk);

        List<GP> Jeju = gpRepository.findByJeju();
        model.addAttribute("Jeju", Jeju);

        List<GP> Chungnam = gpRepository.findByChungnam();
        model.addAttribute("Chungnam", Chungnam);

        List<GP> Chungbuk = gpRepository.findByChungbuk();
        model.addAttribute("Chungbuk", Chungbuk);

        return "public/gabojago/gabojago";
    }
}