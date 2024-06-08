package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
public interface GpRepository extends JpaRepository<GP, Long> {
    @Override
    @Query(value = "SELECT * FROM GP ORDER BY GPid ASC", nativeQuery = true)
    List<GP> findAll();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=1", nativeQuery = true)
    List<GP> findByGangwon();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=2", nativeQuery = true)
    List<GP> findByGyeonggi();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=3", nativeQuery = true)
    List<GP> findByGyeongnam();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=4", nativeQuery = true)
    List<GP> findByGyeongbuk();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=5", nativeQuery = true)
    List<GP> findByGwangju();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=6", nativeQuery = true)
    List<GP> findByDaegu();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=7", nativeQuery = true)
    List<GP> findByDaejeon();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=8", nativeQuery = true)
    List<GP> findByBusan();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=9", nativeQuery = true)
    List<GP> findBySeoul();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=10", nativeQuery = true)
    List<GP> findBySejong();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=11", nativeQuery = true)
    List<GP> findByUlsan();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=12", nativeQuery = true)
    List<GP> findByIncheon();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=13", nativeQuery = true)
    List<GP> findByJeonnam();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=14", nativeQuery = true)
    List<GP> findByJeonbuk();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=15", nativeQuery = true)
    List<GP> findByJeju();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=16", nativeQuery = true)
    List<GP> findByChungnam();

    @Query(value ="SELECT P.GPid AS GPID, P.name AS NAME, P.img AS IMG, P.state AS STATE, P.text AS TEXT, P.jjimcount AS JJIMCOUNT, P.posting AS POSTING, R.GRid AS GRID, T.GTid AS GTID " +
            "FROM GP P " +
            "LEFT JOIN GR R ON R.GRid = P.GRid " +
            "LEFT JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=17", nativeQuery = true)
    List<GP> findByChungbuk();
}
