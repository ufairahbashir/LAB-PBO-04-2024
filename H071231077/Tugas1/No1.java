package Tugas1;
import java.util.*;

public class No1 {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Bilangan : ");
        int n = 0;
        if(inputan.hasNextInt()) {
            n = inputan.nextInt();
            inputan.nextLine();
        } else {
            System.out.println("Input Harus Angka. Coba Lagi!");
            return;//revisi setelah tidak bisa menerima inputan selain angka
        }

        int BilanganBul = 0;
        int BilanganDes = 0;

        System.out.print("Masukkan " + n + " Bilangan : ");
        String bilangan = inputan.nextLine();
        String[] angka = bilangan.split(" ");

        for (String angkaBaru : angka) {
            try { 
                double ang = Double.parseDouble(angkaBaru);
                if (ang == (int) ang) {
                    BilanganBul++;   
                } else {
                    BilanganDes++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input Harus Angka. Coba Lagi!");
                return;
            }
        }
        
        System.out.println("\nTerdapat " + BilanganBul + " Bilangan Bulat" );
        System.out.println("Terdapat " + BilanganDes + " Bilangan Desimal" );
        inputan.close();
    }
}
