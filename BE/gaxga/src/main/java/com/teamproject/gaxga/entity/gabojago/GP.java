package com.teamproject.gaxga.entity.gabojago;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GP {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GP_id_seq")
    @SequenceGenerator(name="GP_id_seq", sequenceName = "GP_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "GPid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GRid")
    private GR region;

    @ManyToOne
    @JoinColumn(name="GTid")
    private GT thema;

    @Column(name="name")
    private String name;

    @Column(name="img")
    private String img;

    @Column
    private String state;

    @Column
    private String text;

    @Column(nullable = false)
    private Long jjimcount;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime posting;

    public void increaseJjimCount() {
        this.jjimcount++;
    }
    public void decreseJjimCount() {
        this.jjimcount--;
    }
}