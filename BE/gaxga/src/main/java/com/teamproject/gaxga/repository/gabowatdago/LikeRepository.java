package com.teamproject.gaxga.repository.gabowatdago;


import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import com.teamproject.gaxga.entity.gabowatdago.Like;
import com.teamproject.gaxga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByGabowatdagoAndUser(Gabowatdago gabowatdago, User user);

//    @Modifying//update쿼리를 주기 위해서는 Modifying 필요
//    @Query(value = "update Gabowatdago g set g.likeCount=g.likeCount+1", nativeQuery = true )
//    void likeCountAdd();
}
