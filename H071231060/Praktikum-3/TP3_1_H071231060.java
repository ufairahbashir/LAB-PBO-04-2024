import java.util.Scanner;
class SarungTinju {
    private String warna;
    private int berat;
    public SarungTinju(String warna, int berat) {
        this.warna = warna;
        this.berat = berat;
    }
    public String getWarna() {
        return warna;
    }
    public void setWarna(String warna) {
        this.warna = warna;
    }
    public int getBerat() {
        return berat;
    }
    public void setBerat(int berat) {
        this.berat = berat;
    }
    
}
class Petinju{
    private String nama;
    private int umur, ketahanan, kekuatan;
    private SarungTinju tinju;
    public Petinju(String nama, int umur, int ketahanan, int kekuatan, SarungTinju tinju) {
        this.nama = nama;
        this.umur = umur;
        this.ketahanan = ketahanan;
        this.kekuatan = kekuatan;
        this.tinju = tinju;
    }
    public Petinju(String nama, int umur
    , int ketahanan, int kekuatan) {
        this.nama = nama;
        this.umur = umur;
        this.ketahanan = ketahanan;
        this.kekuatan = kekuatan;
        this.tinju = new SarungTinju("Merah", 12);
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getUmur() {
        return umur;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
    public int getKetahanan() {
        return ketahanan;
    }
    public void setKetahanan(int ketahanan) {
        this.ketahanan = ketahanan;
    }
    public int getKekuatan() {
        return kekuatan;
    }
    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }
    public SarungTinju getTinju() {
        return tinju;
    }
    public void setTinju(SarungTinju tinju) {
        this.tinju = tinju;
    }

    public void infoPetinju(){
        System.out.println("Nama : "+nama+"\nUmur : "+umur+"\nKetahanan : "+ketahanan+"\nKekuatan : "+ kekuatan+"\nWarna Sarung Tinju : "+tinju.getWarna());
    }
    public void beratSarungTinju(){
        System.out.println(nama+"Menggunakan Sarung tinju dengan berat"+tinju.getBerat());
    }
    public void bertarung(Petinju enemy) {
        if (this.kekuatan > enemy.ketahanan) {
            System.out.println(this.nama + " menyerang " + enemy.nama + " dan berhasil mengalahkannya!");
        } else if (enemy.kekuatan > this.ketahanan) {
            System.out.println(enemy.nama + " menyerang " + this.nama + " dan berhasil mengalahkannya!");
        } else {
            System.out.println("Pertarungan antara " + this.nama + " dan " + enemy.nama + " berakhir imbang.");
        }
    }
    
    
}
public class TP3_1_H071231060 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //petarung1
        System.out.println("Masukkan warna:");
        String Warna1 = scan.nextLine();
        System.out.println("Masukkan berat:");
        int berat1 = scan.nextInt();

        //petarung2
        System.out.println("Masukkan warna:");
        String Warna2 = scan.nextLine();
        scan.nextLine();
        System.out.println("Masukkan berat:");
        int berat2 = scan.nextInt();


        SarungTinju MikeGlove = new SarungTinju(Warna1, berat1);
        SarungTinju AliGlove = new SarungTinju(Warna2, berat2);

        //petinju1
        System.out.println("Masukkan Data diri petinju 1:");
        System.out.println("Nama: ");
        scan.nextLine();
        String Nama1 = scan.nextLine();
        scan.nextLine();
        System.out.println("Umur: ");
        int Umur1 = scan.nextInt();
        scan.nextLine();
        System.out.println("Ketahanan: ");
        int Ketahanan1 = scan.nextInt();
        scan.nextLine();
        System.out.println("Kekuatan");
        int Kekuatan1 = scan.nextInt();
        Petinju Mike = new Petinju(Nama1, Umur1, Ketahanan1, Kekuatan1, MikeGlove);
        

        System.out.println("Masukkan Data diri petinju 2:");
        scan.nextLine();
        System.out.println("Nama: ");
        String Nama2 = scan.nextLine();
        scan.nextLine();
        System.out.println("Umur: ");
        int Umur2 = scan.nextInt();
        scan.nextLine();
        System.out.println("Ketahanan: ");
        int Ketahanan2 = scan.nextInt();
        scan.nextLine();
        System.out.println("Kekuatan");
        int Kekuatan2 = scan.nextInt();
        Petinju Ali = new Petinju(Nama2, Umur2, Ketahanan2, Kekuatan2, AliGlove);
        Mike.infoPetinju();
        Mike.beratSarungTinju();
        Ali.infoPetinju();
        Ali.beratSarungTinju();
        scan.close();
    }
}