package login_app.models;

public class Profile {
    String fullName;
    int age;
    String hobby;
    String nickname;

    public Profile(String fullName, int age, String hobby, String nickname){
        this.fullName = fullName;
        this.age = age;
        this.hobby = hobby;
        this.nickname = nickname;   
    }

    public Profile() {
        
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
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