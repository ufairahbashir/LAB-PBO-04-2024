import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    protected String brand;
    protected int seriesNumber;
    protected double price;

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Series Number: " + seriesNumber);
        System.out.println("Price: $" + price);
    }

    public void info2() {
        System.out.print("Brand: " + brand + " | " + "Series Number: " + seriesNumber);

    }
}

class Smartphone extends Product {
    protected double screenSize;
    protected int storageCapacity;
}

class Camera extends Product {
    protected int resolution;
    protected String lensType;
}

class Laptop extends Product {
    protected int ramSize;
    protected String processorType;
}

public class Produk {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    static void showMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");
            int choice = tangkisMenuKosong();

            switch (choice) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    tampilkanProduk();
                    break;
                case 3:
                    beliProduk();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void tambahProduk() {
        System.out.print("Masukkan nama produk: ");
        String brand = readString();
        System.out.print("Masukkan nomor seri: ");
        int seriesNumber = tangkisMenuKosong();
        System.out.print("Masukkan harga: ");
        double price = tangkisDoubleKosong();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print(">>> ");
        int tipeProduk = tangkisMenuKosong();

        switch (tipeProduk) {
            case 1:
                Smartphone smartphone = new Smartphone();
                System.out.print("Masukkan ukuran layar (inci): ");
                smartphone.screenSize = tangkisDoubleKosong();
                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                smartphone.storageCapacity = tangkisMenuKosong();
                smartphone.brand = brand;
                smartphone.seriesNumber = seriesNumber;
                smartphone.price = price;
                products.add(smartphone);
                break;
            case 2:
                Laptop laptop = new Laptop();
                System.out.print("Masukkan RAM: ");
                laptop.ramSize = tangkisMenuKosong();
                System.out.print("Masukkan prosesor: ");
                laptop.processorType = readString();
                laptop.brand = brand;
                laptop.seriesNumber = seriesNumber;
                laptop.price = price;
                products.add(laptop);
                break;
            case 3:
                Camera camera = new Camera();
                System.out.print("Masukkan resolusi layar: ");
                camera.resolution = tangkisMenuKosong();
                System.out.print("Masukkan tipe lensa: ");
                camera.lensType = readString();
                camera.brand = brand;
                camera.seriesNumber = seriesNumber;
                camera.price = price;
                products.add(camera);
                break;
            default:
                System.out.println("Tipe produk tidak valid.");
        }
        System.out.println("Produk berhasil ditambahkan.");
    }

    static void tampilkanProduk() {
        for (Product product : products) {
            product.displayInfo();
            if (product instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) product;
                System.out.println("Screen Size: " + smartphone.screenSize + " inches");
                System.out.println("Storage Capacity: " + smartphone.storageCapacity + " GB");
            } else if (product instanceof Laptop) {
                Laptop laptop = (Laptop) product;
                System.out.println("RAM Size: " + laptop.ramSize + " GB");
                System.out.println("Processor Type: " + laptop.processorType);
            } else if (product instanceof Camera) {
                Camera camera = (Camera) product;
                System.out.println("Resolution: " + camera.resolution + " MP");
                System.out.println("Lens Type: " + camera.lensType);
            }
            System.out.println();
        }
    }

    static void tampilkanProduk2() {
        for (Product product : products) {
            product.info2();
        }
    }

    static void beliProduk() {
        tampilkanProduk2();

        System.out.println("\nMasukkan nomor seri produk yang ingin dibeli: ");
        int seriesNumber = tangkisMenuKosong();
        boolean found = false;

        for (Product product : products) {
            if (product.seriesNumber == seriesNumber) {
                found = true;
                System.out.println("Informasi Produk:");
                System.out.println("=======================");
                System.out.println("Anda telah membeli produk ");
                product.displayInfo();
                System.out.println("=======================");
                System.out.println("Thanks");
                System.out.println("=======================");
                break;
            }
        }

        if (!found) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }

    public static String readString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong.");
            } else if (containsNumbers(input)) {
                System.out.println("Tidak boleh mengandung angka.");
            } else {
                return input;
            }
        }
    }

    public static boolean containsNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static int tangkisMenuKosong() {
        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Input jangan kosong.");
                continue;
            }

            try {
                int option = Integer.parseInt(input);
                return option;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public static double tangkisDoubleKosong() {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input jangan kosong.");
                continue;
            }

            input = input.replace(',', '.');

            try {
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }
}
