package model;

import java.time.LocalDateTime;

public class Event {
    private String name;
    private String address;
    private EventCategory category;
    private LocalDateTime dateTime;
    private String description;

    public Event(String name, String address, EventCategory category, LocalDateTime dateTime, String description) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public EventCategory getCategory() {
        return category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\nEvent: " + name +
               "\nAddress: " + address +
               "\nCategory: " + category +
               "\nDate & Time: " + dateTime +
               "\nDescription: " + description;
    }
}
