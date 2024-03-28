import java.util.Scanner;

public class TP2_3_H071231080 {
    double height;
    double widht;
    double lenght;
    
    double getVolume() {
        return height * widht * lenght;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
    
        TP2_3_H071231080 cuboid = new TP2_3_H071231080();
        cuboid.height = sc.nextDouble();
        cuboid.widht = sc.nextDouble();
        cuboid.lenght = sc.nextDouble();
    
        System.out.printf("Volume = %.2f", cuboid.getVolume());
        
    
        sc.close();
    }
}