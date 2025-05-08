package util;

import model.Event;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventFileHandler {
    private static final String FILE_NAME = "events.data";

    public static void saveEvents(List<Event> events) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(events);
        } catch (IOException e) {
            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Event> loadEvents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Event>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading events: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
