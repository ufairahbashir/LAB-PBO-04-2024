class Mahasiswa{
    String nama;
    String nim;
    Alamat alamat;

    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public String getAlamat(){
        return alamat.getAlamat();
    }
}

class Alamat{
    String jalan;
    String kota;

    public String getAlamat(){
        return jalan + "," + kota;
    }
}

public class No4{
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "sesama";
        alamat.kota = "Bandung";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.nama = "Reyy";
        mahasiswa.nim = "H071231077";
        mahasiswa.alamat = alamat;

        System.out.println(mahasiswa.getNama());
        System.out.println(mahasiswa.getNim());
        System.out.println(mahasiswa.getAlamat());
    }
}