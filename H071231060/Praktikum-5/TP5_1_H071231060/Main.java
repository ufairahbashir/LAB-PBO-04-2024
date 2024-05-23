import java.util.Scanner;

abstract class BangunRuang{
    String Nama;

    public BangunRuang(String nama) {
        Nama = nama;
    }

    public abstract double LuasPermukaan();
    public abstract double VolumeBangun();
}
class Kubus extends BangunRuang{
    double sisi;

    public Kubus(double sisi) {
        super("Kubus");
        this.sisi = sisi;
    }
    
    @Override
    public double LuasPermukaan(){
        return 6*(sisi*sisi);
    }
    @Override
    public double VolumeBangun(){
        return Math.pow(sisi, 3);
    }
}
class Balok extends BangunRuang{
    double Panjang, Lebar, Tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super("Balok");
        Panjang = panjang;
        Lebar = lebar;
        Tinggi = tinggi;
    }

    @Override
    public double LuasPermukaan(){
        return 2* ((Panjang * Lebar)+(Panjang * Tinggi)+(Lebar * Tinggi));
    }
    @Override
    public double VolumeBangun(){
        return Panjang*Lebar*Tinggi;
    }

}
class Bola extends BangunRuang{
    double Jari2;

    public Bola(double jari2) {
        super("Bola");
        Jari2 = jari2;
    }

    @Override
    public double LuasPermukaan(){
        return 4 * Math.PI * Math.pow(Jari2, 2);
    }
    @Override
    public double VolumeBangun(){
        return (4.0/3.0) * Math.PI * Math.pow(Jari2, 2);
    }
}
class Tabung extends BangunRuang{
    double Jari2, Tinggi;

    public Tabung(double jari2, double tinggi) {
        super("Tabung");
        Jari2 = jari2;
        Tinggi = tinggi;
    }
    @Override
    public double LuasPermukaan(){
        return (2 * Math.PI * Jari2 * Tinggi) + (2 * Math.PI * Math.pow(Jari2, 2));
    }
    @Override
    public double VolumeBangun(){
        return Math.PI * Math.pow(Jari2, 2) * Tinggi;
    }
}
abstract class BangunDatar{
    String Nama;

    public BangunDatar(String nama) {
        Nama = nama;
    }

    public abstract double hitungLuas();
    public abstract double hitungKeliling();
}
class Kotak extends BangunDatar{
    double sisi;

    public Kotak(double sisi) {
        super("Kotak");
        this.sisi = sisi;
    }
    @Override
    public double hitungLuas(){
        return Math.pow(sisi, 2);
    }
    @Override
    public double hitungKeliling(){
        return 4 * sisi;
    } 
}
class PersegiPanjang extends BangunDatar{
    double Panjang, Lebar;

    public PersegiPanjang(double panjang, double lebar) {
        super("Persegi Panjang");
        Panjang = panjang;
        Lebar = lebar;
    }

    @Override
    public double hitungLuas(){
        return Panjang * Lebar;
    }
    @Override
    public double hitungKeliling(){
        return 2 * (Panjang + Lebar);
    }
}
class Lingkaran extends BangunDatar{
    double Jari2;

    public Lingkaran(double jari2) {
        super("Lingkaran");
        Jari2 = jari2;
    }
    @Override
    public double hitungLuas(){
        return Math.PI * Math.pow(Jari2, 2);
    }
    @Override
    public double hitungKeliling(){
        return 2 * Math.PI * Jari2;
    }
}
class Trapesium extends BangunDatar{
    double sisi1, sisi2, Tinggi, Miring;

    public Trapesium(double sisi1, double sisi2, double tinggi, double miring) {
        super("Trapesium");
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        Tinggi = tinggi;
        Miring = miring;
    }

    @Override
    public double hitungLuas(){
        return ((sisi1 + sisi2) * Tinggi)/2;
    }
    @Override
    public double hitungKeliling(){
        return sisi1 + sisi2 + (2 * Miring);
    }
}
public class Main {

    static Scanner sc = new Scanner(System.in);

