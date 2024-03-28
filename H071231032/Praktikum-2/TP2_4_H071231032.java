import java.util.Scanner;

class Alamat {
    String jalan, kota;
}

class Mahasiswa {
    Alamat alamat = new Alamat();
    String nama, nim;

    String getNama() {
        return nama;
    }
    String getNim() {
        return nim;
    }

    String getAlamat() {
        return alamat.jalan + ", " + alamat.kota;
    }
}

public class TP2_4_H071231032 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        Mahasiswa mahasiswa = new Mahasiswa();

        try (Scanner sc = new Scanner(System.in)) {
            // ---------- Data Alamat ---------- //
            System.out.printf("Masukkan Jalan : ");
            alamat.jalan = sc.nextLine();
            System.out.printf("Masukkan Kota  : ");
            alamat.kota = sc.nextLine();

            // --------- Data Mahasiswa --------- //
            System.out.printf("Masukkan Nama  : ");
            mahasiswa.nama = sc.nextLine();
            System.out.printf("Masukkan NIM   : ");
            mahasiswa.nim = sc.nextLine();
            mahasiswa.alamat = alamat;
        }
        System.out.printf("\nNama   : %s\nNim    : %s\nAlamat : %s\n",
            mahasiswa.getNama(), mahasiswa.getNim(), mahasiswa.getAlamat());
    }
}