import java.util.Scanner;
import java.util.ArrayList;

class Product{
    String brand;
    String seriesNumber;
    double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    void displayInfo(){
        System.out.println("Brand : " + this.brand);
        System.out.println("Serial : " + this.seriesNumber);
        System.out.println("Price : " + this.price);
    }

    // inisiasi agar bisa dipanggil sama anak nya
    double info1(){
        return 0;
    }

    int info2(){
        return 0;
    }

    String info3(){
        return null;
    }

}

class Smartphone extends Product{
    double screenSize;
    int storageCapacity;

    public double info1() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int info2() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Screen : " + this.screenSize);
        System.out.println("Storage Capacity : " + this.storageCapacity);
    }

    // double getInfo1(){
    //     return this.screenSize;
    // }
}

class Camera extends Product{
    int resolution;
    String lensType;

    public int info2() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public String info3() {
        return lensType;
    }

    public void setLensType(String lensType) {
        this.lensType = lensType;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Resolution : " + resolution);
        System.out.println("Lens Type : " + lensType);
    }

    // void info(){
    //     resolution = (int) Soal02.inputUserAngka("Masukkan resolusi (MP) : ");
    //     lensType = Soal02.inputUserKosong("Masukkan tipe lensa : ");
    // }
}

class Laptop extends Product{
    int ramSize;
    String processorType;

    public int info2() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String info3() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Processor : " + processorType);
        System.out.println("RAM Size : " + ramSize + "GB");
    }

    // void info(){
        
    // }
}




public class Soal02 {
    static ArrayList<Product> list = new ArrayList<>();

    static double inputUserAngka(String tanya){
        Scanner input = new Scanner(System.in);
        double check;
        while (true) {
            System.out.print(tanya);
            String cek = input.nextLine().trim();
            if (cek.isEmpty()) {
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Inputan tidak boleh kosong");
            }
            else{
                try {
                    check = Integer.parseInt(cek);
                    if (check <= 0) {
                        System.out.printf("%s\n", "-".repeat(50));
                        System.out.println("Input tidak boleh nagatif ataupun bernilai 0");
                    }
                    else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Terjadi error karena " + e);
                }
            }
        }
        return check;
    }

    static String inputUserKosong(String tanya){
        Scanner input = new Scanner(System.in);
        String ans;
        while (true) {
            System.err.print(tanya);
            ans = input.next();
            if (ans.trim().isEmpty()) {
                System.out.println("-------------------------");
                System.out.println("Inputan tidak boleh kosong");
            }
            else{
                break;
            }
        }
        return ans;
    }

    static void set(Product product, String name, String seriesNumber, double price){
        product.setBrand(name);
        product.setSeriesNumber(seriesNumber);
        product.setPrice(price);
    }

    // menu pertama
    static Product tambah(){
        System.out.printf("%s\n","=".repeat(50));
        String name = inputUserKosong("Masukkan nama produk : ");
        String seriesNumber = inputUserKosong("Masukkan nomor seri : ");
        double price = inputUserAngka("Masukkan harga : ");
        System.out.println("Pilih tipe produk : \n1. Smartphone\n2. Laptop\n3. Camera");
        while (true) {
            int menu = (int) inputUserAngka("Pilih : ");
                if (menu >= 1 && menu <= 3) {
                    if (menu == 1) {
                        double screenSize = inputUserAngka("Masukkan ukuran layar (inci) : ");
                        int storageCapacity = (int) inputUserAngka("Masukkan kapasistas penyimpanan (GB) : ");
                        Smartphone obj = new Smartphone();
                        obj.setScreenSize(screenSize);
                        obj.setStorageCapacity(storageCapacity);
                        set(obj, name, seriesNumber, price);
                        return obj;
                    }
                    else if (menu == 2) {
                        int ramSize = (int) inputUserAngka("Masukkan kapasitas RAM (GB) : ");
                        String processorType = inputUserKosong("Masukkan tipe processor : ");
                        Laptop obj = new Laptop();
                        obj.setRamSize(ramSize);
                        obj.setProcessorType(processorType);
                        set(obj, name, seriesNumber, price);
                        return obj;
                    }
                    else if (menu == 3) {
                        int resolution = (int) inputUserAngka("Masukkan resolusi (MP) : ");
                        String lensType = inputUserKosong("Masukkan tipe lensa : ");
                        Camera obj = new Camera();
                        obj.setResolution(resolution);
                        obj.setLensType(lensType);
                        set(obj, name, seriesNumber, price);
                        return obj;
                    }
                }
                else{
                    System.out.printf("%s\n","=".repeat(50));
                    System.out.println("Invalid input");
                }
            }
        
    }

