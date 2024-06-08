package com.teamproject.gaxga.entity.gabowatdago;

import com.teamproject.gaxga.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Getter
@NoArgsConstructor
@Entity(name = "heart")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_id_seq")
    @SequenceGenerator(name="like_id_seq", sequenceName = "like_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OnDelete(action = CASCADE)
    @ManyToOne
    @JoinColumn(name = "gabowatdago_id")
    private Gabowatdago gabowatdago;


    @Builder
    public Like(User user, Gabowatdago gabowatdago) {
        this.user = user;
        this.gabowatdago = gabowatdago;
    }

}
