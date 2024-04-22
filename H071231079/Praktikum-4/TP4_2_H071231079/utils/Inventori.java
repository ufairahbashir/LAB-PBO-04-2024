package TP4_2_H071231079.utils;

import java.util.ArrayList;
import TP4_2_H071231079.models.Produk;

public class Inventori {
    private ArrayList<Produk> produk;

    public Inventori() {
        produk = new ArrayList<>();
    }

    public void tambahProduk(Produk produkBaru) {
        produk.add(produkBaru);
    }

    //Method
    public void tampilkanInventori() {
        System.out.println("Inventori :");
        for (Produk p : produk) {
            p.tampilkanDetailProduk();
        }
    }

    //Method
    public Produk cariProdukById(String id) {
        for (Produk p : produk) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
