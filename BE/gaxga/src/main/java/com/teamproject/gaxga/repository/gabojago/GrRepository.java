package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrRepository extends JpaRepository<GR, Long> {
    @Query("SELECT name FROM GR")
    List<String> findAllNames();

}
