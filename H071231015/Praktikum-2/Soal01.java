import java.util.Scanner;

public class Soal01{
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

    public boolean getGender(){
        return isMale;
    }

    public static void main(String[] args) {
        Soal01 obj = new Soal01();
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama : ");
        String nama = input.nextLine();
        obj.setName(nama);

        System.out.print("Masukkan umur : ");
        int umur = input.nextInt();
        obj.setAge(umur);

        System.out.print("Apakah seorang pria : \n1. Yes\n2. No\n= ");
        int x;
        while (true) {
            try {
                x = input.nextInt();
                if (x == 1) {
                    obj.setGender(true);
                    break;
                }
                else if (x == 2) {
                    obj.setGender(false);
                    break;
                }
                else{
                    System.out.println("Pilih antara 1 atau 2");
                    input.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan karena " + e);
                input.nextLine();
            }
        }

        if (x == 1) {
            obj.setGender(true);
        }
        else if (x == 2){
            obj.setGender(false);
        }

        System.out.println("\nBiodata :");
        
        System.out.println("Nama : " + obj.getName());
        System.out.println("Umur : " + obj.getAge());
        System.out.println("Pria : " + obj.getGender());

    }
}