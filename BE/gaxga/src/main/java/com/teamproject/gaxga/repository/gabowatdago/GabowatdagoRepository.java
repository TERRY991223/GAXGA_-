package com.teamproject.gaxga.repository.gabowatdago;

import com.teamproject.gaxga.entity.gabowatdago.Gabowatdago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface GabowatdagoRepository extends JpaRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();

    List<Gabowatdago> findByUserCode_UserCode(Long gabowatdagoWriter);

    List<Gabowatdago> findByUserCode_UserCodeOrderByLikeCountDesc(Long gabowatdagoWriter);

    //마이페이지 나의 베스트 게시글
    @Query(value = "SELECT COALESCE(SUM(g.like_Count), 0) FROM gabowatdago g WHERE g.user_Code = :userCode", nativeQuery = true)
    Long sumLikeCountByUserCode(@Param("userCode") Long userCode);

    //특정 기간기준 이벤트 당첨자 - likeCount 당첨자 : 중복 제거를위해 같은 userCode를 그룹화했으며,  당첨자 중에 like카운트가 동일한 유저가 있을 경우 먼저 게시글을 등록한 사람이 당첨되도록 선정한다.
    @Query(value = "SELECT * FROM " +
            "(SELECT sub.*, ROWNUM rnum FROM " +
            "(SELECT g.*, ROW_NUMBER() OVER (PARTITION BY g.user_code ORDER BY g.like_count DESC, g.reg_date ASC) as rn FROM " +
            "gabowatdago g WHERE g.reg_date BETWEEN TO_TIMESTAMP('2024-05-01 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3') " +
            "ORDER BY g.like_count DESC, g.reg_date ASC) sub WHERE sub.rn = 1) WHERE rnum <= 3", nativeQuery = true)
    List<Gabowatdago> findTop3ByLikeCountAndDateRangeWithoutDuplicateWinners();

    //특정 기간 기준 이벤트 당첨자 - 게시글 수 당첨자 : 가장 많은 게시글을 작성한 사람 기준, 게시글 수가 동일하면 먼저 게시글을 작성한 사람이 당첨된다.
    @Query(value = "SELECT * FROM " +
            "(SELECT g.ga_nick, COUNT(*) AS postCount, MIN(g.reg_date) AS earliestRegDate FROM " +
            "Gabowatdago g WHERE g.reg_date BETWEEN TO_TIMESTAMP('2024-05-01 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3') " +
            "GROUP BY g.ga_nick ORDER BY postCount DESC, earliestRegDate ASC) WHERE ROWNUM <= 3", nativeQuery = true)
    List<Object[]> findTop3UsersByPostCountIncludingNick();


    List<Gabowatdago> findByGaNick(String gaNick);
/*

*****COALESCE는 "코얼레스크"라고 읽음.
COALESCE 함수는 SQL에서 사용되며, 주어진 표현식들 중에서 첫 번째로 NULL이 아닌 값을 반환.
예를 들어, COALESCE(column1, column2, 0)는 column1이 NULL이 아니면 column1의 값을 반환,
NULL이면 column2의 값을 반환하며, 둘 다 NULL이면 0을 반환

*/

/*
*****like 이벤트 당첨자 쿼리문 해석
 1. 내부 서브쿼리(가장 안쪽 쿼리)
SELECT g.*, ROW_NUMBER() OVER (PARTITION BY g.user_code ORDER BY g.like_count DESC, g.reg_date ASC) as rn
FROM gabowatdago g
WHERE g.reg_date BETWEEN TO_TIMESTAMP('2024-05-22 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3')
AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3')
    - gabowatdago 테이블에서 지정된 날짜 범위 내의 모든 게시물을 선택
    - ROW_NUMBER(): 각 user_code별로 like_count가 높은 순서대로 순위를 매긴다. like_count가 같을 경우, reg_date가 빠른 게시물이 우선 순위를 갖는다
    - 결과: 각 게시물에는 사용자 코드별로 순위(rn)가 매겨진다.

 2. 중간 서브쿼리
SELECT sub.*, ROWNUM rnum
FROM (...) sub
WHERE sub.rn = 1
    - 목적: 가장 안쪽 쿼리의 결과에서 각 사용자별로 like_count가 가장 높은 게시물(즉, rn = 1인 게시물)만을 선택
    - ROWNUM: 오라클에서 결과의 순서에 따라 각 행에 고유 번호를 부여

 3. 외부 커리
SELECT *
FROM (...)
WHERE rnum <= 3
    - 목적: 중간 서브쿼리의 결과에서 ROWNUM이 3 이하인 행만을 선택하여, 전체적으로 like_count가 가장 높은 상위 3개의 게시물을 최종적으로 반환
    - 결과: 최종 사용자에게 보여질 데이터는 각 사용자별로 like_count가 가장 높은 게시물 중에서 전체적으로 상위 3개의 게시물이다.


 */

    /*
*****like 이벤트 당첨자 쿼리문 해석
    1. 내부 쿼리 :
    SELECT g.ga_nick, COUNT(*) AS postCount, MIN(g.reg_date) AS earliestRegDate FROM Gabowatdago g
        - g.ga_nick : 사용자의 닉네임 선택,
        - COUNT(*) AS postCount: 각 사용자가 작성한 게시글의 수를 계산
        - MIN(g.reg_date) AS earliestRegDate: 각 사용자가 작성한 게시글 중 가장 이른 날짜를 찾는다.
    GROUP BY g.ga_nick
        - 결과를 사용자 닉네임(ga_nick)별로 그룹화한다.
    ORDER BY postCount DESC, earliestRegDate ASC
        - 게시글 수(postCount)를 기준으로 내림차순으로 정렬하고, 게시글 수가 같은 경우 가장 이른 게시글의 날짜
            (earliestReaDate)를 기준으로 오름차순으로 정렬

    2. 외부 커리 :
    WHERE ROWNUM <= 3
        - 내부 쿼리의 결과 중 상위 3개의 결과만 선택한다.

   => 가장 게시글을 많이 작성한 3명의 사용자를 선정, 게시글 수가 같은 경우 더 일찍 게시글을 작성한
        사용자를 우선하여 선발한다.
     */
}
