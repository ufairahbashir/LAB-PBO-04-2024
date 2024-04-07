import java.util.Scanner;

class Alamat{
    String jalan;
    String kota;

    public String getAlamat(){
        return jalan + ", " + kota;
    }
}
class Mahasiswa {
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
public class TP2_4_H071231060 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama jalan: ");
        String input1 = scanner.nextLine();
        alamat.jalan = input1;
        scanner.close();

        Scanner kota1 = new Scanner(System.in);
        System.out.println("Masukkan nama kota: ");
        String input2 = kota1.nextLine();
        alamat.kota = input2;
        kota1.close();
        


        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        Scanner nama1 = new Scanner(System.in);
        System.out.println("Masukkan nama nama: ");
        String nama2 = nama1.nextLine();
        mahasiswa.nama = nama2;
        nama1.close();

        Scanner nim = new Scanner(System.in);
        System.out.println("Masukkan nama nim: ");
        String nim1 =nim.nextLine();
        mahasiswa.nim = nim1;
        nim.close();

        System.out.println("Nama: "+ mahasiswa.getNama());
        System.out.println("Nim: "+ mahasiswa.getNim());
        System.out.println("Alamat: "+ mahasiswa.getAlamat());
    }
}
