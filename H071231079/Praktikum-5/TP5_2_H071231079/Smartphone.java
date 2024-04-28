package TP5_2_H071231079;

public class Smartphone extends Product{
    private double screenSize;
    private int storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Screen Size      : " + getScreenSize() + " inches");
        System.out.println("Storage Capacity : " + getStorageCapacity() + " 64");
    }
}