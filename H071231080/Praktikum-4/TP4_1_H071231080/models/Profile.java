package TP4_1_H071231080.models;

import TP4_1_H071231080.utils.StringUtils;


public class Profile {
    private String fullName;
    private String hobby;
    private String nickname;
    private int age;

    
    public Profile(String fullName, int age, String hobby) {
        this.fullName = fullName;
        this.age = age;
        this.hobby = hobby;
        this.nickname = StringUtils.getNickname(fullName);
    }

    // Getter dan setter untuk masing-masing atribut
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
