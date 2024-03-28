package TP2;

class Alamat {
    String jalan, kota;

    public String getAlamat() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    String nama, nim;
    Alamat alamat = new Alamat();

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}

public class TP2_4_H071231079 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Bukit Baruga Antang";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.nama = "Jasmine";
        mahasiswa1.nim = "H071231079";
        mahasiswa1.alamat = alamat;

        System.out.println("Nama \t: " + mahasiswa1.getNama());
        System.out.println("NIM \t: " + mahasiswa1.getNim());
        System.out.println("Alamat \t: " + alamat.getAlamat());
    }
}
