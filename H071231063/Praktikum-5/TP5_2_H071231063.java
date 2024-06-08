import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Kelas untuk merepresentasikan produk elektronik
class Produk {
    String merek;
    int nomorSeri;
    double harga;

    // Konstruktor
    public Produk(String merek, int nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    // Metode untuk menampilkan informasi produk
    void tampilkanInfo() {
        System.out.println("Brand: " + merek);
        System.out.println("Serial Number " + nomorSeri);
        System.out.println("Price: $" + harga);
    }
}

// Kelas untuk merepresentasikan smartphone
class Smartphone extends Produk {
    double ukuranLayar;
    int kapasitasPenyimpanan;

    // Konstruktor
    public Smartphone(String merek, int nomorSeri, double harga, double ukuranLayar, int kapasitasPenyimpanan) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    // Implementasi metode untuk menampilkan informasi produk smartphone
    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Screen Size: " + ukuranLayar + " inches");
        System.out.println("Strotage Capacity: " + kapasitasPenyimpanan + " GB");
    }
}

// Kelas untuk merepresentasikan kamera
class Kamera extends Produk {
    int resolusi;
    String tipeLensa;

    // Konstruktor
    public Kamera(String merek, int nomorSeri, double harga, int resolusi, String tipeLensa) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.tipeLensa = tipeLensa;
    }

    // Implementasi metode untuk menampilkan informasi produk kamera
    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolution: " + resolusi + " MP");
        System.out.println("Lens type: " + tipeLensa);
    }
}

// Kelas untuk merepresentasikan laptop
class Laptop extends Produk {
    int ukuranRAM;
    String tipeProsesor;

    // Konstruktor
    public Laptop(String merek, int nomorSeri, double harga, int ukuranRAM, String tipeProsesor) {
        super(merek, nomorSeri, harga);
        this.ukuranRAM = ukuranRAM;
        this.tipeProsesor = tipeProsesor;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor Type: " + tipeProsesor);
        System.out.println("Ram Size: " + ukuranRAM + "GB");
    }
}

// Kelas untuk mengelola stok produk
public class TP5_2_H071231063 {
    private ArrayList<Produk> stokProduk = new ArrayList<>();

    // Metode untuk menambahkan produk ke dalam stok toko
    public void tambahProduk(Produk produk) {
        stokProduk.add(produk);
    }

    // Metode untuk menampilkan semua produk yang ada di toko
    public void tampilkanSemuaProduk() {
        if (stokProduk.isEmpty()) {
            System.out.println("Stok toko kosong.");
        } else {
            System.out.println("Daftar Produk:");
            for (Produk produk : stokProduk) {
                produk.tampilkanInfo();
                System.out.println();
            }
        }
    }

    // Metode untuk membeli produk dari toko
    public void beliProduk(int nomorSeri) {
        boolean found = false;
        for (Produk produk : stokProduk) {
            if (produk.nomorSeri == nomorSeri) {
                found = true;
                System.out.println("\nAnda telah membeli produk: ");
                produk.tampilkanInfo();
                break;
            }
        }
        if (!found) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TP5_2_H071231063 toko = new TP5_2_H071231063();
    
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");
    
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Masukkan pilihan dalam bentuk angka (1-4).");
                scanner.nextLine();
                pilihan = 0;
                continue; 
            }
    
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    String merek = scanner.nextLine();
    
                    System.out.print("Masukkan nomor seri: ");
                    int nomorSeri;
                    while (true) {
                        try {
                            nomorSeri = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Nomor seri harus dalam format angka.");
                            scanner.nextLine(); 
                            System.out.print("Masukkan nomor seri: ");
                        }
                    }
    
                    System.out.print("Masukkan harga: ");
                    double harga;
                    while (true) {
                        try {
                            harga = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Harga harus dalam format angka.");
                            scanner.nextLine(); // membersihkan newline dari buffer
                            System.out.print("Masukkan harga: ");
                        }
                    }
    
                    System.out.println("Pilih tipe produk:");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Kamera");
                    System.out.println("3. Laptop");
                    System.out.print("\nPilih tipe produk (1-3): ");
                    int tipe;
                    while (true) {
                        try {
                            tipe = scanner.nextInt();
                            scanner.nextLine(); // membersihkan newline setelah nextInt()
                            break; // keluar dari loop setelah input valid
                        } catch (InputMismatchException e) {
                            System.out.println("Pilihan harus dalam format angka.");
                            scanner.nextLine(); // membersihkan newline dari buffer
                            System.out.print("Pilih tipe produk (1-3): ");
                        }
                    }
    
                    switch (tipe) {
                        case 1:
                            System.out.print("Masukkan ukuran layar (inci): ");
                            double ukuranLayar;
                            while (true) {
                                try {
                                    ukuranLayar = scanner.nextDouble();
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Ukuran harus dalam format angka.");
                                    scanner.nextLine();
                                    System.out.print("Masukkan ukuran layar: ");
                                }
                            }
    
                            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                            int kapasitasPenyimpanan;
                            while (true) {
                                try {
                                    kapasitasPenyimpanan = scanner.nextInt();
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Ukuran harus dalam format angka.");
                                    scanner.nextLine();
                                    System.out.print("Masukkan ukuran layar: ");
                                }
                            }
                            toko.tambahProduk(new Smartphone(merek, nomorSeri, harga, ukuranLayar, kapasitasPenyimpanan));
                            break;
    
                        case 2:
                            System.out.print("Masukkan resolusi (MP): ");
                            int resolusi;
                            while (true) {
                                try {
                                    resolusi = scanner.nextInt();
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Resolusi harus dalam format angka.");
                                    scanner.nextLine();
                                    System.out.print("Masukkan resolusi: ");
                                }
                            }
                            System.out.print("Masukkan tipe lensa: ");
                            String tipeLensa = scanner.nextLine();
                            
                            toko.tambahProduk(new Kamera(merek, nomorSeri, harga, resolusi, tipeLensa));
                            break;
    
                        case 3:
                            System.out.print("Masukkan ukuran RAM (GB): ");
                            int ukuranRAM;
                            while (true) {
                                try {
                                    ukuranRAM = scanner.nextInt();
                                    scanner.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Resolusi harus dalam format angka.");
                                    scanner.nextLine();
                                    System.out.print("Masukkan ukuran RAM: ");
                                }
                            }

                            System.out.print("Masukkan tipe prosesor: ");
                            String tipeProsesor = scanner.nextLine();
                            
                            toko.tambahProduk(new Laptop(merek, nomorSeri, harga, ukuranRAM, tipeProsesor));
                            break;
    
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                    break;
    
                case 2:
                    toko.tampilkanSemuaProduk();
                    break;
    
                case 3:
                    System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                    int nomorSeriBeli;
                    while (true) {
                        try {
                            nomorSeriBeli = scanner.nextInt();
                            scanner.nextLine();
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println("Nomor seri harus dalam format angka.");
                            scanner.nextLine(); 
                            System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                        }
                    }
    
                    toko.beliProduk(nomorSeriBeli);
                    break;
    
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;
    
                default:
                    System.out.println("Pilihan tidak valid.");
            }
    
        } while (pilihan != 4);
        
        scanner.close();
    }
}    