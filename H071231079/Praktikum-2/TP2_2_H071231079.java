package TP2;
import java.util.Scanner;

class Produk {
    String id, nama;
    int stok, harga;

    public void checking() {
        System.out.println("ID Produk \t: " + this.id);
        System.out.println("Nama Produk \t: " + this.nama);
        System.out.println("Stok \t\t: " + this.stok);
        System.out.print("Harga \t\t: " + this.harga);
    }

    String checkStok() {
        if (this.stok > 0) {
            return "Produk " + this.nama + " tersedia di stok.";
        } else {
            return "Produk " + this.nama + " tidak tersedia di stok.";
        }
    }
}

public class TP2_2_H071231079 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Produk produk1 = new Produk();

        // produk1.id = "ABY178632";
        // produk1.nama = "Abaya";
        // produk1.stok = 213;
        // produk1.harga = 412.000;

        try {
            System.out.print("Masukkan ID Produk    : ");
            produk1.id = scan.nextLine();

            System.out.print("Masukkan Nama Produk  : ");
            produk1.nama = scan.nextLine();

            System.out.print("Masukkan Stok Produk  : ");
            produk1.stok = scan.nextInt();

            System.out.print("Masukkan Harga Produk : ");
            produk1.harga = scan.nextInt();
        } catch (Exception e) {
            System.out.print("Input tidak valid.");
        } finally {
            scan.nextLine();
        }

        boolean running = true; //kontrol henti program
        while (running) {
            System.out.println("MENU");
            System.out.println("1. Cek Data Produk");
            System.out.println("2. Cek Ketersediaan Produk");
            System.out.println("3. Keluar");
            System.out.println("Pilih Menu :");
            int menu = scan.nextInt();

            switch (menu) {
                case 1 :
                System.out.println("----------------------------------------");
                    produk1.checking();
                    break;
                case 2 :
                    System.out.println("----------------------------------------");
                    System.out.println(produk1.checkStok());
                    break;
                case 3 :
                    System.out.println("Terimakasih!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scan.close();

    }
}