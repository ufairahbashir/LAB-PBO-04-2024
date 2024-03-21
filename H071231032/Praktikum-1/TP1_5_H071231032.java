import java.util.Scanner;

public class TP1_5_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean found = false;
            int find, n;
            
            while (true) {
                try {
                    System.out.print("Masukkan dimensi array persegi (n x n): ");
                    String test = sc.nextLine();
                    n = Integer.parseInt(test);

                    if (n == 0) {
                        System.out.println("n tidak boleh 0 (nol)!\n");
                        continue;
                    }

                    if (n > 3 || n < 0) {
                        System.out.println("n minimal 1 dan maksimal 3!\n");
                        continue;
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("n harus berupa integer dan tanpa spasi!\n");
                }
            }
            
            int[][] arr = new int[n][n];
            boolean Valid = false;

            while (!Valid) {
                try{
                    System.out.printf("\nMasukkan angka sebanyak %d (pisah dengan spasi):\n", n);
                    
                    for (int i = 0; i < n; i++) {
                        System.out.printf("- Angka untuk baris ke-%d: ", i+1);
                        String[] test = sc.nextLine().split(" ");

                        if (test.length != n) {
                            System.out.printf("Jumlah angka harus sebanyak %d.\n", n);
                            Valid = false;
                            break;
                        }

                        for (int j = 0; j < n; j++) {
                            arr[i][j] = Integer.parseInt(test[j]);
                            Valid = true;
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Angka harus berupa integer!");
                    Valid = false;
                }
            }
            
            while (true) {
                System.out.print("\nMasukkan angka yang ingin dicari: ");
                String test = sc.nextLine();
                
                try {
                    find = Integer.parseInt(test);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Angka harus berupa bilangan bulat.");
                }
            }
            
            System.out.print('\n');

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == find) {
                        System.out.printf("Angka %d ditemukan dalam array pada indeks [%d][%d].\n", find, i, j);
                        found = true;
                    }
                }
            }
            if (!found) { System.out.printf("Angka %d tidak ditemukan di dalam array.\n", find);}
        }
    }
}