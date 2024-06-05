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

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNim(){
        return nim;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getAlamat(){
        return alamat.getAlamat();
    }
}

public class TP2_4_H071231012 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea indah";
        alamat.kota = "Makassar";
        
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Farhan";
        mahasiswa.nim = "H071231025";

        System.out.println("nama : "+ mahasiswa.getNama());
        System.out.println("nim : "+ mahasiswa.getNim());
        System.out.println("alamat : "+ mahasiswa.getAlamat());
    }

}

