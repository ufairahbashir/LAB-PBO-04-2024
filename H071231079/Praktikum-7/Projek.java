import java.util.Scanner;

public class Projek extends Kehidupan{
    int jumlahProjek;

    @Override
    public void prosesKehidupan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("             PROJEK IT");
        System.out.println("-----------------------------------");
        System.out.println("1. Minimal 4 \n2. Minimal 8 \n3. Minimal 12 \n4. Lebih dari 15");
        int projek = 0;
        boolean cekProjek = false;
        do {
            try {
                System.out.print("Input : ");
                projek = Integer.parseInt(scan.nextLine());
                if (projek >= 1 && projek <= 4) {
                    cekProjek = true;
                } else {
                    System.out.println("Inputan tidak valid. Silahkan masukkan angka 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        } while (!cekProjek);

        switch (projek) {
            case 1:
                jumlahProjek = 4;
                break;
            case 2:
                jumlahProjek = 8;
                break;
            case 3:
                jumlahProjek = 12;
                break;
            case 4:
                jumlahProjek = 15;
                break;
        }
    }

    public int getJumlahProjek() {
        return jumlahProjek;
    }
}
