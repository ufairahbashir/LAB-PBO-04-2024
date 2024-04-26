package TP5_2_H071231080;


public class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("\nBrand            : " + brand);
        System.out.println("Serial Number    : " + seriesNumber);
        System.out.println("Price            : " + price);
    }
    public int getSeriesNumber() {
        return seriesNumber;
    }

}

class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    public Smartphone(double screenSize, int storageCapacity, String brand, int nomorSeri, double price) {
        super(brand, nomorSeri, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size      : " + this.screenSize);
        System.out.println("Storage Capacity : " + this.storageCapacity + "GB");
    }
}

class Camera extends Product {
    int resolution;
    String lensType;

    public Camera(int resolution, String lensType, String brand, int nomorSeri, double price) {
        super(brand, nomorSeri, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution       : " + this.resolution + "MP");
        System.out.println("Lens Type        : " + this.lensType );
    }
}

class Laptop extends Product {
    int ramSize;
    String processorType;

    public Laptop(int ramSize, String processorType, String brand, int nomorSeri, double price) {
        super(brand, nomorSeri, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("RAM Sizw         : " + this.ramSize + "inchies");
        System.out.println("Processor        : " + this.processorType + "GB");
    }
}