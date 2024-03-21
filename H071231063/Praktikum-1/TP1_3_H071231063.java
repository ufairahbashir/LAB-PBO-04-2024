package H071231063;
import java.util.Scanner;

public class TP1_3_H071231063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal: ");
        String input = scanner.nextLine();
        String output = ubahtanggal(input);
        System.out.println(output);
        scanner.close();
    }

    public static String ubahtanggal(String input) {
        String[] parts = input.split("-");
        int hari = Integer.parseInt(parts[0]);
        int bulan = Integer.parseInt(parts[1]);
        int tahun;
        if (parts[2].length() == 2) {
            int duadigittahun = Integer.parseInt(parts[2]);
            if (duadigittahun >= 0 && duadigittahun <= 29) {
                tahun = 2000 + duadigittahun;
            } else {
                tahun = 1900 + duadigittahun;
            }
        } else {
            if (parts[2].length() == 4) {
                tahun = Integer.parseInt(parts[2]);
            } else {
                System.out.print("Format tahun tidak sesuai");
                return "";
            }
        }
        String[] namabulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        String output = hari + " " + namabulan[bulan - 1] + " " + tahun;
        return output;
    }
}