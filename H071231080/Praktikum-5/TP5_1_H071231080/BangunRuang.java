package TP5_1_H071231080;

class BangunRuang {
    double sisi, panjang, lebar,tinggi, jariJari; 

}

// Subclass untuk kubus, turunan dari BangunRuang
class Kubus extends BangunRuang {
   
    // Konstruktor
    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double luasPermukaan(){
        return 6 * sisi * sisi;
    }

    // Override method hitungVolume untuk kubus
    public double hitungVolume() {
        return sisi * sisi * sisi;
    }
}

// Subclass untuk balok, turunan dari BangunRuang
class Balok extends BangunRuang {

    // Konstruktor
    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public double luasPermukaan(){
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }
}

// Subclass untuk bola, turunan dari BangunRuang
class Bola extends BangunRuang {

    // Konstruktor
    public Bola(double jariJari) {  
        this.jariJari = jariJari;
    }

    public double luasPermukaan(){
        return 4 * Math.PI * jariJari * jariJari;
    }
    public double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * jariJari * jariJari * jariJari;
    }
}

// Subclass untuk tabung, turunan dari BangunRuang
class Tabung extends BangunRuang {

    // Konstruktor
    public Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    public double luasPermukaan(){
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    
    public double hitungVolume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }
}
