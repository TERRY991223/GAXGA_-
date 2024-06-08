package com.teamproject.gaxga.scheduler;

import com.teamproject.gaxga.repository.event.EventRepository;
import com.teamproject.gaxga.entity.Event;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EventScheduler {

    private final EventRepository eventRepository;

    public EventScheduler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Scheduled(fixedRate = 18000) // 30분 마다 실행
    public void checkAndEndEvents() {
        List<Event> events = eventRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for (Event event : events) {
            if (event.getEndDate().isBefore(now) && !"ENDED".equals(event.getStatus())) {
                endEvent(event);
            }
        }
    }
    private void endEvent(Event event) {
        // 이벤트 종료 처리 로직
        event.setStatus("ENDED");
        eventRepository.save(event);
    }
}


