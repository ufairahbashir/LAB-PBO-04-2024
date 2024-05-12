import java.util.Scanner;

public class Keluarga {
    String status;

    void statusKeluarga() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Pilih status pernikahan (1. Menikah, 2. Belum Menikah): ");

        boolean validInput = false;
        do {
            try {
                int choice = Integer.parseInt(scan.nextLine());

                switch (choice) {
                    case 1:
                        status = "Menikah";
                        validInput = true;
                        break;
                    case 2:
                        status = "Belum Menikah";
                        validInput = true;
                        break;
                    default:
                        System.out.println("Input tidak valid. Silahkan pilih 1 atau 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        } while (!validInput);
    }
    
    public String getStatus() {
        return status;
    }
}