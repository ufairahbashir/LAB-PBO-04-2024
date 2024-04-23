import java.util.*;
class Cuboid{
    double height;
    double widht;
    double lenght;

    double getVolume(){
        return height * widht * lenght;
    }
}

public class No3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cuboid cuboid = new Cuboid();
        
        System.out.print("Input height : ");
        double height = input.nextDouble();
        cuboid.height=height;

        System.out.print("Input widht : ");
        double widht = input.nextDouble();
        cuboid.widht=widht;

        System.out.print("Input lenght : ");
        double lenght = input.nextDouble();
        cuboid.lenght=lenght;

        System.out.printf("Volume = %.2f", cuboid.getVolume());

    }
}