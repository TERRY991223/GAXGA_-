package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GT {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GT_id_seq")
    @SequenceGenerator(name="GT_id_seq", sequenceName = "GT_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="GTid") // @JoinColumn 어노테이션 제거됨
    private Long id;

    @Column(name="name")
    private String name;
}