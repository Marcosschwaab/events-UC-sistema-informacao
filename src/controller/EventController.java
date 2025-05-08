package controller;

import model.Event;
import model.EventCategory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventController {
    private List<Event> events;

    public EventController() {
        this.events = new ArrayList<>();
    }

    public void createEvent(String name, String address, EventCategory category, LocalDateTime dateTime, String description) {
        Event event = new Event(name, address, category, dateTime, description);
        events.add(event);
        System.out.println("Event created successfully.");
    }

    public void listAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events registered.");
        } else {
            System.out.println("All Registered Events:");
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public List<Event> getSortedEventsByDate() {
        List<Event> sorted = new ArrayList<>(events);
        sorted.sort(Comparator.comparing(Event::getDateTime));
        return sorted;
    }

    public List<Event> getEvents() {
        return events;
    }
}
