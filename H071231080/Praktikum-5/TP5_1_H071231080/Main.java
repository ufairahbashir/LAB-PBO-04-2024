package TP5_1_H071231080;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("=== BANGUN RUANG ===");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        
        System.out.println("\n=== BANGUN DATAR ===");
        System.out.println("5. PERSEGI ");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("--------------------------------------");
        System.out.print("Pilihan: ");

        int pilihan = sc.nextInt();
        System.out.println("--------------------------------------");

        switch (pilihan) {
            case 1:
                // Kubus
                System.out.print("Masukkan panjang sisi kubus: ");
                double sisiKubus = sc.nextDouble();

                Kubus kubus = new Kubus(sisiKubus);
                System.out.println("Volume Kubus: " + kubus.hitungVolume());
                System.out.println("--------------------------------------");
                break;
            case 2:
                // Balok
                System.out.print("Masukkan panjang balok: ");
                double panjangBalok = sc.nextDouble();
                System.out.print("Masukkan lebar balok: ");
                double lebarBalok = sc.nextDouble();
                System.out.print("Masukkan tinggi balok: ");
                double tinggiBalok = sc.nextDouble();

                Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
                System.out.println("Volume Balok: " + balok.hitungVolume());
                System.out.println("--------------------------------------");
                break;
            case 3:
                // Bola
                System.out.print("Masukkan jari-jari bola: ");
                double jariJariBola = sc.nextDouble();

                Bola bola = new Bola(jariJariBola);
                System.out.println("Volume Bola: " + bola.hitungVolume());
                System.out.println("--------------------------------------");
                break;
            case 4:
                // Tabung
                System.out.print("Masukkan jari-jari tabung: ");
                double jariJariTabung = sc.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tinggiTabung = sc.nextDouble();

                Tabung tabung = new Tabung(jariJariTabung, tinggiTabung);
                System.out.println("Volume Tabung: " + tabung.hitungVolume());
                System.out.println("--------------------------------------");
                break;
            case 5:
                // Persegi
                System.out.print("Masukkan panjang sisi persegi: ");
                double sisiPersegi = sc.nextDouble();

                Persegi persegi = new Persegi(sisiPersegi);
                System.out.println("Luas Persegi: " + persegi.hitungLuas());
                System.out.println("Keliling Persegi: " + persegi.hitungKeliling());
                break;
            case 6:
                // Persegi Panjang
                System.out.print("Masukkan panjang persegi panjang: ");
                double panjangPersegiPanjang = sc.nextDouble();
                System.out.print("Masukkan lebar persegi panjang: ");
                double lebarPersegiPanjang = sc.nextDouble();

                PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);
                System.out.println("Luas Persegi Panjang: " + persegiPanjang.hitungLuas());
                System.out.println("Keliling Persegi Panjang: " + persegiPanjang.hitungKeliling());
                break;
            case 7:
                // Lingkaran
                System.out.print("Masukkan jari-jari lingkaran: ");
                double jariJariLingkaran = sc.nextDouble();

                Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);
                System.out.println("Luas Lingkaran: " + lingkaran.hitungLuas());
                System.out.println("Keliling Lingkaran: " + lingkaran.hitungKeliling());
                break;
            case 8:
                // Trapesium
                System.out.print("Masukkan panjang sisi 1 trapesium: ");
                double sisi1Trapesium = sc.nextDouble();
                System.out.print("Masukkan panjang sisi 2 trapesium: ");
                double sisi2Trapesium = sc.nextDouble();
                System.out.print("Masukkan panjang sisi 3 trapesium: ");
                double sisi3Trapesium = sc.nextDouble();
                System.out.print("Masukkan panjang sisi 4 trapesium: ");
                double sisi4Trapesium = sc.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tinggiTrapesium = sc.nextDouble();

                Trapesium trapesium = new Trapesium(sisi1Trapesium, sisi2Trapesium, sisi3Trapesium, sisi4Trapesium, tinggiTrapesium);
                System.out.println("Luas Trapesium: " + trapesium.hitungLuas());
                System.out.println("Keliling Trapesium: " + trapesium.hitungKeliling());
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;  
        }
        sc.close();
    }   
}
