package TP4_2_H071231079.models;

public class Pelanggan {
    private String nama;
    private String email;

    public Pelanggan(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public void tampilkanDetailPelanggan() {
        System.out.println("Nama: " + nama + ", Email: " + email);
    }
}