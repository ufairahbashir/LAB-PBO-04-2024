package BangunRuang;

public class BangunRuang {
    final private double pi = 3.14;
    private double panjang, lebar, alas, tinggi, jariJari;
    
    double HitungLuasPermukaan(){
        double luas = 0;
        return luas;
    }

    double HitungVolume(){
        double volume = 0;
        return volume;
    }

    protected static void reqHitung(){
        System.out.println("=".repeat(20));
        System.out.println(" 1. Luas permukaan\n 2. Volume\n");
        System.out.println("Mau hitung apa?");
        System.out.print("> ");
    } 

    protected double getPi(){
        return pi;
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

}