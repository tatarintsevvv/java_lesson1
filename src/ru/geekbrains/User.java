package ru.geekbrains;

public class User {
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User isRegistered(String login, String password) {
        if(this.login.equalsIgnoreCase(login) && this.password.equals(password)) {
            return this;
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}
