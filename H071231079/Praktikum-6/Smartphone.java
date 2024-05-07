import Move.Moveable;

public class Smartphone extends AudioPlayer implements Moveable {
    private int price;
    private String brand;
    private boolean isRinging;

    public Smartphone(int price, String brand) {
        this.price = price;
        this.brand = brand;
        this.isRinging = false; // Handphone dalam keadaan tidak berdering
    }

    @Override
    public void move() {
        System.out.println("Smartphone berpindah");
    }

    public void startPhone() {
        System.out.println("Handphone dinyalakan");
        playAudio("Audio/phone_ringtone.wav");
        isRinging = true;
    }

    public void stopPhone() {
        System.out.println("Handphone dimatikan");
        // stopSound();
        isRinging = false;
    }

    public void answerCall() {
        if (isRinging) {
            System.out.println("Menerima panggilan");
            isRinging = false;
        } else {
            System.out.println("Tidak ada panggilan masuk");
        }
    }

    // Getters and setters smartphone
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isRinging() {
        return isRinging;
    }
}
