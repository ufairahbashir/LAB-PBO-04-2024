class Cuboid{
    double height;
    double widht;
    double length;

    double getVolume(){
        return height*length*widht;
    }
}

public class TP2_3_H071231063 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height=9;
        cuboid.widht=5;
        cuboid.length=100;
        
        System.out.printf("Volume= %.2f",cuboid.getVolume());
    }
}