    static double ReadDouble(){
        while (true) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong.");
            continue;
            }
            try {
                double input = Double.parseDouble(next);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        }  
    }
    static int ReadInt(){
        while (true) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong.");
            continue;
            }
            try {
                int input = Integer.parseInt(next);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        } 
    }

    public void Menu(){
        
    }
    public static void main(String[] args) {
       while (true) {
           System.out.println("-----Bangun Ruang-----");
           System.out.println("1. Kubus");
           System.out.println("2. Balok");
           System.out.println("3. Bola");
           System.out.println("4. Tabung");
           System.out.println("-----Bangun Datar-----");
           System.out.println("5. Kotak");
           System.out.println("6. Persegi Panjang");
           System.out.println("7. Lingkaran");
           System.out.println("8. Trapesium");
           System.out.print(">>> Masukkan Pilihan: ");
           int Choice = ReadInt();
   
           switch (Choice) {
               case 1:
                   System.out.print("Masukkan Nilai sisi : ");
                   double sisi = ReadDouble();
                   System.out.println("Luas Permukaan "+ new Kubus(sisi).LuasPermukaan());
                   System.out.println("Volume Kubus"+ new Kubus(sisi).VolumeBangun());
                   
                   break;
               case 2:
                   System.out.print("Masukkan Nilai Panjang : ");
                   double Panjang = ReadDouble();
                   System.out.print("Masukkan Nilai Lebar : ");
                   double Lebar = ReadDouble();
                   System.out.print("Masukkan Nilai Tinggi : ");
                   double Tinggi = ReadDouble();
                   System.out.println("Luas Permukaan "+ new Balok(Panjang, Lebar, Tinggi).LuasPermukaan());
                   System.out.println("Volume Balok "+ new Balok(Panjang, Lebar, Tinggi).VolumeBangun());
                   break;
   
               case 3:
                   System.out.print("Masukkan Nilai Jari Jari : ");
                   double Jari = ReadDouble();
                   System.out.println("Luas Permukaan "+ new Bola(Jari).LuasPermukaan());
                   System.out.println("Volume Bola "+ new Bola(Jari).VolumeBangun());
                   break;
               case 4:
                   System.out.print("Masukkan Nilai Jari Jari: ");
                   double Jari2 = ReadDouble();
                   System.out.print("Masukkan Nilai Tinggi: ");
                   double Tinggi2 = ReadDouble();
                   System.out.println("Luas Permukaan "+ new Tabung(Jari2, Tinggi2).LuasPermukaan());
                   System.out.println("Volume Tabung "+ new Tabung(Jari2, Tinggi2).VolumeBangun());
                   break;
               case 5:
                   System.out.print("Masukkan Nilai sisi: ");
                   double sisi1 = ReadDouble();
                   System.out.println("Luas "+ new Kotak(sisi1).hitungLuas());
                   System.out.println("Keliling "+ new Kotak(sisi1).hitungKeliling());
                   break;
               case 6:
                   System.out.print("Masukkan Nilai Panjang: ");
                   double Panjang1 = ReadDouble();
                   System.out.print("Masukkan Nilai Lebar: ");
                   double Lebar1 = ReadDouble();
                   System.out.println("Luas "+ new PersegiPanjang(Panjang1, Lebar1).hitungLuas());
                   System.out.println("Keliling "+ new PersegiPanjang(Panjang1, Lebar1).hitungKeliling());
                   break;
               case 7:
                   System.out.print("Masukkan Nilai Jari jari: ");
                   double Jari1 = ReadDouble();
                   System.out.println("Luas "+ new Lingkaran(Jari1).hitungLuas());
                   System.out.println("Keliling "+ new Lingkaran(Jari1).hitungKeliling());
                   break;
               case 8:
                   System.out.print("Memasukkan Nilai Sisi 1: ");
                   double Sisi3 = ReadDouble();
                   System.out.print("Masukkan Nilai Sisi 2: ");
                   double Sisi4 = ReadDouble();
                   System.out.print("Masukkan nilai Tinggi: ");
                   double Tinggi3 = ReadDouble();
                   System.out.print("Masukkan Nilai Miring: ");
                   double Miring = ReadDouble();
                   System.out.println("Luas "+ new Trapesium(Sisi3, Sisi4, Tinggi3, Miring).hitungLuas());
                   System.out.println("Keliling "+ new Trapesium(Sisi3, Sisi4, Tinggi3, Miring).hitungKeliling());
               case 9:
                   System.out.println("Program Berhenti");
                   System.exit(0);
   
               default:
                   System.out.println("Inputan Tidak Sesuai, Pilih (1-9)");
                   break;
           }
       } 
    }
}