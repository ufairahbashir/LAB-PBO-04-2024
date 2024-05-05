public abstract class Car extends Audio implements Mover {
    protected int totalForwardGear, maxSpeed;
    protected String name, color, engineSoundFile;

    public Car(String color) {
        this.color = color;
    }

    public void engineSound() {
        System.out.println("Suara mobil " + this.name + "...\n");
        playAudio(engineSoundFile);
    }

    @Override
    public void move() {
        System.out.println("Mobil sedang berakselerasi.\n");
    }

    public void detailCar() {
        System.out.println("-".repeat(60));
        System.out.println("Car name           : " + this.name);
        System.out.println("Car color          : " + this.color);
        System.out.println("Total Forward Gear : " + this.totalForwardGear);
        System.out.println("Car Top Speed      : " + this.maxSpeed + "kph");
        System.out.println("-".repeat(60) + "\n");
    }

    public abstract void upgradeEngine();
}

class ToyotaSupra extends Car {
    public ToyotaSupra(String color) {
        super(color);
        this.name = "Toyota Supra";
        this.engineSoundFile = "CarEngines/ToyotaSupra.wav";
        this.totalForwardGear = 6;
        this.maxSpeed = 285;
    }

    @Override
    public void upgradeEngine() {
        System.out.println("Mesin " + this.name + " telah ditingkatkan.\n");
        this.maxSpeed += 10;
    }
}

class Porsche911GT3RS extends Car {
    public Porsche911GT3RS(String color) {
        super(color);
        this.name = "Porsche 911 GT3 RS";
        this.engineSoundFile = "CarEngines/Porsche911GT3RS.wav";
        this.totalForwardGear = 7;
        this.maxSpeed = 296;
    }

    @Override
    public void upgradeEngine() {
        System.out.println("Mesin " + this.name + " telah ditingkatkan.\n");
        this.maxSpeed += 8;
    }
}

class LancerEvoVII extends Car {
    public LancerEvoVII(String color) {
        super(color);
        this.name = "Mitsubishi Lancer Evolution VII";
        this.engineSoundFile = "CarEngines/LancerEvoVII.wav";
        this.totalForwardGear = 5;
        this.maxSpeed = 253;
    }

    @Override
    public void upgradeEngine() {
        System.out.println("Mesin " + this.name + " telah ditingkatkan.\n");
        this.maxSpeed += 6;
    }
}