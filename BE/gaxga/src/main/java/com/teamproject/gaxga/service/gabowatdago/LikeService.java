package com.teamproject.gaxga.service.gabowatdago;

import com.sun.jdi.request.DuplicateRequestException;
import com.teamproject.gaxga.dto.gabowatdago.LikeDto;
import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import com.teamproject.gaxga.entity.gabowatdago.Like;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.gabowatdago.GabowatdagoRepository;
import com.teamproject.gaxga.repository.gabowatdago.LikeRepository;
import com.teamproject.gaxga.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final GabowatdagoRepository gabowatdagoRepository;
    private final UserRepository userRepository;

    //전달받은 userId와 gabowatdagoId를 통해 member와 board를 조회하고 저장 혹은 삭제를 진행
    //좋아요 추가 메서드
    @Transactional
    public void insert(LikeDto likeDto) throws Exception {
        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
                .orElseThrow(() -> new Exception("Gabowatdago not found: " + likeDto.getGabowatdagoId()));
        User user = userRepository.findById(likeDto.getUserId())
                .orElseThrow(() -> new Exception("User not found:" + likeDto.getUserId()));
        //이미 좋아요 있으면 에러 반환
        if(likeRepository.findByGabowatdagoAndUser(gabowatdago, user).isPresent()){
            throw new DuplicateRequestException("already exist data my user id : " + user.getGaId()
            + " ," + "gabowatdago id : " + gabowatdago.getId());
        }
        Like like = Like.builder()
                .gabowatdago(gabowatdago)
                .user(user)
                .build();

        gabowatdago.likeCountAdd();
        gabowatdagoRepository.save(gabowatdago);
        likeRepository.save(like);

    }

    @Transactional
    public void delete(LikeDto likeDto) throws Exception {
        User user = userRepository.findById(likeDto.getUserId())
                .orElseThrow(() -> new Exception("Could not found User id : " + likeDto.getUserId()));

        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
                .orElseThrow(() -> new Exception("Could not found Gabowtdago id : " + likeDto.getGabowatdagoId()));

        Like like = likeRepository.findByGabowatdagoAndUser(gabowatdago, user)
                        .orElseThrow(() -> new Exception("Could not found like id"));

        gabowatdago.likeCountDelete();
        gabowatdagoRepository.save(gabowatdago);
        likeRepository.delete(like);

    }
}
