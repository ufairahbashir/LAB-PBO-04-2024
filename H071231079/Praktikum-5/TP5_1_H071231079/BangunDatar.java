package TP5_1_H071231079;

public class BangunDatar {
    public double hitungLuas() {
        return 0.0;
    }

    public double hitungKeliling() {
        return 0.0;
    }
}

class Persegi extends BangunDatar{
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuas() {
        return sisi * sisi;
    }

    public double hitungKeliling() {
        return 4 * sisi;
    }

    public void display() {
        System.out.println("Luas persegi     : " + hitungLuas());
        System.out.println("Keliling persegi : " + hitungKeliling());
    }
}

class PersegiPanjang extends  BangunDatar {
    private double panjang;
    private double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double hitungLuas() {
        return panjang * lebar;
    }

    public double hitungKeliling() {
        return (2 * panjang) + (2 * lebar); 
    }

    public void display() {
        System.out.println("Luas persegi panjang     : " + hitungLuas());
        System.out.println("Keliling persegi panjang : " + hitungKeliling());
    }
}

class Lingkaran extends BangunDatar {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double hitungLuas() {
        return Math.PI * jariJari * jariJari ;
    }

    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }

    public void display() {
        System.out.println("Luas lingkaran     : " + hitungLuas());
        System.out.println("Keliling lingkaran : " + hitungKeliling());
    }
}

class Trapesium extends BangunDatar {
    private double sisi1;
    private double sisi2;
    private double sisi3;
    private double sisi4;
    private double tinggi;
    
    public Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }

    public double hitungLuas() {
        return ((sisi1 + sisi2) * tinggi) / 2;
    }

    public double hitungKeliling() {
        return sisi1 + sisi2 + sisi3 + sisi4;
    }

    public void display() {
        System.out.println("Luas trapesium     : " + hitungLuas());
        System.out.println("Keliling trapesium : " + hitungKeliling());
    }
}