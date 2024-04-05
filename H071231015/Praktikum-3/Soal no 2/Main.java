import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HotWheels mercebesDenz = new HotWheels("Mercebes-Denz", 4, 20000,0);

        HotWheels ferharri = new HotWheels();
        System.out.print("Masukkan nama mobil : ");
        String nama = input.nextLine();
        System.out.print("Masukkan kecepatan mobil : ");
        double kecepatan = input.nextDouble();
        System.out.print("Masukkan Jumlah uang : ");
        double uang = input.nextDouble();

        ferharri.setName(nama);
        ferharri.setSpeed(kecepatan);
        ferharri.setCash(uang);

        // ferharri.setName("Ferharri");
        // ferharri.setSpeed(4);
        // ferharri.setCash(50000);

        System.out.println();
        mercebesDenz.showSpec();
        ferharri.showSpec();

        printBarriers();
        mercebesDenz.upgrade(50000);
        printBarriers();
        ferharri.upgrade(42000);
        printBarriers();

        System.out.println();
        ferharri.showSpec();

        printBarriers();
        ferharri.raceTo(mercebesDenz);
        printBarriers();
        mercebesDenz.raceTo(ferharri);
        printBarriers();

        System.out.println();
        mercebesDenz.showSpec();
        ferharri.showSpec();
    }

    public static void printBarriers() {
        System.out.println("================================");
    }
}
