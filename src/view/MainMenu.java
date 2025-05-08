package view;

import controller.EventController;
import model.EventCategory;
import model.User;
import util.UserFileHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EventController eventController = new EventController();
    private static List<User> users = UserFileHandler.loadUsers();
    private static User loggedUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Welcome to City Events System ===");
            if (loggedUser == null) {
                System.out.println("1. Register User");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> registerUser();
                    case 2 -> loginUser();
                    case 0 -> exit();
                    default -> System.out.println("Invalid option.");
                }
            } else {
                System.out.printf("\n[Logged in as %s]\n", loggedUser.getName());
                System.out.println("1. Create Event");
                System.out.println("2. List All Events");
                System.out.println("3. Confirm Participation");
                System.out.println("4. Cancel Participation");
                System.out.println("5. List My Events");
                System.out.println("6. List Events by Date");
                System.out.println("7. List Past Events");
                System.out.println("8. List Ongoing Events");
                System.out.println("9. List Upcoming Events");
                System.out.println("10. Logout");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> createEvent();
                    case 2 -> eventController.listAllEvents();
                    case 3 -> confirmParticipation();
                    case 4 -> cancelParticipation();
                    case 5 -> eventController.listUserParticipations(loggedUser);
                    case 6 -> eventController.listEventsOrderedByDate();
                    case 7 -> eventController.listPastEvents();
                    case 8 -> eventController.listOngoingEvents();
                    case 9 -> eventController.listUpcomingEvents();
                    case 10 -> logout();
                    case 0 -> exit();
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        loggedUser = new User(name, email, city);
        users.add(loggedUser);
        UserFileHandler.saveUsers(users); // Save users to file
        System.out.println("User registered and logged in!");
    }

    private static void loginUser() {
        if (loggedUser == null) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your email: ");
            String email = scanner.nextLine();

            System.out.print("Enter your city: ");
            String city = scanner.nextLine();

            loggedUser = new User(name, email, city);
            users.add(loggedUser);
            UserFileHandler.saveUsers(users); // Save users to file
            System.out.println("Login successful!");
        } else {
            System.out.println("Already logged in.");
        }
    }

    private static void logout() {
        loggedUser = null;
        System.out.println("You have logged out.");
    }

    private static void exit() {
        System.out.println("Exiting... Goodbye!");
        System.exit(0);
    }

    private static void createEvent() {
        System.out.print("Event name: ");
        String name = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.println("Choose category:");
        for (EventCategory category : EventCategory.values()) {
            System.out.println("- " + category);
        }

        EventCategory category;
        try {
            System.out.print("Category: ");
            category = EventCategory.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category. Event creation canceled.");
            return;
        }

        System.out.print("Date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Invalid date/time format. Event creation canceled.");
            return;
        }

        System.out.print("Description: ");
        String description = scanner.nextLine();

        eventController.createEvent(name, address, category, dateTime, description);
    }

    private static void confirmParticipation() {
        System.out.print("Enter the event name to confirm participation: ");
        String eventName = scanner.nextLine();
        eventController.confirmParticipation(loggedUser, eventName);
    }

    private static void cancelParticipation() {
        System.out.print("Enter the event name to cancel participation: ");
        String eventName = scanner.nextLine();
        eventController.cancelParticipation(loggedUser, eventName);
    }
}
