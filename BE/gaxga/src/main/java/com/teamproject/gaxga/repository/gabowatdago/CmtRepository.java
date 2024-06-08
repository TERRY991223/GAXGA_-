package com.teamproject.gaxga.repository.gabowatdago;

import com.teamproject.gaxga.entity.gabowatdago.Cmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CmtRepository extends JpaRepository<Cmt, Long> {
    // 특정 게시글의 댓글 조회
    @Query(value = "SELECT * FROM CMT WHERE gabowatdago_id = :gabowatdagoId ORDER BY id", nativeQuery = true)
    List<Cmt> findByGabowatdagoId(@Param("gabowatdagoId") Long gabowatdagoId);

    @Query(value = "SELECT * FROM CMT WHERE nickname = :nickname", nativeQuery = true)
    List<Cmt> findByNickname(@Param("nickname")String nickname);









}
