import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(("Masukkan nama mobil pertama: "));
        String name = input.nextLine();

        System.out.println(("Masukkan kecepatan mobil pertama: "));
        int speed = input.nextInt();

        System.out.println(("Masukkan uang mobil pertama: "));
        int cash = input.nextInt();

        input.nextLine();

        HotWheels mercebesDenz = new HotWheels(name, speed, cash);
        HotWheels ferharri = new HotWheels();

        System.out.println(("Masukkan nama mobil kedua: "));
        String name2 = input.nextLine();
        ferharri.setName(name2);

        System.out.println(("Masukkan kecepatan mobil kedua: "));
        int speed2 = input.nextInt();
        ferharri.setSpeed(speed2);

        System.out.println(("Masukkan uang mobil kedua: "));
        int cash2 = input.nextInt();
        ferharri.setCash(cash2);

        System.out.println();

        mercebesDenz.showSpec();
        ferharri.showSpec();
        printBarriers();

        mercebesDenz.upgrade(50000);
        printBarriers();
        ferharri.upgrade(50000);
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

        input.close();
    }

        

    public static void printBarriers() {
        System.out.println("================================");
    }
}
