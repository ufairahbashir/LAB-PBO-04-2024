package login_app.models;

public class Profile {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */
    private String fullName, NickName, Hobby;
    private int Umur;
    // public Profile(String fullName, String nickName, String hobby, int umur) {
    //     this.fullName = fullName;
    //     NickName = nickName;
    //     Hobby = hobby;
    //     Umur = umur;
    // }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getNickName() {
        return NickName;
    }
    public void setNickName(String nickName) {
        NickName = nickName;
    }
    public String getHobby() {
        return Hobby;
    }
    public void setHobby(String hobby) {
        Hobby = hobby;
    }
    public int getUmur() {
        return Umur;
    }
    public void setUmur(int umur) {
        Umur = umur;
    }
    
    
}