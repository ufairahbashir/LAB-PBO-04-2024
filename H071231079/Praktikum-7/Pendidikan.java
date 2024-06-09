import java.util.Scanner;

public class Pendidikan extends Kehidupan {
    String inputPendidikan;

    @Override
    public void prosesKehidupan() {
        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("        RIWAYAT PENDIDIKAN");
        System.out.println("-----------------------------------");
        while (true) {
            System.out.print("Masukkan tingkat pendidikan (SD/SMP/SMA/S1/S2/S3) : ");
            inputPendidikan = scan.nextLine().toUpperCase();

            switch (inputPendidikan) {
                case "SD":
                case "SMP":
                case "SMA":
                case "S1":
                case "S2":
                case "S3":
                    return; // Exit the loop after valid input
                default:
                    System.out.println("Tingkat pendidikan yang dimasukkan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public String getInputPendidikan() {
        return inputPendidikan;
    }

    public void setInputPendidikan(String inputPendidikan) {
        this.inputPendidikan = inputPendidikan;
    }
}
