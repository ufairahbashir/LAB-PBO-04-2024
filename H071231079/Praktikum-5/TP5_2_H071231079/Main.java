package TP5_2_H071231079;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private ArrayList<Product> produk;
    private Scanner sc;

    //Konstruktor
    public Main() {
        produk = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // Input dan validasi inputan bertipe data double
    public static double inputDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine();
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        }
    }

    // Input dan validasi inputan bertipe data integer
    public static int inputInt(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine();
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        }
    }

    // Input dan validasi inputan bertipe data string
    public static String inputString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
            } else {
                return input;
            }
        }
    }    

    // Method jalankan program
    public void jalankan() {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("             MENU");
            System.out.println("------------------------------");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar\n");
            System.out.print(">> Pilih menu (1-4) : ");

            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
                    continue;
                }

                int opsi = Integer.parseInt(input);
                
                // Lakukan validasi range menu di sini
                if (opsi < 1 || opsi > 4) {
                    System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 4.");
                    continue;
                }

                switch (opsi) {
                    case 1:
                        tambahProduk();
                        break;
                    case 2:
                        tampilkanDaftarProduk();
                        break;
                    case 3:
                        beliProduk();
                        break;
                    case 4:
                        System.out.println("---------------------------------------------------------");
                        System.out.println("TERIMAKASIH TELAH MENGGUNAKAN LAYANAN KAMI. SAMPAI JUMPA!");
                        System.out.println("---------------------------------------------------------");
                        sc.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka sebagai pilihan. Silahkan coba lagi.");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan. Silahkan coba lagi.");
                sc.nextLine(); // Membersihkan input buffer
            }
        }
    }

    //Method Tambah Produk
    private void tambahProduk() {
        System.out.println("--------TAMBAH PRODUK--------");

         // Input dan validasi merek
        String merek;
        while (true) {
            System.out.print("Masukkan Merek Produk      : ");
            merek = sc.nextLine();
            if (merek.isEmpty()) {
                System.out.println("Merek Produk tidak boleh kosong. Silahkan coba lagi.");
            } else {
                break;
            }
        }

         // Input dan validasi nomor seri
        int nomorSeri = inputInt(sc, "Masukkan Nomor Seri Produk : ");

        // Input dan validasi harga
        double harga = inputDouble(sc, "Masukkan Harga Produk      : ");

        //Method Pilihan Jenis Produk
        boolean validInput = false;
        while (!validInput) {
            System.out.println("-----------------------------");
            System.out.println("------PILIH TIPE PRODUK------");
            System.out.println("1. Smartphone");
            System.out.println("2. Laptop");
            System.out.println("3. Camera");
            System.out.print(">> Pilih tipe produk (1-3) : ");

            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
                    continue;
                }
            
                int tipe = Integer.parseInt(input);
                    
                // Lakukan validasi range menu di sini
                if (tipe < 1 || tipe > 4) {
                    System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 4.");
                    continue;
                }
            
                switch (tipe) {
                    case 1: // Smartphone
                        // Input dan validasi ukuran layar
                        double screenSize = inputDouble(sc, "Masukkan Ukuran Layar (inch)        : ");
            
                        // Input dan validasi kapasitas penyimpanan
                        int storageCapacity = inputInt(sc, "Masukkan Kapasitas Penyimpanan (GB) : ");
            
                        // Membuat objek Smartphone dan menambahkannya ke dalam array produk
                        produk.add(new Smartphone(merek, nomorSeri, harga, screenSize, storageCapacity));
                        break;
            
                    case 2: // Laptop
                        // Input dan validasi ukuran RAM
                        int ramSize = inputInt(sc, "Masukkan Ukuran RAM (GB) : ");
            
                        // Input dan validasi tipe prosesor
                        String processorType = inputString(sc, "Masukkan Tipe Prosesor   : ");
            
                        // Membuat objek Laptop dan menambahkannya ke dalam array produk
                        produk.add(new Laptop(merek, nomorSeri, harga, ramSize, processorType));
                        break;
            
                    case 3: // Camera
                        // Input dan validasi resolusi kamera
                        int resolution = inputInt(sc, "Masukkan Resolusi Kamera (MP) : ");
            
                        // Input dan validasi tipe lensa
                        String lensType = inputString(sc, "Masukkan Tipe Lensa           : ");
            
                        // Membuat objek Camera dan menambahkannya ke dalam array produk
                        produk.add(new Camera(merek, nomorSeri, harga, resolution, lensType));
                        break;
            
                    default:
                        System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 3.");
                        break;
                }
                validInput = true; // Jika input dan pemrosesan tipe produk sukses, set validInput ke true
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka sebagai pilihan. Silahkan coba lagi.");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan. Silahkan coba lagi.");
                sc.nextLine(); // Membersihkan input buffer
            }
        }
        return;
    }
        
    //Method Tampilkan Semua Produk
    public void tampilkanDaftarProduk() {
        System.out.println("--------DAFTAR PRODUK--------");
        if (produk.size() ==  0)  {
            System.out.println("Tidak ada produk dalam daftar.");
        } else {
            for (Product p : produk) {
                p.displayInfo();
                System.out.println();
            }
        }
    }

    //Method cari produk by nomor seri
    public Product findProductBySeriesNum(int nomorSeri) {
        for (Product p : produk) {
            if (p.getSeriesNumber() == nomorSeri) {
                return p;
            }
        }
        return null;
    }

    //Method Beli Produk
    public void beliProduk() {
        System.out.println("-------PRODUK TERSEDIA--------");
        if (produk.size() ==  0)  {
            System.out.println("Tidak ada produk tersedia.");
        } else {
            for (Product p : produk) {
                p.displayNamaNomor();;
                System.out.println();
            }
        }

        System.out.println("----------BELI PRODUK---------");
        // Input dan validasi nomer seri
        int nomorSeri = inputInt(sc, "Masukkan nomor seri produk yang ingin di beli : ");
        
        Product foundProduct = findProductBySeriesNum(nomorSeri);
        
        // Lakukan pengecekan apakah produk ditemukan atau tidak
        if (foundProduct != null) {
            System.out.println("Anda telah membeli produk : ");
            foundProduct.displayInfo();
            System.out.println("------------------------------");
            System.out.println(" TERIMAKASIH TELAH BERBELANJA");
            System.out.println("------------------------------");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }
}

class TP5_2_H071231079 {
    public static void main(String[] args) {
        Main shop = new Main();
        shop.jalankan();
    }
}