package net.golovach.dao.bean;

public class User {
    private final int id;
    private String login;
    private String email;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User[id=" + id + ", login='" + login + "', email='" + email + "']";
    }
}
