package com.teamproject.gaxga.dto.gabowatdago;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
public class LikeDto {
    private Long userId;
    private Long gabowatdagoId;


    public LikeDto(Long userId, Long gabowatdagoId) {
        this.userId = userId;
        this.gabowatdagoId = gabowatdagoId;
    }
}

