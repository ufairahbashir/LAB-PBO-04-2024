import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TP5_2_H071231032 {
    private static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            runApp(sc);
        }
    }

    private static void runApp(Scanner sc) {
        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Tampilkan Semua Produk");
                System.out.println("3. Beli Produk");
                System.out.println("4. Keluar");
                System.out.print(">>> Pilih menu (1-4): ");

                int opsi = sc.nextInt();
                sc.nextLine();

                if ((opsi == 2 || opsi == 3) && productList.isEmpty()) {
                    System.out.println("Daftar produk kosong.\n");
                    continue;
                }

                if (opsi == 1) { addProduct(sc); }
                else if (opsi == 2) { showAllProducts(); }
                else if (opsi == 3) { buyProduct(sc); }
                else if (opsi == 4) {
                    System.out.println("\nTerima kasih telah menggunakan layanan kami.");
                    System.out.println("Sampai Jumpa!\n");
                    break;
                } else { System.out.println("Hanya tersedia opsi 1-4.\n"); }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.\n");
                sc.nextLine();
            }
        }
    }

    private static void addProduct(Scanner sc) {
        System.out.print("\nMasukkan nama produk       : ");
        String brand = sc.nextLine();

        int seriesNumber;
        while (true) {
            try {
                System.out.print("Masukkan nomor seri produk : ");
                String test = sc.nextLine();

                if (test.length() < 5 || test.length() > 5 || test.startsWith("0")) {
                    System.out.println("Nomor seri produk harus 5 digit dan tidak diawali dengan angka 0 (nol).\n");
                    continue;
                }

                seriesNumber = Integer.parseInt(test);
                boolean isAvail = true;

                if (!productList.isEmpty()) {
                    for (Product i : productList) {
                        if (i.getSeriesNumber() == seriesNumber) {
                            System.out.println("Nomor seri tersebut telah digunakan.\n");
                            isAvail = false;
                            break;
                        }
                    }
                }

                if (!isAvail) continue;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nomor seri harus integer.\n");
            }
        }

        double price;
        while (true) {
            try {
                System.out.print("Masukkan harga produk ($)  : ");
                price = sc.nextDouble();
                sc.nextLine();

                if (price <= 1) {
                    System.out.println("Harga harus lebih dari $1.\n");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("Harga harus angka.\n");
                sc.nextLine();
            }
        }

        int opsi;
        while (true) {
            try {
                System.out.println("Tipe produk:");
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");
                System.out.print(">>> Pilih tipe produk (1-3): ");

                opsi = sc.nextInt();
                sc.nextLine();

                if (opsi < 1 || opsi > 3) {
                    System.out.println("Hanya tersedia opsi 1-3.\n");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.\n");
                sc.nextLine();
            }
        }

        if (opsi == 1) { // Smartphone
            double screenSize;
            while (true) {
                try {
                    System.out.print("Masukkan ukuran layar produk (inci)       : ");
                    screenSize = sc.nextDouble();
                    sc.nextLine();

                    if (screenSize <= 1) {
                        System.out.println("Ukuran layar harus lebih dari 1 inci.\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ukuran layar harus angka.\n");
                    sc.nextLine();
                }
            }

            int storageCapacity;
            while (true) {
                try {
                    System.out.print("Masukkan kapasitas penyimpanan produk (GB): ");
                    storageCapacity = sc.nextInt();
                    sc.nextLine();

                    if (storageCapacity < 32) {
                        System.out.println("Kapasitas penyimpanan harus 32GB atau lebih.\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Kapasitas penyimpanan harus integer.\n");
                    sc.nextLine();
                }
            }

            Smartphone smartphone = new Smartphone(
                    brand, seriesNumber, price, screenSize, storageCapacity
            );
            productList.add(smartphone);

        } else if (opsi == 2) { // Laptop
            int ramSize;
            while (true) {
                try {
                    System.out.print("Masukkan ukuran RAM produk (GB): ");
                    ramSize = sc.nextInt();
                    sc.nextLine();

                    if (ramSize < 4) {
                        System.out.println("Ukuran RAM harus 4GB atau lebih.\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("RAM harus integer.\n");
                    sc.nextLine();
                }
            }

            String processorType;
            System.out.print("Masukkan tipe prosesor produk  : ");
            processorType = sc.nextLine();

            Laptop laptop = new Laptop(
                    brand, seriesNumber, price, ramSize, processorType
            );
            productList.add(laptop);

        } else { // Camera
            int resolution;
            while (true) {
                try {
                    System.out.print("Masukkan ukuran resolusi produk (MP): ");
                    resolution = sc.nextInt();
                    sc.nextLine();

                    if (resolution < 8) {
                        System.out.println("Ukuran resolusi harus 8MP atau lebih.\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Resolusi harus integer.\n");
                    sc.nextLine();
                }
            }

            String lensType;
            System.out.print("Masukkan tipe lensa produk          : ");
            lensType = sc.nextLine();

            Camera camera = new Camera(
                    brand, seriesNumber, price, resolution, lensType
            );
            productList.add(camera);
        }

        System.out.println("\nProduk berhasil ditambahkan.\n");
    }

    private static void showAllProducts() {
        System.out.println("\n" + "-".repeat(61));
        System.out.println(" ".repeat(20) + "=== Daftar Produk ===");

        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).displayInfo();
             if (i < productList.size()-1) System.out.println();
        }

        System.out.println("-".repeat(61) + "\n");
    }

    private static void buyProduct(Scanner sc) {
        showAllProducts();

        int seriesNumber;
        while (true) {
            try {
                System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                String test = sc.nextLine();

                if (test.length() < 5 || test.length() > 5 || test.startsWith("0")) {
                    System.out.println("Nomor seri produk harus 5 digit dan tidak diawali dengan angka 0 (nol).\n");
                    continue;
                }

                seriesNumber = Integer.parseInt(test);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nomor seri harus integer.\n");
            }
        }

        boolean isAvail = false;
        for (int i = 0; i < productList.size(); i++) {
            if (seriesNumber == productList.get(i).getSeriesNumber()) {
                System.out.println("\nAnda telah membeli produk:");
                productList.get(i).displayInfo();
                productList.remove(i);
                isAvail = true;
                break;
            }
        }
        if (!isAvail) System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        System.out.println();
    }
}

class Product {
    protected String brand;
    protected int seriesNumber;
    protected double price;

    protected void displayInfo() {
        System.out.printf("Brand            : %s\n", this.brand);
        System.out.printf("Serial Number    : %d\n", this.seriesNumber);
        System.out.printf("Price            : $%.2f\n", this.price);
    };

    public int getSeriesNumber() {
        return this.seriesNumber;
    }
}

class Smartphone extends Product {
    private double screenSize;
    private int storageCapacity;

    public Smartphone (String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.printf("Screen Size      : %.1f inches\n", this.screenSize);
        System.out.printf("Storage Capacity : %dGB\n", this.storageCapacity);
    }
}

class Camera extends Product {
    private int resolution;
    private String lensType;

    public Camera (String brand, int seriesNumber, double price, int resolution, String lensType) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.printf("Resolution       : %dMP\n", this.resolution);
        System.out.printf("Lens Type        : %s\n", this.lensType);
    }
}

class Laptop extends Product {
    private int ramSize;
    private String processorType;

    public Laptop (String brand, int seriesNumber, double price, int ramSize, String processorType) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.printf("Processor Type   : %s\n", this.processorType);
        System.out.printf("RAM Size         : %dGB\n", this.ramSize);
    }
}