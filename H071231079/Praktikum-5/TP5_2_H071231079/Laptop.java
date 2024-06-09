package TP5_2_H071231079;

public class Laptop extends Product{
    private int ramSize;
    private String processorType;
    
    public Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("RAM Size         : " + getRamSize());
        System.out.println("Processor Type   : " + getProcessorType());
    }
}