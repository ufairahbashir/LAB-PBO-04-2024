package TP4_2_H071231079;

import java.util.Scanner;
import java.util.ArrayList;
import TP4_2_H071231079.models.Produk;
import TP4_2_H071231079.utils.Inventori;
import TP4_2_H071231079.models.Pelanggan;

class AplikasiKasir {
    private Inventori inventori;
    private Scanner scanner;
    private ArrayList<Pelanggan> daftarPelanggan; // Definisikan ArrayList daftarPelanggan

    public AplikasiKasir() {
        inventori = new Inventori();
        scanner = new Scanner(System.in);
        daftarPelanggan = new ArrayList<>(); // Inisialisasi ArrayList daftarPelanggan
    }

    // Method 1
    public void jalankan() {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("   APLIKASI KASIR SEDERHANA");
            System.out.println("------------------------------");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Inventori");
            System.out.println("3. Beli Produk");
            System.out.println("4. Tambah Pelanggan");
            System.out.println("5. Daftar Pelanggan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda : ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();  // Buang newline

                switch (pilihan) {
                    case 1:
                        tambahProduk();
                        break;
                    case 2:
                        inventori.tampilkanInventori();
                        break;
                    case 3:
                        beliProduk();
                        break;
                    case 4:
                        tambahPelanggan();
                        break;
                    case 5:
                        System.out.println("------------------------------");
                        tampilkanDaftarPelanggan();
                        break;
                    case 6:
                        System.out.println("TERIMAKASIH SUDAH MENGGUNAKAN APLIKASI KASIR SEDERHANA");
                        System.out.println("------------------------------");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 6.");
                }
            } catch (Exception e) {
                System.out.println("Inputan tidak valid. Harap masukkan angka");
                scanner.nextLine();
            }
        }
    }

    // Method 2
    private void tambahProduk() {
        System.out.println("--------TAMBAH PRODUK--------");

        String id;
        while (true) {
            System.out.print("Masukkan ID Produk    : ");
            id = scanner.nextLine();
            if (id.isEmpty()) {
                System.out.println("ID Produk tidak boleh kosong. Silahkan coba lagi.");
            } else if (id.length() < 5) {
                System.out.println("ID Produk harus memiliki minimal 4 karakter.");
            } else {
                break;
            }
        }
        
        String nama;
        while (true) {
            System.out.print("Masukkan Nama Produk  : ");
            nama = scanner.nextLine();
            if (id.isEmpty()) {
                System.out.println("Nama Produk tidak boleh kosong. Silahkan coba lagi.");
            } else {
                break;
            }
        }

        double harga;
        while (true) {
            System.out.print("Masukkan Harga Produk : ");
            String inputHarga = scanner.nextLine();
            if (inputHarga.trim().isEmpty()) {
                System.out.println("Harga Produk tidak boleh kosong.");
                continue;
            }
            harga = Double.parseDouble(inputHarga);
            if (harga <= 0) {
                System.out.println("Harga Produk harus lebih dari 0.");
            } else {
                break;
            }
        }

        int stok;
        while (true) {
            System.out.print("Masukkan Stok Produk  : ");
            String stokProduk = scanner.nextLine();
            if (stokProduk.trim().isEmpty()) {
                System.out.println("Stok Produk tidak boleh kosong.");
                continue;
            }
            stok = Integer.parseInt(stokProduk);
            if (stok < 0) {
                System.out.println("Stok tidak boleh kurang dari  0.");
            } else {
                break;
            }
        }

        Produk produkBaru = new Produk(id, nama, harga, stok);
        inventori.tambahProduk(produkBaru);
        System.out.println("Produk berhasil ditambahkan!");
    }

    // Method 3
    private void beliProduk() {
        System.out.println("---------BELI PRODUK---------");
        System.out.print("Masukkan ID Produk    : ");
        String id = scanner.nextLine();
        Produk produk = inventori.cariProdukById(id);
        if (produk != null) {
            if (produk.getStok() > 0) {
                System.out.print("Masukkan Jumlah       : ");
                int jumlah = scanner.nextInt();
                if (jumlah <= produk.getStok()) {
                    double total = jumlah * produk.getHarga();
                System.out.println("Total Harga           : Rp" + total);
                    produk = inventori.cariProdukById(id);  // Refresh produk dari inventori
                    produk.setStok(produk.getStok() - jumlah);  // Update stok
                    System.out.println("Pembelian berhasil!");
                } else {
                    System.out.println("Stok tidak mencukupi!");
                }
            } else {
                System.out.println("Produk habis!");
            }
        } else {
            System.out.println("Produk tidak ditemukan!");
        }
    }

    //Method 4
    private void tambahPelanggan() {
        System.out.println("--------TAMBAH PELANGGAN--------");

        String nama;
        while (true) {
            System.out.print("Masukkan Nama Pelanggan  : ");
            nama = scanner.nextLine();
            if (nama.isEmpty()) {
                System.out.println("Nama Pelanggan tidak boleh kosong. Silahkan coba lagi.");
            } else {
                break;
            }
        }

        String email;
        while (true) {
            System.out.print("Masukkan Email Pelanggan : ");
            email = scanner.nextLine();
            if (!email.contains("@gmail.com")) {
                System.out.println("Email tidak valid. Mohon masukkan email yang valid.");
            } else {
                break;
            }
        }

        Pelanggan pelangganBaru = new Pelanggan(nama, email);
        daftarPelanggan.add(pelangganBaru);
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    // Method 5
    private void tampilkanDaftarPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Daftar Pelanggan kosong.");
        } else {
            System.out.println("Daftar Pelanggan : ");
            for (Pelanggan p : daftarPelanggan) {
                p.tampilkanDetailPelanggan();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AplikasiKasir app = new AplikasiKasir();
        app.jalankan();
    }
}