package com.teamproject.gaxga.dto.gabowatdago;

import com.teamproject.gaxga.entity.gabowatdago.Cmt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CmtDto {
    private Long id;
    private Long gabowatdagoId;
    private String nickname;
    private String body;

    public static CmtDto createCommentDto(Cmt cmt) {
        return new CmtDto(
                cmt.getId(),
                cmt.getGabowatdago().getId(),
                cmt.getNickname(),
                cmt.getBody()
        );
    }
}
