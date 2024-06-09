import Move.Moveable;

public class Car extends AudioPlayer implements Moveable {
    private int totalForwardGear;
    private String color;
    private int maxSpeed;
    private boolean engineRunning;

    public Car(int totalForwardGear, String color, int maxSpeed) {
        this.totalForwardGear = totalForwardGear;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.engineRunning = false; // Mesin mobil dimulai dalam keadaan dimatikan
    }

    @Override
    public void move() {
        if (engineRunning) {
            System.out.println("Mobil sedang berakselerasi");
        } else {
            System.out.println("Silakan nyalakan mesin terlebih dahulu");
        }
    }

    public void startEngine() {
        if (!engineRunning) {
            System.out.println("Mesin mobil dinyalakan");
            playAudio("Audio/engine_sound.wav");
            engineRunning = true;
        } else {
            System.out.println("Mesin mobil sudah menyala");
        }
    }

    public void stopEngine() {
        if (engineRunning) {
            System.out.println("Mesin mobil dimatikan");
            engineRunning = false;
        } else {
            System.out.println("Mesin mobil sudah dimatikan");
        }
    }

    // Getters and setters car
    public int getTotalForwardGear() {
        return totalForwardGear;
    }

    public void setTotalForwardGear(int totalForwardGear) {
        this.totalForwardGear = totalForwardGear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }

    public void setEngineRunning(boolean engineRunning) {
        this.engineRunning = engineRunning;
    }
}