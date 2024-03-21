package H071231063;
import java.util.Scanner;
public class TP1_4_H071231063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan jari-jari lingkaran: ");
            double r = scanner.nextDouble();
            double area = 3.14 * r * r;
            System.out.printf("Luas lingkaran adalah: %.2f\n", area);
        } catch (Exception e) {
            System.out.println("Input bukan angka.");
        } finally {
            scanner.close();
        }
    }
}