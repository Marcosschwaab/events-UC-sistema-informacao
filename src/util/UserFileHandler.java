package util;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileHandler {

    private static final String USER_FILE_PATH = "users.data";

    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            oos.writeObject(users);
            System.out.println("Users saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> loadUsers() {
        File file = new File(USER_FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                if (list.isEmpty() || list.get(0) instanceof User) {
                    return (List<User>) list;
                } else {
                    System.out.println("Data type mismatch: elements are not of type User.");
                }
            } else {
                System.out.println("Data type mismatch: object is not a List.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        return new ArrayList<>();
    }
}
