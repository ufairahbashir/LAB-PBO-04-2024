package Livecode6;
interface Moveable{
    void move();
}

abstract class Dog implements Moveable{
    protected int position;
    protected int averageLength;
    public Dog(int position, int averageLength) {
        this.position = position;
        this.averageLength = averageLength;
    }
    public abstract void move();
    public abstract void describe();
}

class Pitbull extends Dog{
    public Pitbull(int position, int averageLength){
        super(position, averageLength);
    }
    public void move(){
        this.position += 3;
        System.out.println("Pitbull bergerak. Posisi sekarang: "+ this.position);
    }
    public void describe(){
        System.out.println("Pitbull adlah anjing yang agresif");
    }
}

class SiberianHusky extends Dog{
    public SiberianHusky(int position, int averageLength){
        super(position, averageLength);
    }
    public void move(){
        this.position += 2;
        System.out.println("Siberian husky bergerak. Posisi sekarang: "+ this.position);
    }
    public void describe(){
        System.out.println("Siberian husky adalah anjing yang setia");
    }
}

class Bulldog extends Dog{
    public Bulldog(int position, int averageLength){
        super(position, averageLength);
    }
    public void move(){
        this.position += 1;
        System.out.println("Bulldog bergerak. Posisi sekarang: "+ this.position);
    }
    public void describe(){
        System.out.println("Bulldog adalh ras anjing yang berhati-hati");
    }
}
class GermanShepherd extends Dog{
    public GermanShepherd(int position, int averageLength){
        super(position, averageLength);
    }
    public void move(){
        this.position += 3;
        System.out.println("Pitbull bergerak. Posisi sekarang: "+ this.position);
    }
    public void describe(){
        System.out.println("Pitbull adalah ras anjing yang berani");
    }
}

class Smartphone implements Moveable{
    public int price;
    public String brand;
    public Smartphone(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }
    public void move(){
        System.out.println("Smartphone berpindah");
    }
}
 
class Car implements Moveable {
    public int totalFowardGear, maxspeed;
    public String color;
    public Car(int totalFowardGear, int maxspeed, String color) {
        this.totalFowardGear = totalFowardGear;
        this.maxspeed = maxspeed;
        this.color = color;
    }
    public void move(){
        System.out.println("Mobil sedang berakselarasi");
    }
}

public class Praktikum6 {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone(0, "Samsung");
        Car car = new Car(0, 0, "Biru");
        Bulldog bulldog = new Bulldog(0, 0);
        smartphone.move();
        car.move();
        bulldog.move();
        bulldog.describe();
    }
}