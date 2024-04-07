class Alamat{
    String jalan;
    String kota;

    public String getAlamat(){
        return jalan + " , " + kota;
    }

}

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

public class TP2_4_H071231063 {
    public static void main(String[] args) {
        Alamat alamat= new Alamat();
        alamat.jalan= "Tamalanrea";
        alamat.kota= "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat= alamat;
        mahasiswa.nama= "Amalia";
        mahasiswa.nim= "H071231063";

        System.out.println("Nama: "+ mahasiswa.getNama());
        System.out.println("Nim: "+ mahasiswa.getNim());
        System.out.println("Alamt "+ mahasiswa.getAlamat());
    }
}
