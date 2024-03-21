import java.util.Scanner;
public class Nomor4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan jari-jari lingkaran: ");
            double jariJari = scanner.nextDouble();
            double luas = 3.1415 * jariJari * jariJari;
            System.out.printf("Luas lingkaran adalah: %.2f\n", luas);
        } catch (Exception e) {
            System.out.println("Input yang dimasukkan bukan angka.");
        } finally {
            scanner.close();
        }
    }
}