package H071231063;
import java.util.Scanner;
public class TP1_1_H071231063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan jumlah bilangan: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan bilangan, pisahkan dengan spasi: ");
            String[] numbers = scanner.nextLine().split(" ");
            int decimals = 0;
            int integers = 0;
            for (String number : numbers) {
                if (number.contains(".")) {
                    decimals++;
                } else {
                    integers++;
                }
            }
            System.out.println("Jumlah bilangan desimal: " + decimals);
            System.out.println("Jumlah bilangan bulat: " + integers);
        } catch (Exception e) {
            System.out.println("Input bukan angka");
        } finally {
            scanner.close();
        }
    }
}