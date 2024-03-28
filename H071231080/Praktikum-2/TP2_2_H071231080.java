import java.util.Scanner;

class Market {
    String idProduk;
    String nama;
    int stok;
    double  harga;
    
    
    public String cekStok() {
        if (stok > 0) {
            return "Produk " + nama + " tersedia dalam stok sebanyak " + stok + " unit.";
        } else {
            return "Produk " + nama + " tidak tersedia dalam stok.";
        }
    }
    
       
    public String toString() {
        return "ID Produk: " + idProduk + "\nNama: " + nama + "\nStok: " + stok + "\nHarga: " + harga;
    }  
}

public class TP2_2_H071231080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        Market produk = new Market();

        System.out.print("Masukkan ID Produk:");
        produk.idProduk = scanner.nextLine();

        System.out.print("Masukkan Nama Produk:");
        produk.nama = scanner.nextLine();

        System.out.print("Masukkan Stok Produk:");
        produk.stok = scanner.nextInt();

        System.out.print("Masukkan Harga Produk:");
        produk.harga = scanner.nextDouble();

      
        System.out.println(produk.toString());
        System.out.println(produk.cekStok());

        scanner.close();
    }
}
    
    