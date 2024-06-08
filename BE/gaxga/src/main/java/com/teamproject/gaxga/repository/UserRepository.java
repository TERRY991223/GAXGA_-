package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByGaId(String gaId);
    boolean existsByGaId(String gaId);
    User findByGaNickAndGaPhone(String gaNick, String gaPhone);
    User findByGaIdAndGaPhone(String gaId, String gaPhone);
    boolean existsByGaNick(String gaNick);
    boolean existsByGaPhone(String gaPhone);
}
