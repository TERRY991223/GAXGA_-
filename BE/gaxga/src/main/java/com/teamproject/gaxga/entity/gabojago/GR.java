package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GR {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GR_id_seq")
    @SequenceGenerator(name="GR_id_seq", sequenceName = "GR_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="GRid")
    private Long id;

    @Column(name="name")
    private String name;
}