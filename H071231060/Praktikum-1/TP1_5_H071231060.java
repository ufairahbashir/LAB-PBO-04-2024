import java.util.Scanner;

public class Nomor5 {
    public static void main(String[] args) {
        int[][] Kum_Angka = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan bilangan yang ingin dicari: ");
            int Ang_Dicari = scanner.nextInt();

            boolean found = false;
            for (int i = 0; i < Kum_Angka.length; i++) {
                for (int j = 0; j < Kum_Angka[i].length; j++) {
                    if (Kum_Angka[i][j] == Ang_Dicari) {
                        System.out.printf("Found %d at [%d][%d]\n", Ang_Dicari, i, j);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found) {
                System.out.println("Angka tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Input yang dimasukkan bukan bilangan.");
        } finally {
            scanner.close();
        }
    }
}