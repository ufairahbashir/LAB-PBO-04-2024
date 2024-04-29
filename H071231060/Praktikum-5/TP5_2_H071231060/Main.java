import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    public void displayInfo() {
        System.err.println("======================");
        System.out.println("Brand: " + brand);
        System.out.println("Series Number: " + seriesNumber);
        System.out.println("Price: $" + price);
    }
    public void displayInfo1(){
        System.err.println("============");
        System.out.println("Name Brand: "+ brand + ", Series Number: " + seriesNumber);
        
    }
}

class Smartphone extends Product {
    private double screenSize;
    private int storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + " GB");
    }
}

class Camera extends Product {
    private int resolution;
    private String lensType;

    public Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + " MP");
        System.out.println("Lens Type: " + lensType);
    }
}

class Laptop extends Product {
    private int ramSize;
    private String processorType;

    public Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("RAM Size: " + ramSize + " GB");
        System.out.println("Processor Type: " + processorType);
    }
}

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1-4): ");
            int choice = readInt();

            switch (choice) {
                case 1:
                addProduct(products);
                break;
                case 2:
                displayAllProducts(products);
                break;
                case 3:
                buyProduct(products);
                break;
                case 4:
                System.out.println("Terima kasih telah menggunakan layanan kami.");
                sc.close();
                System.exit(0);
                default:
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
            }
        }
    }
    
    private static void addProduct(ArrayList<Product> products) {
        System.out.println("Jenis Produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Kamera");
        System.out.println("3. Laptop");
        System.out.print("Pilih Jenis Produk: ");
        int productType = readInt();
        
        System.out.print("Merek: ");
        String brand = readLine();
        System.out.print("Nomor Seri: ");
        int seriesNumber = readInt();
        System.out.print("Harga: ");
        double price = readDouble();
        
        switch (productType) {
            case 1:
            System.out.print("Ukuran Layar (inci): ");
            double screenSize = readDouble();
            System.out.print("Kapasitas Penyimpanan (GB): ");
            int storageCapacity = readInt();
            products.add(new Smartphone(brand, seriesNumber, price, screenSize, storageCapacity));
            break;
            case 2:
            System.out.print("Resolusi (MP): ");
            int resolution = readInt();
            System.out.print("Tipe Lensa: ");
            String lensType = readLine();
            products.add(new Camera(brand, seriesNumber, price, resolution, lensType));
            break;
            case 3:
            System.out.print("Ukuran RAM (GB): ");
            int ramSize = readInt();
            System.out.print("Tipe Prosesor: ");
            String processorType = readLine();
            products.add(new Laptop(brand, seriesNumber, price, ramSize, processorType));
            break;
            default:
            System.out.println("Jenis produk tidak valid.");
        }
        System.out.println("Produk berhasil ditambahkan.");
        System.out.println();
    }
    
    private static void displayAllProducts(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
            return;
        }
        System.out.println("Daftar Produk:");
        for (Product product : products) {
            product.displayInfo();
            System.out.println();
        }
    }
    
    private static void buyProduct(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia untuk dibeli.");
            return;
        }
        System.out.println("Daftar Produk:");
        for (Product product : products) {
            product.displayInfo1();
            System.out.println();
        }
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int seriesNumber = readInt();
        
        boolean found = false;
        for (Product product : products) {
            if (product.seriesNumber == seriesNumber) {
                System.out.println("Anda telah membeli produk: ");
                product.displayInfo();
                found = true;
                System.out.println("=============================");
                System.out.println("Terima Kasih Telah berbelanja");
                System.out.println("=============================");
                break;
            }
        }
        if (!found) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
    
    static Scanner sc = new Scanner(System.in);
    public static int readInt() {
        while (true) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
                continue;
            } 
            try {
                int input = Integer.parseInt(next);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka");
            }
        }
    }


    public static String readLine() {
        String input = sc.nextLine();
        while (input.isEmpty() || containNumber(input)) {
            if (input.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
            } else {
                System.out.println("Tidak boleh ada angka");
            }
            input = sc.nextLine();
        }
        return input;
    }

    public static double readDouble() {
        while (true) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
                continue;
            } 
            try {
                double input = Double.parseDouble(next);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka");
            }
        }
    }

    public static boolean containNumber(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}