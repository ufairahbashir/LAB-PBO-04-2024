package TP5_2_H071231079;

public class Product {
    private String brand;
    private int seriesNumber;
    private double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;

    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public int getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(int seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Brand            : " + getBrand());
        System.out.println("Serial Number    : " + getSeriesNumber());
        System.out.println("Price            : " + "$" + getPrice());
    }

    public void displayNamaNomor() {
        System.out.println("Brand            : " + getBrand());
        System.out.println("Serial Number    : " + getSeriesNumber());
    }
}