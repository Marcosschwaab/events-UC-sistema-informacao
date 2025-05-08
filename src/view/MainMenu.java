package view;

import controller.EventController;
import controller.UserController;
import model.EventCategory;
import model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private final UserController userController;
    private final EventController eventController;

    public MainMenu() {
        scanner = new Scanner(System.in);
        userController = new UserController();
        eventController = new EventController();
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Event Manager ===");
            System.out.println("1. Register User");
            System.out.println("2. List Users");
            System.out.println("3. Create Event");
            System.out.println("4. List All Events");
            System.out.println("5. Confirm Participation in Event");
            System.out.println("6. Cancel Participation");
            System.out.println("7. List User's Events");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> registerUser();
                case "2" -> userController.listUsers();
                case "3" -> createEvent();
                case "4" -> eventController.listAllEvents();
                case "5" -> confirmParticipation();
                case "6" -> cancelParticipation();
                case "7" -> listUserParticipations();
                case "0" -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        userController.registerUser(name, email, phone);
    }

    private void createEvent() {
        System.out.print("Event name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.println("Available categories:");
        for (EventCategory category : EventCategory.values()) {
            System.out.println("- " + category);
        }
        System.out.print("Select category: ");
        EventCategory category = EventCategory.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.print("Description: ");
        String description = scanner.nextLine();

        eventController.createEvent(name, address, category, dateTime, description);
    }

    private void confirmParticipation() {
        User user = chooseUser();
        if (user == null) return;

        System.out.print("Event name to join: ");
        String eventName = scanner.nextLine();

        eventController.confirmParticipation(user, eventName);
    }

    private void cancelParticipation() {
        User user = chooseUser();
        if (user == null) return;

        System.out.print("Event name to leave: ");
        String eventName = scanner.nextLine();

        eventController.cancelParticipation(user, eventName);
    }

    private void listUserParticipations() {
        User user = chooseUser();
        if (user == null) return;

        eventController.listUserParticipations(user);
    }

    private User chooseUser() {
        var users = userController.getUsers();
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return null;
        }

        System.out.println("Choose a user by index:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + " - " + users.get(i));
        }

        System.out.print("Enter user index: ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < users.size()) {
                return users.get(index);
            } else {
                System.out.println("Invalid index.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }

        return null;
    }
}
