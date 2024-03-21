import java.util.Scanner;
public class TP1_4_H071231012 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double PI = 3.14; 

        try {
            System.out.print("Masukkan Jari-jari : ");
            double r = input.nextDouble();
            double luas = PI * (r*r);
            System.out.printf("Luasnya adalah : %.2f", luas); 
        } catch (Exception e){ //jika terjadi kesalahan
            System.out.println("Bukan Angka!");
        }
        input.close();
        }

    }

