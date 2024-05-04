public class Main {
    public static void main(String[] args) {

        Smartphone smartphone = new Smartphone(0, "Iphone");

        Car car = new Car(0, 0, "Hitam");
        
        Pitbull pitbull = new Pitbull(0, 0);

        smartphone.move();

        car.move();

        pitbull.move();
        pitbull.describe();
    }    
}
