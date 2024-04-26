package TP5_1_H071231080;

class BangunDatar {
    double sisi, panjang, lebar, jariJari, sisi1, sisi2, sisi3, sisi4, tinggi;
    
}

// Subclass untuk persegi, turunan dari BangunDatar
class Persegi extends BangunDatar {
    
    // Konstruktor
    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    // method hitungLuas untuk persegi
    public double hitungLuas() {
        return sisi * sisi;
    }

    // method hitungKeliling untuk persegi
    public double hitungKeliling() {
        return 4 * sisi;
    }
}

// Subclass untuk persegi panjang, turunan dari BangunDatar
class PersegiPanjang extends BangunDatar {

    // Konstruktor
    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    // method hitungLuas untuk persegi panjang
    public double hitungLuas() {
        return panjang * lebar;
    }

    // method hitungKeliling untuk persegi panjang
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}

// Subclass untuk lingkaran, turunan dari BangunDatar
class Lingkaran extends BangunDatar {

    // Konstruktor
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    // method hitungLuas untuk lingkaran
    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    // method hitungKeliling untuk lingkaran
    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }
}

// Subclass untuk trapesium, turunan dari BangunDatar
class Trapesium extends BangunDatar {

    // Konstruktor
    public Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }

    // method hitungLuas untuk trapesium
    public double hitungLuas() {
        return (sisi1 + sisi2) / 2 * tinggi;
    }

    // Override method hitungKeliling untuk trapesium
    public double hitungKeliling() {
        // Untuk sederhana, asumsikan trapesium ini memiliki dua sisi sejajar yang sama panjang
        return (sisi1 + sisi2 + sisi3 + sisi4);
    }
}