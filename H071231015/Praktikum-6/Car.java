import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;

class Car extends Parent implements Move{
    int totalForwardGear;
    String color;
    int maxSpeed;

    @Override
    public void move() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Map.printMap(this);
    }
}

class CarAbility extends Car{
    Object position;
    Walk walk;
    
    public CarAbility(Object position, Walk walk) {
        this.position = position;
        this.walk = walk;
    }
    public Object getPosition() {
        return position;
    }
    public void setPosition(Object position) {
        this.position = position;
    }
    public Walk getWalk() {
        return walk;
    }
    public void setWalk(Walk walk) {
        this.walk = walk;
    }

    static void enterCar(Audi audi, Porsche porsche, Lamborghini lambo ,Mercedes mercedes) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        Car car;
        outerloop:
        while (true) {
            while (true) {
                System.out.printf("%s\n", "=".repeat(Map.getLebar()));
                System.out.println("Silahkan pilih jenis Car:\n1. Audi\n2. Porsche\n3. Lamborghini\n4. Mercedes Benz\n5. Kembali");
                int menu = (int) Main.inputUserAngka("= ");
                if (menu == 1) {
                    car = audi;
                    AudioFile.Audio("Audio\\Car3.wav");
                    break;                
                }
                else if (menu == 2) {
                    car = porsche;
                    AudioFile.Audio("Audio\\Car1.wav");
                    break;
                }
                else if (menu == 3) {
                    car = lambo;
                    AudioFile.Audio("Audio\\Car2.wav");
                    break;                
                }
                else if (menu == 4) {
                    car = mercedes;
                    AudioFile.Audio("Audio\\Car4.wav");
                    break;
                }
                else if (menu == 5) {
                    break outerloop;
                }
                else{
                    System.out.println("Invalid input");
                }
            }
    
            while (true) {
                System.out.printf("%s\n", "=".repeat(Map.getLebar()));
                System.out.println("Silahkan pilih opsi : \n1. Test drive\n2. Tampilkan deskripsi\n3. Cek sound\n4. Kembali");
                int menu = (int) Main.inputUserAngka("= ");
                if (menu == 1) {
                    car.move();
                }
                else if (menu == 2) {
                    System.out.printf("%s\n", "=".repeat(Map.getLebar()));
                    if (car instanceof Audi) {
                        audi.describe();
                    }
                    else if (car instanceof Porsche) {
                        porsche.describe();
                    }
                    else if (car instanceof Lamborghini) {
                        lambo.describe();
                    }
                    else if (car instanceof Mercedes) {
                        mercedes.describe();
                    }
                }
                else if (menu == 3) {
                    if (car instanceof Audi) {
                        AudioFile.Audio("Audio\\Car3.wav");
                    }
                    else if (car instanceof Porsche) {
                        AudioFile.Audio("Audio\\Car1.wav");
                    }
                    else if (car instanceof Lamborghini) {
                        AudioFile.Audio("Audio\\Car2.wav");
                    }
                    else if (car instanceof Mercedes) {
                        AudioFile.Audio("Audio\\Car4.wav");
                    }
                }
                else if (menu == 4) {
                    break;
                }
                else{
                    System.out.println("Invalid input");
                }
            }
        }
    }
}

class Audi extends CarAbility{
    private String brand = "Audi";
    private int price = 50000;

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public Audi(Object position, Walk walk, int totalForwardGear, String color, int maxSpeed) {
        super(position, walk);
        this.totalForwardGear = totalForwardGear;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    void describe(){
        System.out.println("Brand     : " + this.getBrand());
        System.out.println("Price     : $" + this.getPrice());
        System.out.println("Gear      : " + this.totalForwardGear);
        System.out.println("Color     : " + this.color);
        System.out.println("Max Speed : " + this.maxSpeed);
    }

}

class Porsche extends CarAbility{
    private String brand = "Porche";
    private int price = 60000;

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
    public Porsche(Object position, Walk walk, int totalForwardGear, String color, int maxSpeed) {
        super(position, walk);
        this.totalForwardGear = totalForwardGear;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    void describe(){
        System.out.println("Brand     : " + this.getBrand());
        System.out.println("Price     : $" + this.getPrice());
        System.out.println("Gear      : " + this.totalForwardGear);
        System.out.println("Color     : " + this.color);
        System.out.println("Max Speed : " + this.maxSpeed);
    }

}

class Lamborghini extends CarAbility{
    private String brand = "Lamborghini";
    private int price = 80000;

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
    public Lamborghini(Object position, Walk walk, int totalForwardGear, String color, int maxSpeed) {
        super(position, walk);
        this.totalForwardGear = totalForwardGear;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    void describe(){
        System.out.println("Brand     : " + this.getBrand());
        System.out.println("Price     : $" + this.getPrice());
        System.out.println("Gear      : " + this.totalForwardGear);
        System.out.println("Color     : " + this.color);
        System.out.println("Max Speed : " + this.maxSpeed);
    }

}

class Mercedes extends CarAbility{
    private String brand = "Merdeces Benz";
    private int price = 70000;

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
    public Mercedes(Object position, Walk walk, int totalForwardGear, String color, int maxSpeed) {
        super(position, walk);
        this.totalForwardGear = totalForwardGear;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    void describe(){
        System.out.println("Brand     : " + this.getBrand());
        System.out.println("Price     : $" + this.getPrice());
        System.out.println("Gear      : " + this.totalForwardGear);
        System.out.println("Color     : " + this.color);
        System.out.println("Max Speed : " + this.maxSpeed);
    }

}
