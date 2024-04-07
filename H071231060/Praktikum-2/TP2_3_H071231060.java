class Cuboid {
    double height;
    double widht;
    double lenght;

    double getVolume() {
        double Volume = height * widht * lenght;
        return Volume;
    }
}

public class TP2_3_H071231060 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 30;
        cuboid.lenght = 50;
        cuboid.widht = 30;
        System.out.printf("Volume: %.2f", cuboid.getVolume());
    }
}
