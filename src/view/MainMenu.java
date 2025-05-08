package view;

import controller.EventController;
import controller.UserController;
import model.EventCategory;

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
            System.out.println("4. List Events");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> registerUser();
                case "2" -> userController.listUsers();
                case "3" -> createEvent();
                case "4" -> eventController.listAllEvents();
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

        System.out.println("Category options:");
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
}
