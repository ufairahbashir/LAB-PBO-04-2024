import java.util.Scanner;

class Person {
    String name;
    int age;
    String isMale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isMale() {
        return isMale;
    }

    public void setGender(String isMale) {
        this.isMale = isMale;
    }
}

public class No1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Person orang = new Person();

        System.out.println("Input nama : ");
        String name = input.nextLine();
        orang.setName(name);

        System.out.println("input umur : ");
        int age = input.nextInt();
        orang.setAge(age);

        input.nextLine();

        System.out.println("Ingfo gender : ");
        String isMale = input.nextLine();
        orang.setGender(isMale);

        input.close();

        System.out.println((orang.getName()));
        System.out.println(orang.getAge());
        System.out.println(orang.isMale());

    }
}