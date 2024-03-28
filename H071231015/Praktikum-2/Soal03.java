class Cuboid{
    double height;
    double width;
    double length;

    double getVolume(){
        return height * length * width;
    }
}

public class Soal03{
    public static void main(String[] args) {
        Cuboid cuboid =  new Cuboid();
        cuboid.height = 50;
        cuboid.width = 10;
        cuboid.length = 9;


        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}