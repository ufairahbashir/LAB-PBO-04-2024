package TP5_1_H071231079;

public class BangunRuang {
    public double hitungLuasPermukaan() {
        return 0.0;
    }

    public double hitungVolume() {
        return 0.0;
    }
}

class Kubus extends BangunRuang {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuasPermukaan() {
        return 6 * sisi * sisi;
    }

    public double hitungVolume() {
        return sisi * sisi * sisi;
    }

    public void display() {
        System.out.println("Luas kubus   : " + hitungLuasPermukaan());
        System.out.println("Volume kubus : " + hitungVolume());
    }
}

class Balok extends BangunRuang {
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public double hitungLuasPermukaan() {
        return 2 * ((panjang*lebar)+(panjang*tinggi)+(lebar*tinggi));
    }

    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }

    public void display() {
        System.out.println("Luas balok   : " + hitungLuasPermukaan());
        System.out.println("Volume balok : " + hitungVolume());
    }
}

class Bola extends BangunRuang {
    private double jariJari;

    public Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    public double hitungLuasPermukaan() {
        return 4 * Math.PI * jariJari * jariJari;
    }

    public double hitungVolume() {
        return 4/3 * Math.PI * jariJari * jariJari * jariJari;
    }

    public void display() {
        System.out.println("Luas bola   : " + hitungLuasPermukaan());
        System.out.println("Volume bola : " + hitungVolume());
    }
}

class Tabung extends BangunRuang {
    private double jariJari;
    private double tinggi;

    public Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    public double hitungVolume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }

    public void display() {
        System.out.println("Luas tabung   : " + hitungLuasPermukaan());
        System.out.println("Volume tabung : " + hitungVolume());
    }
}