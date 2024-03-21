package H071231063;
import java.util.Scanner;
public class TP1_5_H071231063 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Scanner scanner = new Scanner(System.in);    
        try {
            System.out.print("Masukkan bilangan yang ingin dicari: ");
            int target = scanner.nextInt();
            boolean cari = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.printf("Found %d at [%d][%d]\n", target, i, j);
                        cari = true;
                        break;
                    }
                }
                if (cari) {
                    break;
                }
            }
            if (!cari) {
                System.out.println("Angka tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Input bukan bilangan bulat.");
        } finally {
            scanner.close();
        }
    }
}