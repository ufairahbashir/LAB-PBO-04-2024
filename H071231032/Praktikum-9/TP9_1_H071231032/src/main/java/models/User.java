package models;

import dao.UserDAO;

public class User {
    protected String username;
    protected String password;

    public User(String username, String password) { // authenticate
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() {
        UserDAO userDao = new UserDAO();
        User user = userDao.getUserByUsername(this.username);
        if (user != null && user.getPassword().equals(this.password)) {
            return true;
        }
        return false;
    }

    public boolean isUsernameAvailable() {
        UserDAO userDao = new UserDAO();
        User user = userDao.getUserByUsername(this.username);
        if (user == null) {
            return true;
        }
        return false;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getIsGuest() {
        return false;
    }
}