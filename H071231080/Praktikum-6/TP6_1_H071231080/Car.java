public class Car implements Move {
    int totalForwardGear, maxSpeed;
    String color;
    public Car(int totalForwardGear, int maxSpeed, String color){
        this.totalForwardGear = totalForwardGear;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }
    public void move(){
        System.out.println("Mobil sedang berakselerasi");
    }
    
}
