import java.util.Scanner;

class person {
    String name;
    String gender;
    int age;
    boolean isMale;

    public String getName() {
        return name;
    }

    public void setName(String nama) {
        this.name = nama;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){
        this.age= age;
    }

    public String getGender() {
        String lowerGender = gender.toLowerCase();
        return lowerGender.equals("male") ? "boy" : "girl";
    }

    public void setGender(String jenisKelamin) {
        gender = jenisKelamin;
    }

    public void getDate() {
        System.out.println("your identity");
        System.out.println("Name\t: " + getName());
        System.out.println("Age\t: " + getAge());
        System.out.println("Gender\t: " + getGender());

    }
}

public class TP2_1_H071231012{
    public static void main(String[] args) {
        person people = new person();
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama anda: ");
        String nama = input.nextLine();
        System.out.print("Masukkan umur anda: ");
        int umur = input.nextInt();
        input.nextLine();
        System.out.print("Jenis kelamin (male / female): ");
        String jenisKelamin = input.nextLine();

        people.setName(nama);
        people.setAge(umur);
        people.setGender(jenisKelamin);

        people.getDate();
    }
}
