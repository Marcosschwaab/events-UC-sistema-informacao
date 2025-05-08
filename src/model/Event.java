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

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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

    public String getStatus() {
        LocalDateTime now = LocalDateTime.now();
        if (dateTime.isBefore(now.minusHours(1))) {
            return "Already occurred";
        } else if (dateTime.isBefore(now.plusHours(1)) && dateTime.isAfter(now.minusHours(1))) {
            return "Happening now";
        } else {
            return "Upcoming";
        }
    }

    @Override
    public String toString() {
        return String.format("\n[Event] %s\n- Address: %s\n- Category: %s\n- DateTime: %s\n- Description: %s\n- Status: %s\n",
                name, address, category, dateTime, description, getStatus());
    }
}
