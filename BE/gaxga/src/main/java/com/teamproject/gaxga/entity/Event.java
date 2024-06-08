package com.teamproject.gaxga.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name="event_id_seq", sequenceName = "event_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column
    private String name; // 이벤트의 이름

    @Column
    private String img; // 이벤트에 보여질 이미지

    //leg_Date 필드가 start_date 와 중복되어 제거함
    @Column(name = "start_date")
    private LocalDateTime startDate; // 이벤트가 시작될 날짜

    @Column(updatable = false,name = "end_date")
    private LocalDateTime endDate; // 이벤트가 종료될 날짜

    @Column
    private String status; // 이벤트 상태 (진행 중인지 종료되었는지)

}
