class Toko {
    String ID;
    String nama;
    int stok;
    int harga;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga){
        this.harga = harga;
    }

    public void produkData() {
        System.out.println("ID produk : " + getID());
        System.out.println("nama produk : " + getNama());
        System.out.println("harga produk : " + getHarga());

        if (getStok() == 0){
            System.out.println("Produk tidak tersedia");
        } else {
            System.out.println("stok produk : " + getStok());
        }
    }

    public void produkSisa() {
        if (getStok() == 0){
            System.out.printf("produk %s tidak tersedia", nama);
        }else {
            System.out.println("stok produk : " + getStok());
            System.out.printf("produk %s tersedia", nama);
        }
    }
}
public class TP2_2_H071231012 {
    public static void main(String[] args) {
        Toko mart = new Toko();
        mart.ID = "H071231012";
        mart.nama = "semangka";
        mart.harga = 50000;
        mart.stok = 7;

        mart.produkData();
        mart.produkSisa();
    }
}