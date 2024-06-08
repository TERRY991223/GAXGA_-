package com.teamproject.gaxga.controller.gabojago;

import com.teamproject.gaxga.dto.gabojago.JjimDto;
import com.teamproject.gaxga.service.gabojago.JjimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gabojagoing/jjim")
public class GabojagoingApiController {
    private final JjimService jjimService;

    @PostMapping
    public ResponseEntity<?> insertJjim(@RequestBody @Validated JjimDto JjimDto) throws Exception {
        jjimService.insert(JjimDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteJjim(@RequestBody @Validated JjimDto JjimDto) throws Exception {
        jjimService.delete(JjimDto);
        return ResponseEntity.ok().build();
    }
}
