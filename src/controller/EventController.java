package controller;

import model.Event;
import model.EventCategory;
import model.User;

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
    public boolean confirmParticipation(User user, String eventName) {
    for (Event event : events) {
        if (event.getName().equalsIgnoreCase(eventName)) {
            if (event.addParticipant(user)) {
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
}
