package TP4_1_H071231080.models;

public class User {
    private String username;
    private String password;
    Profile profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter dan setter untuk masing-masing atribut
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}







