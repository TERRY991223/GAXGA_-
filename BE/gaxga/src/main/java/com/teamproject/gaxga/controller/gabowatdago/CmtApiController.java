package com.teamproject.gaxga.controller.gabowatdago;

import com.teamproject.gaxga.dto.gabowatdago.CmtDto;
import com.teamproject.gaxga.service.gabowatdago.CmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CmtApiController {
    @Autowired
    private CmtService cmtService;
    //1. 댓글 조회
    @GetMapping("/api/gabowatdago/{gabowatdagoId}/cmts")
    public ResponseEntity<List<CmtDto>> cmts(@PathVariable("gabowatdagoId") Long gabowatdagoId){
        List<CmtDto> dtos = cmtService.comments(gabowatdagoId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    //2. 댓글 생성
    @PostMapping("/api/gabowatdago/{gabowatdagoId}/cmts")
    public ResponseEntity<CmtDto> createCmt(@PathVariable("gabowatdagoId")Long gabowatdagoId,
                                            @RequestBody CmtDto cmtDto){
        CmtDto createdDto = cmtService.create(gabowatdagoId, cmtDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    //3. 댓글 수정
    @PatchMapping("/api/cmts/{id}")
    public ResponseEntity<CmtDto> updateCmt(@PathVariable("id") Long id, @RequestBody CmtDto cmtDto){
        CmtDto updatedDto = cmtService.update(id, cmtDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }


    //4. 댓글 삭제
    @DeleteMapping("/api/cmts/{id}")
    public ResponseEntity<CmtDto> deleteCmt(@PathVariable("id") Long id){
        CmtDto deletedDto = cmtService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }



}
