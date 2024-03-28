import java.util.InputMismatchException;
import java.util.Scanner;

class Cuboid {
    double height, width, length;

    double getVolume() {
        return height * width * length;
    }
}

public class TP2_3_H071231032 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        
        try (Scanner sc = new Scanner(System.in)){
            while (true) {
                try {
                    System.out.print("Masukkan panjang : ");
                    cuboid.length = sc.nextDouble();
                    System.out.print("Masukkan lebar   : ");
                    cuboid.width = sc.nextDouble();
                    System.out.print("Masukkan tinggi  : ");
                    cuboid.height = sc.nextDouble();

                    break;
                } catch (InputMismatchException e) { System.out.println("Invalid input.\n"); sc.next(); }
            }
        }
        
        System.out.printf("\nVolume = %.2f\n", cuboid.getVolume());
    }
}