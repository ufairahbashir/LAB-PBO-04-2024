import java.util.Scanner;

import BangunDatar.Lingkaran;
import BangunDatar.Persegi;
import BangunDatar.PersegiPanjang;
import BangunDatar.Trapesium;
import BangunRuang.Balok;
import BangunRuang.Bola;
import BangunRuang.Kubus;
import BangunRuang.Tabung;

public class Main{
    public static void main(String[] args) {
        runApp();
    }

    static void runApp(){
        Scanner sc = new Scanner (System.in);
        System.out.println("=== BANGUN RUANG ===");
        System.out.println(" 1.Kubus\n 2.Balok\n 3.Bola\n 4.Tabung\n");
        System.out.print("");

        System.out.println("=== BANGUN DATAR ===");
        System.out.println(" 5.Lingkaran\n 6.Persegi\n 7.Persegi Panjang\n 8.Trapesium\n");
        System.out.print("");
        System.out.println("Pilih Tipe Bangunan");
        System.out.print("> ");

        int inpTipe = sc.nextInt();
        sc.nextLine();
        switch (inpTipe) {
            case 1:
                Kubus.runKubus();
                break;
            case 2:
                Balok.runBalok();
                break;
            case 3:
                Bola.runBola();
                break;
            case 4:
                Tabung.runTabung();
                break;
            case 5:
                Lingkaran.runLingkaran();
                break;
            case 6:
                Persegi.runPersegi();
                break;
            case 7:
                PersegiPanjang.runPersegiPanjang();
            case 8:
                Trapesium.runTrapesium();
                break;
            default:
                break;
        }

        sc.close();
    }
}


