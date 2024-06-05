package TP4_1_H071231012.models;

public class Profile {
    String fullName;
    String nickName;
    String hobby;
    int age;

    public Profile() {

    }

    public Profile(String fullName, int age, String hobby) {
        this.fullName = fullName;
        this.age = age;
        this.hobby = hobby;
    }

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

