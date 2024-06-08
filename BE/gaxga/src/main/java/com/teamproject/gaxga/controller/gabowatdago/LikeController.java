package com.teamproject.gaxga.controller.gabowatdago;

import com.teamproject.gaxga.dto.gabowatdago.LikeDto;
import com.teamproject.gaxga.service.gabowatdago.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gabowatdago/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<?> insertLike(@RequestBody @Validated LikeDto likeDto) throws Exception {
        likeService.insert(likeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteLike(@RequestBody @Validated LikeDto likeDto) throws Exception {
        likeService.delete(likeDto);
        return ResponseEntity.ok().build();
    }
}
