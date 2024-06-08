package com.teamproject.gaxga.service.gabowatdago;

import com.teamproject.gaxga.dto.gabowatdago.CmtDto;
import com.teamproject.gaxga.entity.gabowatdago.Cmt;
import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import com.teamproject.gaxga.repository.gabowatdago.CmtRepository;
import com.teamproject.gaxga.repository.gabowatdago.GabowatdagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CmtService {
    @Autowired
    private CmtRepository cmtRepository;
    @Autowired
    private GabowatdagoRepository GabowatdagoRepository;

    public List<CmtDto> comments(Long gabowatdagoId) {
        //댓글 조회
        List<Cmt> cmts = cmtRepository.findByGabowatdagoId(gabowatdagoId);
        List<CmtDto> dtos = new ArrayList<CmtDto>();
        for(int i=0; i<cmts.size(); i++){
            Cmt cmt = cmts.get(i);
            CmtDto dto = CmtDto.createCommentDto(cmt);
            dtos.add(dto);
        }
        //결과 반환
        return dtos;
    }

    @Transactional
    public CmtDto create(Long gabowatdagoId, CmtDto cmtDto) {
        //게시글 조회 및 예외 발생
        Gabowatdago gabowatdago = GabowatdagoRepository.findById(gabowatdagoId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패"+ "대상 게시글이 없습니다."));
        // 댓글 엔티티 생성
        Cmt cmt = Cmt.createComment(cmtDto, gabowatdago);
        // 댓글 엔티티를 db에 저장
        Cmt created = cmtRepository.save(cmt);
        // DTO로 변환해 반환
        return CmtDto.createCommentDto(created);

    }
    @Transactional
    public CmtDto update(Long id, CmtDto cmtDto) {
        //댓글 조회 및 예외 발생
        Cmt target = cmtRepository.findById(id) // 수정할 댓글 가져오기
                .orElseThrow(()->new IllegalArgumentException("댓글 수정 실패, 해당 댓글이 없습니다."));
        // 댓글 수정
        target.patch(cmtDto);
        // db로 갱신
        Cmt updated = cmtRepository.save(target);
        // 댓글 엔티티를 dto로 변환해 반환
        return CmtDto.createCommentDto(updated);
    }

    public CmtDto delete(Long id) {
        //댓글 조회 및 예외 발생
        Cmt target = cmtRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("댓글 삭제 실패, 해당 댓글이 없습니다."));
        //댓글 삭제
        cmtRepository.delete(target);
        //삭제 댓글을 dto로 변환 및 반환
        return CmtDto.createCommentDto(target);
    }
}
