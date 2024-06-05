package tugas.Models;


import javafx.scene.image.ImageView;

public class Account extends Model{
    String email, username, name, passwowrd;
    ImageView photoFile;
    

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPasswowrd() {
        return passwowrd;
    }


    public void setPasswowrd(String passwowrd) {
        this.passwowrd = passwowrd;
    }


    public ImageView getPhotoFile() {
        return photoFile;
    }


    public void setPhotoFile(ImageView photoFile) {
        this.photoFile = photoFile;
    }


    //for get id
    public Account(int id, String email, String username, String name, String passwowrd, ImageView photoFile) {
        super(id);
        this.email = email;
        this.username = username;
        this.name = name;
        this.passwowrd = passwowrd;
        this.photoFile = photoFile;
    }


    //for login
    public Account(int id) {
        super(id);
    }
}