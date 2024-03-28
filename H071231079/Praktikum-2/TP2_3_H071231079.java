import java.util.Scanner;

class Cuboid {
    double height;
    double widht;
    double length;

    double getVolume() {
        double volume = height * widht * length;
        return volume;
    }
}

public class TP2_3_H071231079 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cuboid cuboid = new Cuboid();

        // cuboid.height = 16;
        // cuboid.widht = 12;
        // cuboid.length = 20;

        try {
            System.out.print("Masukkan tinggi kubus  : ");
            cuboid.height = scan.nextDouble();

            System.out.print("Masukkan lebar kubus   : ");
            cuboid.widht = scan.nextDouble();

            System.out.print("Masukkan panjang kubus : ");
            cuboid.length = scan.nextDouble();
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
        } finally {
            scan.close();
        }
    
        System.out.println(String.format("Volume \t\t\t: %.2f", cuboid.getVolume()));
    }
}
