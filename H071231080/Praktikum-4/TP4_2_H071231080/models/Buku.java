package models;
//Atribut : String judul, pengarang, int jumlahHalaman, boolean isFiksi
//konstruktor dan getter setter

public class Buku {
    private String judul;
    private String pengarang;
    private int jumlahHalaman;
    private boolean isFiksi;

    public Buku(String judul, String pengarang, int jumlahHalaman, boolean isFiksi){
        this.judul = judul;
        this.pengarang = pengarang;
        this.jumlahHalaman = jumlahHalaman;
        this.isFiksi = isFiksi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

    public boolean getIsFiksi() {
        return isFiksi;
    }

    public void setFiksi(boolean isFiksi) {
        this.isFiksi = isFiksi;
    }
    

}