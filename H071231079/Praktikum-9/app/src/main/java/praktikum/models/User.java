package praktikum.models;

public class User extends Model{
    private String name, email, phoneNumber;
    private int age;

    //untuk login
    public User(int id) {
        super(id);
    }

    //untuk getUserById()
    public User(int id, String name, String email, String phoneNumber, int age) {
        super(id);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    
}
