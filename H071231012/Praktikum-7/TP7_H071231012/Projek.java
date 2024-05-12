package TP7_H071231012.Models;

import java.util.InputMismatchException;

import TP7_H071231012.Utils.util;

public class Projek extends Kehidupan {
    int jumlah;

    public Projek(String name, int salary, int jumlah) {
        super(name, salary);
        this.jumlah = jumlah;
    }

    public Projek() {

    }

    @Override
    public void prosesKehidupan() {
        switch (jumlah) {
            case 1:
                System.out.println("Jumlah projek IT : 4");
                break;
            case 2:
                System.out.println("Jumlah projek IT : 8");
                break;
            case 3:
                System.out.println("Jumlah projek IT : 12");
                break;
            case 4:
                System.out.println("Jumlah projek IT : Lebih Dari 15");
                break;
            default:
                break;
        }
    }

    public void jumlahProjek() {
        boolean hentikan = false;
        while (!hentikan) {
            try {
                boolean a = false;
                while (!a) {
                    util.isiProjek();
                    jumlah = sc.nextInt();
                    sc.nextLine();

                    switch (jumlah) {
                        case 1:
                            this.nilaiPlus = 0;
                            hentikan = true;
                            a = true;
                            break;
                        case 2:
                            this.nilaiPlus = 1;
                            hentikan = true;
                            a = true;
                            break;
                        case 3:
                            this.nilaiPlus = 1;
                            hentikan = true;
                            a = true;
                            break;
                        case 4:
                            this.nilaiPlus = 1;
                            hentikan = true;
                            a = true;
                            break;
                        default:
                            System.out.println("Pilihan hanya (1-4)!");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Inputan Hanya Menerima Angka");
                sc.nextLine();
            }

        }
    }
}
