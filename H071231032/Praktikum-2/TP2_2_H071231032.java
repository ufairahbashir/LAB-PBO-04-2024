import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Product {
    private int harga, stok;
    private String ID, nama;

    void setID(Scanner sc) {
        while (true) {
            try {
                System.out.println("Pilih jenis produk untuk menentukan ID produk:\n1. Makanan\n2. Minuman\n3. Snack");
                String test = sc.nextLine().strip();
                int opsi = Integer.parseInt(test);

                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyddMMHH");
                
                if (opsi == 1) { this.ID = "FD" + dateTime.format(formatDateTime); }
                else if (opsi == 2) { this.ID = "BV" + dateTime.format(formatDateTime); }
                else if (opsi == 3){ this.ID = "SN" + dateTime.format(formatDateTime); }
                else { System.out.println("Hanya tersedia 3 opsi.\n"); continue; }

                System.out.println("\nID produk berhasil ditentukan.");
                break;
            } catch (NumberFormatException e) { System.out.println("Input harus integer.\n"); }
        }
    }

    String getID() {
        return this.ID;
    }

    void setNama(Scanner sc) {
        System.out.print("Masukkan nama produk: ");
        this.nama = sc.nextLine().strip().toUpperCase();

        System.out.println("\nNama produk berhasil ditentukan.");
    }

    String getNama() {
        return this.nama;
    }
    
    void setHarga(Scanner sc) {
        while (true) {
            try {
                System.out.print("Masukkan harga produk: ");
                String test = sc.nextLine();
                this.harga = Integer.parseInt(test);

                if (harga < 100) { System.out.println("Harga produk harus lebih dari Rp 100.\n"); continue; }
                else { System.out.println("\nHarga berhasil ditentukan."); break; }
            } catch (NumberFormatException e) {
                System.out.println("Harga harus integer.\n");
            }
        }
    }

    String getHarga() {
        DecimalFormat df = new DecimalFormat("#,###.##");
        String hargaFormat = "IDR " + df.format(this.harga).replace(',', '.');

        return hargaFormat;
    }

    void setStok(Scanner sc) {
        while (true) {
            try {
                System.out.print("Masukkan jumlah stok produk: ");
                String test = sc.nextLine();
                this.stok = Integer.parseInt(test);

                if (stok >= 0) { System.out.println("\nStok produk berhasil ditentukan."); break; }
                else { System.out.println("Jumlah stok produk harus 0 atau lebih.\n"); }
            } catch (NumberFormatException e) {
                System.out.println("Stok harus integer.\n");
            }
        }
    }

    int getStok() {
        return this.stok;
    }

    void cetakDetailProduk(String[] dataProduk) {
        System.out.println("=".repeat(40)+ "\nID Produk    : " + dataProduk[0] + "\nNama produk  : " + dataProduk[1] +
                            "\nHarga produk : " + dataProduk[2] + "\nStok produk  : " + dataProduk[3] + "\n" + "=".repeat(40));
    }
}

public class TP2_2_H071231032 {
    public static void main(String[] args) {
        Product TokoMks = new Product();
        String[] dataProduk = new String[4];

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    String garis = "=".repeat(50);
                    System.out.println(garis + "\n" + " ".repeat(18) +"Selamat Datang" + " ".repeat(18) + "\n" + garis +
                                    "\nSilakan pilih opsi:" + "\n1. Tentukan ID Produk\n2. Tentukan Nama Produk\n3. Tentukan Harga Produk" +
                                    "\n4. Tentukan Stok Produk\n5. Cek Stok Produk\n6. Lihat Detail Produk\n7. Keluar");
                    String test = sc.nextLine();
                    int opsi = Integer.parseInt(test);

                    if (opsi == 1) {
                        System.out.println(garis);
                        TokoMks.setID(sc); dataProduk[0] = TokoMks.getID();

                    } else if (opsi == 2) {
                        System.out.println(garis);
                        TokoMks.setNama(sc); dataProduk[1] = TokoMks.getNama();

                    } else if (opsi == 3) {
                        System.out.println(garis);
                        TokoMks.setHarga(sc); dataProduk[2] = TokoMks.getHarga();

                    } else if (opsi == 4) {
                        System.out.println(garis);
                        TokoMks.setStok(sc); dataProduk[3] = Integer.toString(TokoMks.getStok());
                        
                    } else if (opsi == 5) {
                        if (dataProduk[3] == null) { System.out.println(garis + "\nStok produk belum ditentukan."); continue; }

                        int stok = TokoMks.getStok();
                        if (stok == 0) { System.out.println(garis + "\nStok produk tidak tersedia."); }
                        else { System.out.printf(garis + "\nStok produk tersedia sebanyak %d pcs.\n", stok); }

                    } else if (opsi == 6) {
                        System.out.println(garis);
                        TokoMks.cetakDetailProduk(dataProduk);

                    } else if (opsi == 7) {
                        System.out.println(garis + "\n" + " ".repeat(19) + "Terima Kasih" +
                                        " ".repeat(19) + "\n" + garis); break;

                    } else { System.out.println("\nHanya ada 7 opsi."); }

                } catch (NumberFormatException e) { System.out.println("\nInput harus integer."); }
            }
        }
    }
}