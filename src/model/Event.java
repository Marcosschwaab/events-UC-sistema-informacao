package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event implements Serializable {
    private String name;
    private String address;
    private EventCategory category;
    private LocalDateTime dateTime;
    private String description;
    private List<User> participants;

    public Event(String name, String address, EventCategory category, LocalDateTime dateTime, String description) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
        this.participants = new ArrayList<>();
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getName() {
        return name;
    }

    public boolean addParticipant(User user) {
        if (!participants.contains(user)) {
            participants.add(user);
            return true;
        }
        return false;
    }

    public boolean removeParticipant(User user) {
        return participants.remove(user);
    }

    public boolean isUserParticipating(User user) {
        return participants.contains(user);
    }

    public List<User> getParticipants() {
        return participants;
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
