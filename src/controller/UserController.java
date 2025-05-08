package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String name, String email, String phone) {
        User user = new User(name, email, phone);
        users.add(user);
        System.out.println("User registered successfully.");
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            System.out.println("Registered Users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
