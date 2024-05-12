interface Moveable {
    void move();
    
}
abstract class Dog implements Moveable{
    int position, averagelength;

    public Dog(int position, int averagelength) {
        this.position = position;
        this.averagelength = averagelength;
    }
    @Override
    public abstract void move();
    
    public abstract void describe();
}

class Pitbull extends Dog {
    String Nama;

    public Pitbull(int position, int averagelength, String nama) {
        super(position, averagelength);
        Nama = nama;
    }
    @Override
    public void move(){
        position += 3;
        System.out.println(position);
    }
    @Override
    public void describe(){
        System.out.println("Pitbull: Kuat dan berotot tampan pemberani");
    }

}
class SiberianHusky extends Dog {
    String Nama;

    public SiberianHusky(int position, int averagelength, String nama) {
        super(position, averagelength);
        Nama = nama;
    }
    @Override
    public void move(){
        position += 2;
        System.out.println(position);
    }
    @Override
    public void describe(){
        System.out.println("Nama ANJing: "+Nama+"\nSiberian Husky: memiliki bulu yang tebal dan cantik. serta memiliki kemampuan berburu yang baik.");
    }
}
class Bulldog extends Dog{
    String Nama;

    public Bulldog(int position, int averagelength, String nama) {
        super(position, averagelength);
        Nama = nama;
    }
    @Override
    public void move(){
        position += 1;
        System.out.println(position);
    }
    @Override
    public void describe(){
        System.out.println("Bulldog: dikenal dengan kulit yang keriput dan kusut. hidung nya pesek");
    }
}
class GermanSepherd extends Dog{
    String Nama;

    public GermanSepherd(int position, int averagelength, String nama) {
        super(position, averagelength);
        Nama = nama;
    }
    @Override
    public void move(){
        position += 1;
        System.out.println(position);
    }
    @Override
    public void describe(){
        System.out.println("German Sepherd: Anjing yang loyal, cepat, dan cerdas. bisa menggigit");
    }
}
class Smartphone implements Moveable{
    int Price;
    String Brand;

    public Smartphone(int price, String brand) {
        Price = price;
        Brand = brand;
    }

    @Override
    public void move(){
        System.out.println("Smartphone Berpindah");
    }
}
class Car implements Moveable{
    int Totalforwardgear, MaxSpeed;
    String Color;

    
    public Car(int totalforwardgear, int maxSpeed, String color) {
        Totalforwardgear = totalforwardgear;
        MaxSpeed = maxSpeed;
        Color = color;
    }
    @Override
    public void move(){
        System.out.println("Mobil sedang berakselerasi");
    }
}

public class Main {

    public static void main(String[] args) {
        Smartphone Hape = new Smartphone(1000000, "Sumsang");
        Car Avanza = new Car(5, 180, "Putih");
        Dog Husky = new SiberianHusky(5, 70, "Asep");

        Hape.move();
        Avanza.move();
        Husky.move();
        Husky.describe();
    }
}