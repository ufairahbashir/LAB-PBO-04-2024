public class LiveCoding {
    String nama;
    int age;
    boolean isMale;
    String gender = "Laki";
    String notgender = "Bukan laki";


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String GetGender() {
        if (isMale) {
            return gender;
        }
        else{
            return notgender;
        }
    }

    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public static void main(String[] args) {
        LiveCoding obj = new LiveCoding();

        obj.setNama("Rudy");
        obj.setAge(18);
        obj.setGender(true);

        System.out.println(obj.getNama());
        System.out.println(obj.getAge());
        System.out.println(obj.GetGender());
    }
    
}
