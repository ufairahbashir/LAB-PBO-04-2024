class Produk{
    String nama;
    String id;
    int stok;
    int harga;

    public void cekProduk(){
        if (stok > 0){
            System.out.println("Stok tersedia: "+ stok);
        }else{
            System.out.println("Stok tidak tersedia");
        }
    }
}

public class TP2_2_H071231063 {
    public static void main(String[] args) {
        Produk produk = new Produk();
        produk.id= "1234";
        produk.nama= "Sabun";
        produk.stok=10;
        produk.harga=100;
        
        System.out.println("ID produk= "+ produk.id);
        System.out.println("Nama produk= "+ produk.nama);
        System.out.println("Harga produk= "+ produk.harga);
        produk.cekProduk();
    }
}
