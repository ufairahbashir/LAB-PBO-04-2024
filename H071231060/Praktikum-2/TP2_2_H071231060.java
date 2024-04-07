class Data{
    String IdProduk;
    String Nama;
    int Stock;
    int Harga;

    void CekStock(){
        if (Stock > 0){
            System.out.println("Stock Tersedia dengan jumlah: "+ Stock);
        } else {
            System.out.println("Stock tidak ditemukan atau tidak tersedia.");
        }
    }
}
public class TP2_2_H071231060 {
    public static void main(String[] args) {
        Data Produk1 = new Data();
        Produk1.IdProduk = "H071231060";
        Produk1.Nama = "Ikan";
        Produk1.Stock = 100;
        Produk1.Harga = 15000;
        System.out.println("IdProduk: "+ Produk1.IdProduk);
        System.out.println("Nama Produk: "+ Produk1.Nama);
        System.out.println("Harga Produk: "+ Produk1.Harga);
        Produk1.CekStock();
    }
}