    //menu kedua
    static void tampil(){
        System.out.printf("%s\n","=".repeat(50));
        System.out.println("Daftar produk : ");

        for(int i = 0; i < list.size(); i++){ // info1 = double info2 = int info3 = string
            System.out.println("Produk " + (i+1) + " : ");
            System.out.println("Brand : " + list.get(i).getBrand());
            System.out.println("Serial Number : " + list.get(i).getSeriesNumber());
            System.out.println("Price : $" + list.get(i).getPrice());
            if (list.get(i) instanceof Smartphone) {
                System.out.println("Screen size : " + list.get(i).info1());
                System.out.println("Storage Capacity : " + list.get(i).info2());
            }
            else if (list.get(i) instanceof Laptop) {
                System.out.println("Resolution : " + list.get(i).info2());
                System.out.println("Lens Type : " + list.get(i).info3());
            }
            else if (list.get(i) instanceof Camera) {
                System.out.println("Ram size : " + list.get(i).info2());
                System.out.println("Processor Type : " + list.get(i).info3());
            }
            System.out.println();
        }
    }

    // menu ketiga
    static void beli(){
        String seriesNumber = inputUserKosong("Masukkan nomor seri produk yang ingin dibeli : ");
        for (Product i : list){
            if (i.getSeriesNumber().equals(seriesNumber)) {
                System.out.printf("%s\n","=".repeat(50));
                System.out.println("Anda telah membeli produk : ");
                System.out.println("Brand : " + i.getBrand());
                System.out.println("Serial Number : " + i.getSeriesNumber());
                System.out.println("Price : $" + i.getPrice());
                if (i instanceof Smartphone) {
                    System.out.println("Screen size : " + i.info1());
                    System.out.println("Storage Capacity : " + i.info2());
                }
                else if (i instanceof Laptop) {
                    System.out.println("Resolution : " + i.info2());
                    System.out.println("Lens Type : " + i.info3());
                }
                else if (i instanceof Camera) {
                    System.out.println("Ram size : " + i.info2());
                    System.out.println("Processor Type : " + i.info3());
                }
            }
            else{
                System.out.println("Produk dengan nomor seri tersebut tidak ditemukan");
            }
        }
    }

    static void Menu(){
        System.out.printf("%s\n","=".repeat(50));
        System.out.println("Menu :\n1. Tambah produk\n2. Tampilkan semua produk\n3. Beli produk\n4. Keluar");
    }




    public static void main(String[] args) {
        Menu();
        while (true) {
        int menu = (int) inputUserAngka("Pilih : ");
            if (menu >= 1 && menu <= 4) {
                if (menu == 1) {
                    list.add(tambah());
                    Menu();
                }
                else if (menu == 2) {
                    if (list.size() == 0) {
                        System.out.println("Daftar produk masih kosong");
                    }
                    else{
                        tampil();
                    }
                    Menu();
                }
                else if (menu == 3) {
                    if (list.size() == 0) {
                        System.out.println("Daftar produk masih kosong");
                    }
                    else{
                        beli();
                    }
                    Menu();
                }
                else{
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    System.exit(0);
                }
            }
            else{
                System.out.printf("%s\n","=".repeat(50));
                System.out.println("Invalid input");
            }
        }
        
    }
}
