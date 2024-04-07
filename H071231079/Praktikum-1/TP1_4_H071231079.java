import java.util.Scanner;

public class TP1_4_H071231079 {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan jari-jari lingkaran : ");
            double r = input.nextDouble();
            final double pi = 3.14159;
            double luas = pi * r * r;

            System.out.printf("Luas lingkaran: %.2f\n", luas);
        } catch (Exception e) {
            System.out.println("Inputan harus berupa angka.");
            input.close();
        }
    }
}
