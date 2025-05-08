package controller;

import model.Event;
import model.EventCategory;
import model.User;
import util.EventFileHandler;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EventController {
    private List<Event> events;

    public EventController() {
        this.events = EventFileHandler.loadEvents(); 
    }

    public void createEvent(String name, String address, EventCategory category, LocalDateTime dateTime, String description) {
        Event event = new Event(name, address, category, dateTime, description);
        events.add(event);
        EventFileHandler.saveEvents(events);
        System.out.println("Event created and saved.");
    }

    public void listAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events registered.");
            return;
        }
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public boolean confirmParticipation(User user, String eventName) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                if (event.addParticipant(user)) {
                    EventFileHandler.saveEvents(events);
                    System.out.println("Participation confirmed.");
                } else {
                    System.out.println("User is already participating.");
                }
                return true;
            }
        }
        System.out.println("Event not found.");
        return false;
    }

    public boolean cancelParticipation(User user, String eventName) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                if (event.removeParticipant(user)) {
                    EventFileHandler.saveEvents(events);
                    System.out.println("Participation cancelled.");
                } else {
                    System.out.println("User was not participating.");
                }
                return true;
            }
        }
        System.out.println("Event not found.");
        return false;
    }

    public void listUserParticipations(User user) {
        boolean found = false;
        for (Event event : events) {
            if (event.isUserParticipating(user)) {
                System.out.println(event);
                found = true;
            }
        }
        if (!found) {
            System.out.println("User is not participating in any events.");
        }
    }

    public void listEventsOrderedByDate() {
        if (events.isEmpty()) {
            System.out.println("No events registered.");
            return;
        }

        List<Event> sorted = events.stream()
                .sorted(Comparator.comparing(Event::getDateTime))
                .collect(Collectors.toList());

        for (Event event : sorted) {
            System.out.println(event);
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}
