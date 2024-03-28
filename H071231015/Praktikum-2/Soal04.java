class Alamat{
    String jalan;
    String kota;
}

class Mahasiswa{
    Alamat alamat;
    String nama;
    String nim;

    String getNama(){
        return nama;
    }

    String getNim(){
        return nim;
    }

    String getAlamat(){
        return alamat.jalan + ", " + alamat.kota;
    }
}



public class Soal04 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Rudy";
        mahasiswa.nim = "H071231015";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}
