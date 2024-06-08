package com.teamproject.gaxga.controller.gabowatdago;

import com.teamproject.gaxga.dto.gabowatdago.GabowatdagoForm;
import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import com.teamproject.gaxga.repository.gabowatdago.GabowatdagoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class GabowatdagoApiController {
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;


    //GET
    @GetMapping("/api/gabowatdago")
    public List<Gabowatdago> index() {
        return gabowatdagoRepository.findAll();
    }

    @GetMapping("/api/gabowatdago/{id}")
    public Gabowatdago show(@PathVariable("id") Long id) {
        return gabowatdagoRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping("/api/gabowatdago")
    public Gabowatdago create(@RequestBody GabowatdagoForm dto){ //요청 시 본문(body)에 실어 보내는 데이터를 create() 메서드의 매개변수로 받아올 수 있다.
        Gabowatdago gabowatdago = dto.toEntity(); //엔티티로 변환
        return gabowatdagoRepository.save(gabowatdago);
    }

    //PATCH
    @PatchMapping("/api/gabowatdago/{id}")
    public ResponseEntity<Gabowatdago> update(@PathVariable("id") Long id, @RequestBody() GabowatdagoForm dto){
        //1. dto -> 엔티티 변환하기
        Gabowatdago gabowatdago = dto.toEntity();
        log.info("id:{}, article: {}", id, gabowatdago.toString());
        //2. 타깃 조회하기 (저장되어있는 데이터중에 수정할 데이터 가져오기)
        Gabowatdago target = gabowatdagoRepository.findById(id).orElse(null);
        //3. 잘못된 요청 처리하기 ResponseEntity에 담아서 반환(상태코드를 받환해야 하기 때문에)
        if (target == null || id != gabowatdago.getId()) { // 잘못된 요청인지 판별
            //400, 잘못된 요청 응답
            log.info("잘못된 요청! id:{}, gabowatdago:{}", id, gabowatdago.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //4. 업데이트 및 정상 응답(200) 하기
        target.patch(gabowatdago);  //기존 데이터에 새 데이터 붙이기
        Gabowatdago updated = gabowatdagoRepository.save(target);//  수정 내용gabowatdago 엔티티 db에 저장
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }


    //DELETE
    @DeleteMapping("/api/gabowatdago/{id}")
    public ResponseEntity<Gabowatdago> delete(@PathVariable("id") Long id) {
        //1. 대상 찾기
        Gabowatdago target = gabowatdagoRepository.findById(id).orElse(null);
        //2. 잘못된 요청 처리하기
        if (target == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        //3. 대상 삭제하기
        gabowatdagoRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
