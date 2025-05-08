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
        this.events = EventFileHandler.loadEvents(); // Load from events.data on startup
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

    public void listPastEvents() {
        LocalDateTime now = LocalDateTime.now();
        List<Event> past = events.stream()
                .filter(e -> e.getDateTime().isBefore(now.minusHours(1)))
                .sorted(Comparator.comparing(Event::getDateTime))
                .collect(Collectors.toList());

        if (past.isEmpty()) {
            System.out.println("No past events.");
        } else {
            System.out.println("\n--- Past Events ---");
            past.forEach(System.out::println);
        }
    }

    public void listOngoingEvents() {
        LocalDateTime now = LocalDateTime.now();
        List<Event> ongoing = events.stream()
                .filter(e -> !e.getDateTime().isBefore(now.minusHours(1)) &&
                             !e.getDateTime().isAfter(now.plusHours(1)))
                .sorted(Comparator.comparing(Event::getDateTime))
                .collect(Collectors.toList());

        if (ongoing.isEmpty()) {
            System.out.println("No events happening now.");
        } else {
            System.out.println("\n--- Ongoing Events ---");
            ongoing.forEach(System.out::println);
        }
    }

    public void listUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        List<Event> upcoming = events.stream()
                .filter(e -> e.getDateTime().isAfter(now.plusHours(1)))
                .sorted(Comparator.comparing(Event::getDateTime))
                .collect(Collectors.toList());

        if (upcoming.isEmpty()) {
            System.out.println("No upcoming events.");
        } else {
            System.out.println("\n--- Upcoming Events ---");
            upcoming.forEach(System.out::println);
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}
