class Mahasiswa {
    String nama;
    Alamat alamat;
    String nim;

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat.getAlamat();
    }

    public String getNim() {
        return nim;
    }
}

class Alamat {
    String jalan;
    String kota;

    public String getAlamat() {
        return jalan + ", " + kota;
    }
}

public class TP2_4_H071231080 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Abdesir";
        alamat.kota = "Makassar";
 
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Nur fadillah";
        mahasiswa.nim = "H071231080";

        System.out.println("Nama : " + mahasiswa.getNama());
        System.out.println("NIM : " + mahasiswa.getNim());
        System.out.printf("Alamat : " + mahasiswa.getAlamat());
    }
}
