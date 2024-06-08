import java.util.Scanner;

class Employe {
    private String name;
    private int age;
    private double salary;
    private boolean isFulltime;

    public Employe(String name, int age, double salary, boolean isFulltime) {
        // isi atribut nya apa
        // ...
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isFulltime = isFulltime;
    }

    public Employe() {
        // settting nilainya atribut
        // ...
        this.name = "";
        this.age = 0;
        this.salary = 0;
        this.isFulltime = false;

    }

    // setter getter
    // ...
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isFulltime() {
        return isFulltime;
    }

    public void setFulltime(boolean isFulltime) {
        this.isFulltime = isFulltime;
    }

    public void displayInfo() {
        // tampilkan info nama, age, salary dan apakah fulltime
        // ...
        System.out.println("=======================================");
        System.out.println("Detail karyawan");
        System.out.println("Nama: " + name);
        System.out.println("Umur: " + age);
        System.out.println("Gaji: " + salary);
        System.out.println("Is fulltime: " + (isFulltime ? "yes" : "no"));
    }

    public void printStatus() {
        // menampilkan karywan full time atau ga
        // ...
        if (isFulltime) {
            System.out.println("Karyawan ini adalah fulltime");
        } else {
            System.out.println("Karyawan ini adalh parttime");
        }
    }

    public void promosi() {
        System.out.println("\n=======================================\n=======================================");
        if (isFulltime) {
            System.out.println("PROMOSI DIBERIKAN");
        } else {
            System.out.println("Karyawan parttime tidak mendapat promosi");
        }
        System.out.println("=======================================\n=======================================\n");
    }

    public double calculateYear(double plusSalary, double minSalary) {
        // hitung gaji tahunan
        // ...
        salary = salary + plusSalary - minSalary;
        return isFulltime ? salary * 12 : salary * 8 * 12;
    }

    public void plusSalary(double amount) {
        // if else kenaikan gaji
        // ...
        if (amount > 0) {
            salary += amount;
            System.out.println("\nGaji bertambah menjadi " + salary);
        } else {
            System.out.println("\nKenaikan gaji tidak valid ");
        }
    }

    public void minSalary(double amount) {
        if (salary - amount >= 0 && amount > 0) {
            salary -= amount;
            System.out.println("\nGaji berkurang menjadi " + salary);
        } else {
            System.out.println("\nPotongan gaji tidak valid atau potongan lebih banyak dari gaji");
        }
    }
}

public class TP4_2_H071231063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age = 0;
        double salary = 0.0;
        boolean isFulltime = false;

        System.out.println("=======================================");
        System.out.println("Masukkan informasi karayawan");
        // try catch inputan
        try {
            //nama
            System.out.print("Nama: ");
            name = scanner.nextLine();
            while (name.matches("-?\\d+(\\.\\d+)?") || name.isEmpty()) {
                System.out.print("Nama harus mengandung huruf dan tidak boleh kosong\nNama: ");
                name = scanner.nextLine();
            }

            //umur
            System.out.print("Umur: ");
            String umur;
            try {
                umur = scanner.nextLine();
                if (!umur.isEmpty()) {
                    age = Integer.parseInt(umur);
                } else {
                    System.out.println("Inputan tidak boleh kosong");

                }
            } catch (Exception e) {
                System.out.print("Input berupa angka\n>  ");
                umur = scanner.nextLine();
            }

            //gaji
            System.out.print("Gaji: ");
            try {
                String gaji = scanner.nextLine();
                if (!gaji.isEmpty()) {
                    salary = Integer.parseInt(gaji);
                } else {
                    System.out.println("Inputan tidak boleh kosong");
                }
            } catch (Exception e) {
                System.out.print("Input berupa angka\n> ");
            }

            //full time(y/n)
            System.out.print("Is fulltime(true/false): ");
            isFulltime = scanner.nextBoolean();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Iputan tidak valid. Input kembali");
            main(args);
        }

        Employe employe = new Employe(name, age, salary, isFulltime);

        employe.displayInfo();

        //kenaikan gaji
        System.out.print("Kenaikan gaji: ");
        double plusSalary = scanner.nextDouble();
        employe.plusSalary(plusSalary);

        //potongan gaji
        System.out.print("Potongan gaji: ");
        double minSalary = scanner.nextDouble();
        employe.minSalary(minSalary);

        //gaji tahunan
        System.out.println("Gaji tahunan " + employe.calculateYear(0.0, 0.0));
        employe.printStatus();
        employe.promosi();
        scanner.close();
    }
}