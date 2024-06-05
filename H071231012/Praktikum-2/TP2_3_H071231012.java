class Cuboid{
    double height;
    double widht;
    double lenght;

    double getVolume(){
        return height * widht * lenght;
    }
}

public class TP2_3_H071231012 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 50;
        cuboid.widht = 3;
        cuboid.lenght = 30;
        System.out.printf("volume = %.2f", cuboid.getVolume());
    }
}
