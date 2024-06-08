package com.teamproject.gaxga.controller;


import com.teamproject.gaxga.entity.Event;
import com.teamproject.gaxga.repository.event.EventRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/event")
public class EventApiController {

    private final EventRepository eventRepository;

    public EventApiController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/ongoing")
    public List<Event> getOngoingEvents() {
        return eventRepository.findByStatus("ONGOING");
    }

    @GetMapping("/ended")
    public List<Event> getEndedEvents() {
        return eventRepository.findByStatus("ENDED");
    }
}