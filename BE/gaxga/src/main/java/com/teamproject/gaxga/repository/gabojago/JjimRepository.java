package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.dto.gabojago.JjimDto;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.entity.gabojago.Jjim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public interface JjimRepository extends JpaRepository<Jjim, Long> {
    @Query(value = "SELECT COUNT(j.jjim_id) FROM Jjim j WHERE j.user_id = :userId", nativeQuery = true)
    Long countByUserId(@Param("userId") Long userId);

    Optional<Jjim> findByGpidAndUser(GP gp, User user);

    @Query(value = "SELECT J.GPid AS GPID, J.user_id AS USER_ID, J.jjim_id AS JJIM_ID, P.state AS STATE, P.img AS IMG " +
            "FROM Jjim J " +
            "LEFT JOIN GP P ON P.GPid = J.GPid ", nativeQuery = true)
    List<Jjim> findByJjim();

    List<Jjim> findAllByUserUserCode(Long userCode);

}