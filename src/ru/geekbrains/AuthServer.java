package ru.geekbrains;

import java.util.LinkedList;
import java.util.List;

public class AuthServer {
    final private List<User> users = new LinkedList<>();

    public AuthServer() {
        users.add(new User("Robot1", "robot1", "1234"));
        users.add(new User("Robot2", "robot2", "1235"));
        users.add(new User("Robot3", "robot3", "1236"));
    }

    public User isAuthorized(String login, String password) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if((user = (User)users.get(i).isRegistered(login, password)) != null) {
                return user;
            }
            return null;
        }
    }
}
