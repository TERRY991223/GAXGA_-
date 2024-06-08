package com.teamproject.gaxga.repository.event;

import com.teamproject.gaxga.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(String status);
}
