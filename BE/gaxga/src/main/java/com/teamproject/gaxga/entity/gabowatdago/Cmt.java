package com.teamproject.gaxga.entity.gabowatdago;

import com.teamproject.gaxga.dto.gabowatdago.CmtDto;
import com.teamproject.gaxga.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cmt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cmt_id_seq")
    @SequenceGenerator(name="cmt_id_seq", sequenceName = "cmt_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @OnDelete(action = CASCADE)
    @ManyToOne
    @JoinColumn(name = "gabowatdago_id")
    private Gabowatdago gabowatdago;

    @Column
    private String nickname;
    @Column
    private String body;

    public LocalDateTime getRegDate() {
        return super.getRegDate();
    }

    public static Cmt createComment(CmtDto cmtDto, Gabowatdago gabowatdago) {
        //예외 발생
        if(cmtDto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 중복된 댓글입니다.");
        if(!Objects.equals(cmtDto.getGabowatdagoId(), gabowatdago.getId()))
            throw new IllegalArgumentException("댓글 생성 실패, 해당 게시글이 존재하지 않습니다.");
        // 엔티티 생성 및 반환
        return new Cmt(
                cmtDto.getId(),
                gabowatdago,
                cmtDto.getNickname(),
                cmtDto.getBody()
        );
    }

    public void patch(CmtDto cmtDto) {
        //예외 발생
        if(this.id != cmtDto.getId())
            throw new IllegalArgumentException("댓글 수정 실패, 해당 댓글을 찾을 수 없습니다.");
    //객체 갱신 (예외가 발생하지 않았으면 수정할 내용을 적용한다.
        if(cmtDto.getBody() != null)//수정할 본문 데이터가 있다면
            this.body = cmtDto.getBody();// 내용 반영
        if(cmtDto.getNickname() != null)
            this.nickname = cmtDto.getNickname();
    }
}
