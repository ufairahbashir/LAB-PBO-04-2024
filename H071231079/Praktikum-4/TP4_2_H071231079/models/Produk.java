package TP4_2_H071231079.models;

public class Produk {
    private String id;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }

    // Method 1
    public void tampilkanDetailProduk() {
        System.out.println("ID : " + id + ", Nama : " + nama + ", Harga : Rp" + harga + ", Stok : " + stok);
    }
}
