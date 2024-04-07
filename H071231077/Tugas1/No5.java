package Tugas1;
import java.util.*;

public class No5 {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in); 
    
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        boolean cari = false;

        try {
            System.out.print("Masukkan Bilangan :  ");
            int bil = inputan.nextInt();
            inputan.close();

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == bil) {
                        System.out.println("Ditemukan " + bil + " di [" + i + "][" + j + "]");
                        cari = true;
                        break;
                    }
                }
                if (cari) {
                    break;
                }
            }
            if (!cari) {
                System.out.println("Angka Tidak Terdapat Dalam Array. Coba Lagi!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan. Inputan Harus Berupa Angka atau Angka Berada Dalam Array. Coba Lagi!");
        }
    }
}