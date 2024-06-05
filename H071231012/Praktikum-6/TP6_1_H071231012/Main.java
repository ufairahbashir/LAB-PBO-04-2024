package TP6_1_H071231012;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone(1000000, "nokia");
        Car car = new Car(200, "Black", 200);
        Pitbull pitbull = new Pitbull(2, 70);
        SiberianHusky siberianHusky = new SiberianHusky(0, 1);
        Bulldog bulldog = new Bulldog(0, 6);
        GermanShepherd germanShepherd = new GermanShepherd(0, 1);
        // System.out.println("---------------------------------------------------------------------------------------------");
        garis();
        pitbull.move();
        pitbull.describe();
        System.out.println("---------------------------------------------------------------------------------------------");
        siberianHusky.move();
        siberianHusky.describe();
        System.out.println("---------------------------------------------------------------------------------------------");
        bulldog.move();
        bulldog.describe();
        System.out.println("---------------------------------------------------------------------------------------------");
        germanShepherd.move();
        germanShepherd.describe();
        System.out.println("---------------------------------------------------------------------------------------------");
        smartphone.move();
        System.out.println("---------------------------------------------------------------------------------------------");
        car.move();
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    static void garis(){
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}

