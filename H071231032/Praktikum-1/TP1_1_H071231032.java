import java.util.Scanner;

public class TP1_1_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n, JumlahInteger = 0, JumlahDesimal = 0;

            while (true) {
                try {
                    System.out.print("n: ");
                    String test = sc.nextLine();
                    n = Integer.parseInt(test);

                    if (test.isEmpty() || Integer.parseInt(test) == 0) {
                        System.out.println("n tidak boleh 0 (nol)!\n");
                        continue;
                    }
                    
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("n harus berupa integer!\n");
                }
            }

            double[] arr = new double[n];
            boolean ValidInput;

            do {
                ValidInput = true;
                System.out.print("\nMasukkan bilangan (pisah dengan spasi): ");
                String[] test = sc.nextLine().split(" ");

                if (test.length != n) {
                    System.out.printf("\nInput harus berjumlah %d. Silakan coba lagi!\n", n);
                    ValidInput = false;
                    continue;
                }

                for (int i = 0; i < n; i++) {
                    try {
                        arr[i] = Double.parseDouble(test[i]);
                    } catch (NumberFormatException e) {
                        System.out.println('\n' + test[i] + " bukan bilangan. Silakan coba lagi!");
                        ValidInput = false;
                        break;
                    }
                }

            } while (!ValidInput);

            for (int i = 0; i < n; i++) {
                if (arr[i] % 1 == 0) {
                    JumlahInteger++;
                } else {
                    JumlahDesimal++;
                }
            }

            System.out.printf("\n%d bilangan bulat\n%d bilangan desimal\n", JumlahInteger, JumlahDesimal);
        }
    }
}