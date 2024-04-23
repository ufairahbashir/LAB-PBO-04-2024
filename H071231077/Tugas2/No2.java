class Produk {
    int id;
    String nama;
    int harga;
    int stok;
    int sisaStok;

    void cekStok (int jumlahdibeli){
        if (jumlahdibeli > stok) {
            System.out.println("Jumlah pembelian melebihi stok");
        }else if(jumlahdibeli == stok){
            System.out.println("Habis");
        }
         else {
            System.out.println("Masih ada ");
            
        }

        sisaStok = stok - jumlahdibeli;
    }

    void infoDisplay(){
        System.out.println("Id produk : " + id);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Stok : " + stok);
        System.out.println("Harga : " + harga);
        System.out.println("Sisa Stok : " + sisaStok);

        if (sisaStok < 0){
            System.out.println("Stok tidak cukup");
        } else {
            System.out.println("Sisa stok setelah dibeli : " + sisaStok);
        }
    }
    
}

public class No2 {
   public static void main(String[] args) {
    Produk prodak = new Produk();

    prodak.id = 999;
    prodak.nama = "Iphone";
    prodak.stok = 5;
    prodak.harga = 120;
    prodak.cekStok(5);
    prodak.infoDisplay();

   }
    
}
