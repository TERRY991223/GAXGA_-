package com.teamproject.gaxga.entity.gabojago;

import com.teamproject.gaxga.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Entity(name = "jjim")
@Getter
@NoArgsConstructor
public class Jjim {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Jjim_id_seq")
    @SequenceGenerator(name="Jjim_id_seq", sequenceName = "Jjim_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="Jjim_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="Gpid")
    private GP gpid;

    @Builder
    public Jjim(GP gp, User user) {
        this.gpid = gp;
        this.user = user;
    }
/*
데이터베이스에서 0으로 초기화 시켜줌.
   public void getJjimCountWithDefault() {
       // Optional 클래스를 사용하여 jjimCount 변수가 null인 경우 기본값을 설정
       this.jjimCount = 0L;
   }
jjimCount가 null일 때만 0으로 초기화
*/

}