import java.util.Scanner;

public class TP1_4_H071231032 {
    public static void main(String[] args) {
        double r, LuasLingkaran;

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("Masukkan jari-jari lingkaran (r): ");
                String test = sc.nextLine();

                try {
                    r = Double.parseDouble(test);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Jari-jari lingkaran harus berupa angka. Coba lagi!\n");
                }
            }
        }

        LuasLingkaran = Math.PI * r * r;
        System.out.printf("%.2f\n", LuasLingkaran);
    }
}