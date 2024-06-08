package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Getter
@Setter
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", initialValue = 1, allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long userCode;

    @Column(unique = true, nullable = false)
    private String gaId;

    @Column(nullable = false)
    private String gaPass;

    @Column(nullable = false)
    private String gaNick;

    @Column(nullable = false)
    private String gaPhone;

    @Column(nullable = false)
    private String gaAddress;

    @Column(nullable = false)
    private String gaDetailAddress;

    @Column(nullable = false)
    private String gaEmail;

    @Column
    private String gaP_Image;
}
