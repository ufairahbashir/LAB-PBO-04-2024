package TP5_2_H071231080;

import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Product> daftarDariProduk = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       menu(); 
    }

    private static void menu(){
        while(true){
            System.out.println("\n==================================");
            System.out.println("Menu : ");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar\n");
            System.out.print(">>> Pilih Menu (1-4)   : ");

            int pilihan = sc.nextInt();            
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    if (daftarDariProduk.isEmpty()){
                        System.out.println("Daftar Produk Kosong");
                    } else {
                        tampilkanProduk();
                    }
                    break;
                case 3:
                    beliProduk();
                    break;
                case 4:
                    System.out.println("Terimakasih telah menggunakan layanan kami. Sampai Jumpa!!");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static void tambahProduk(){
        String brand;
        do {
            System.out.print("Masukkan nama produk   : ");
            brand = sc.nextLine(); //menghapus Spasi
        } while (brand.isEmpty());

       
        int nomorSeri;
        System.out.print("Masukkan nomor Seri    : ");
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Nomor seri harus berupa angka");
                System.out.print("Masukkan nomor Seri: ");
                sc.next();
            }
            nomorSeri = sc.nextInt();
        } while (nomorSeri <= 0);


        int harga;
        System.out.print("Masukkan harga         : ");
        do{
            while (!sc.hasNextInt()) {
                System.out.println("Harga harus berupa angka");
                System.out.print("Masukkan Harga       : ");
                sc.next();   
            }
            harga = sc.nextInt();
        } while (harga == 0);

        System.out.println("Pilih tipe produk ");
        System.out.println("1. Smarthphone ");
        System.out.println("2. Camera ");
        System.out.println("3. Laptop ");
        System.out.print("Pilih tipe produk (1-3): ");

        int tipeProduk = sc.nextInt();
        sc.nextLine();
        switch (tipeProduk) {
            case 1:
                System.out.print("Masukkan ukuran layar (inci)  : ");
                double screenSize = sc.nextDouble();

                System.out.print("Masukkan kapasitas penyimpanan: ");
                int kapasitasPenyimpanan = sc.nextInt();

                daftarDariProduk.add(new Smartphone(screenSize, kapasitasPenyimpanan, brand, nomorSeri, harga));
                break;
            case 2:
                System.out.print("Masukkan resolusi kamera      : ");
                int resolusi = sc.nextInt();
        
                System.out.print("Masukkan tipe lensa           : ");
                sc.nextLine();
                String tipeLensa = sc.nextLine();

                daftarDariProduk.add(new Camera(resolusi, tipeLensa, brand, nomorSeri, harga));
                break;
            case 3:
                System.out.print("Masukkan tipe processor        : ");
                String jenisProcessor = sc.nextLine();

                System.out.print("Masukkan ukuran RAM            : ");
                int ukuranRAM = sc.nextInt();
        
                daftarDariProduk.add(new Laptop(ukuranRAM, jenisProcessor, brand, nomorSeri, harga));
                break;
                
            default:

                break;
        }
    }

    private static void tampilkanProduk(){
        System.out.println("\n==================================");
        System.out.println("\nDaftar Produk");
        for (Product produk : daftarDariProduk){
            produk.displayInfo();
        }
    }

    private static void beliProduk(){
        System.out.print("Masukkan nomor seri yang ingin dibeli: ");
        int nomorSeriYgdiBeli = 0;
        do{
            while (!sc.hasNextInt()) {
                System.out.println("Harga harus berupa angka");
                System.out.print("Masukkan nomor seri : ");
                sc.next();   
            }
            nomorSeriYgdiBeli = sc.nextInt();
        } while (nomorSeriYgdiBeli == 0);


        boolean found = false;
        for(Product nomor : daftarDariProduk){
            if(nomor.getSeriesNumber() == nomorSeriYgdiBeli){
                found = true;

                System.out.println("\n==================================");
                System.out.println("Anda telah membeli produk : ");
                nomor.displayInfo();
                System.out.println("\n==================================");
                System.out.println("TERIMAKASIH TELAH BERBELANJA");
                System.out.print("==================================\n");
                break;
            }
        }
        if(!found){
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan");
        }
    }
}

