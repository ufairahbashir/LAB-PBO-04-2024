package BangunRuang;

import java.util.Scanner;

public class Balok extends BangunRuang{
    public Balok(double panjang, double tinggi, double lebar){
        this.setPanjang(panjang);
        this.setTinggi(tinggi);
        this.setLebar(lebar);
    }

    @Override
    double HitungLuasPermukaan(){
        double luas = 2 * (this.getPanjang() * this.getTinggi() * this.getLebar());
        return luas;
    }

    @Override
    double HitungVolume(){
        double volume = this.getPanjang() * this.getTinggi() * this.getLebar();
        return volume;
    }

    public static void runBalok(){
        Scanner sc = new Scanner (System.in);

        System.out.println("=== BALOK ===");
        System.out.println("Masukkan Panjang");
        System.out.print("> ");
        int inpPanjang = sc.nextInt();
        sc.nextLine();

        System.out.println("Masukkan Tinggi");
        System.out.print("> ");
        int inpTinggi = sc.nextInt();
        sc.nextLine();

        System.out.println("Masukkan Lebar");
        System.out.print("> ");
        int inpLebar = sc.nextInt();
        sc.nextLine();

        Balok balok = new Balok (inpPanjang, inpTinggi, inpLebar);

        BangunRuang.reqHitung();
        int inpHitung = sc.nextInt();
        double result = 0;
        switch (inpHitung) {
            case 1:
                result = balok.HitungLuasPermukaan();
                System.out.println("Luas permukaan balok = " + result);
                break;

            case 2:
                result = balok.HitungVolume();
                System.out.println("Volume balok = " + result);
                break;
        
            default:
                break;
        }

        sc.close();
    }
}