package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GtRepository extends JpaRepository<GT, Long> {
    @Query("SELECT name FROM GT")
    List<String> findAllNames();
}
