package models;
//Atribut : nama,alamat, ArrayList<Buku>bukuPinjaman
//behavior : int judulBukuDipinjam, void pinjamBuku, void KembalikanBuku
//  void daftarBukuPinjaman, void tampilkan info anggota
// int jumlahBukuFiksiDipinjam, int jumlahBukuNonFiksi


import java.util.ArrayList;

public class AnggotaPerpustakaan {
    private String nama;
    private String alamat;
    private ArrayList<Buku> bukuPinjaman;

    public AnggotaPerpustakaan(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
        this.bukuPinjaman = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<Buku> getBukuPinjaman() {
        return bukuPinjaman;
    }

    public void setBukuPinjaman(ArrayList<Buku> bukuPinjaman) {
        this.bukuPinjaman = bukuPinjaman;
    }
    
    //Behavior 1
    public int judulBukuDipinjam(){
        return bukuPinjaman.size();
    }

    //Behavior 2
    public void pinjamBuku(Buku buku){
        bukuPinjaman.add(buku);
        System.out.println("Buku " + buku.getJudul() + " telah dipinjam oleh " + nama);
    }

    //Behavior 3
    public void KembalikanBuku(Buku buku){
        if (bukuPinjaman.contains(buku)){
            bukuPinjaman.remove(buku);
            System.out.println("Buku " + buku.getJudul() + "telah dikembalika oleh " + nama);
        } else {
            System.out.println("Buku " + buku.getJudul() + "tidak ditemukan ");
        }
    }

    //Behavior 4
    public void daftarBukuPinjaman(){
        System.out.println("DAFTAR YANG DIPINJAM OLEH " + nama);
        if (bukuPinjaman.isEmpty()){
            System.out.println("Tidak ada buku yang dipinjam");
        } else {
            for (Buku buku : bukuPinjaman){
                System.out.println("> " + buku.getJudul());
            }
        }
    }

    //Behavior 5
    public void tampilkanInfoAnggota(){
        System.out.println("INFO ANGGOTA");
        System.out.println("Nama    : " + nama);
        System.out.println("Alama : " + alamat);
        System.out.println("Buku yang dipinjam");
        if (bukuPinjaman.isEmpty()){
            System.out.println("tidak ada buku yang dipinjam");
        } else {}
            for (Buku buku : bukuPinjaman){
                System.out.println("> " + buku.getJudul());
        }
    }

    //Behavior 6
    public int jumlahBukuFiksiDipinjam(){
        int jumlahFiksi = 0;
        for (Buku buku : bukuPinjaman){
            if (buku.getIsFiksi()){
                jumlahFiksi++;
            }
        }
        return jumlahFiksi;
    }

    //Behavior 7
    public int jumlahBukuNonFiksi(){
        int jumlahNonFiksi = 0;
        for (Buku buku : bukuPinjaman){
            if (!buku.getIsFiksi()){
                jumlahNonFiksi++;
            }
        }
        return jumlahNonFiksi;
    }
    
}