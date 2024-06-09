package TP5_2_H071231079;

public class Camera extends Product{
    private int resolution;
    private String lensType;
    
    public Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public String getLensType() {
        return lensType;
    }

    public void setLensType(String lensType) {
        this.lensType = lensType;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Resolution       : " + getResolution());
        System.out.println("Lens Type        : " + getLensType());
    }
}