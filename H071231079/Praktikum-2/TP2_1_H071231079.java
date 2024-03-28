import java.util.Scanner;

class Person {
    String name;
    int age;
    boolean isMale;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public String getGender() {
        return (isMale ? "Male" : "Female");
    }
}

public class TP2_1_H071231079 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Person person1 = new Person();

        // person1.setName("haikal");
        // person1.setAge(15);
        // person1.setGender(true);
        
        try {
            System.out.print("Masukkan Nama     : ");
            person1.name = scan.next();

            System.out.print("Masukkan Umur     : ");
            person1.age = scan.nextInt();

            System.out.print("Male ? true/false : ");
            person1.isMale = scan.nextBoolean();
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
        } finally {
            scan.close();
        }

        System.out.println("Hai, my name is " + person1.getName());
        System.out.println("I'm " + person1.getAge() + " years old");

        if (person1.getGender() == "Male") {
            System.out.println("I am a " + person1.getGender());
        } else if (person1.getGender() == "Female") {
            System.out.println("I am a " + person1.getGender());
        }

    }
}
