package TP7_H071231012.Models;

// import java.util.InputMismatchException;

import TP7_H071231012.Utils.util;

public class Pendidikan extends Kehidupan {
    String pendidikan;

    public Pendidikan(String name, int salary, String pendidikan) {
        super(name, salary);
        this.pendidikan = pendidikan;
    }

    public Pendidikan() {
    }

    @Override
    public void prosesKehidupan() {
        if (pendidikan.equals("SD")) {
            System.out.println("Pendidikan Terakhir : SD");
        } else if (pendidikan.equals("SMP")) {
            System.out.println("Pendidikan Terakhir : SMP");
        } else if (pendidikan.equals("SMK")) {
            System.out.println("Pendidikan Terakhir : SMK");
        } else if (pendidikan.equals("SMA")) {
            System.out.println("Pendidikan Terakhir : SMA");
        } else if (pendidikan.equals("S1")) {
            System.out.println("Pendidikan Terakhir : S1");
        } else if (pendidikan.equals("S2")) {
            System.out.println("Pendidikan Terakhir : S2");
        } else if (pendidikan.equals("S2")) {
            System.out.println("Pendidikan Terakhir : S3");
        }
    }

    public void pendidikanKaryawan() {
        boolean hentikan = false;
        while (!hentikan) {
            try {
                boolean a = false;
                while (!a) {
                    util.isiPendidikan();
                    this.pendidikan = sc.nextLine();

                    if (pendidikan.equals("SD")) {
                        this.nilaiPlus = 0;
                        hentikan = true;
                        a = true;
                    } else if (pendidikan.equals("SMP")) {
                        this.nilaiPlus = 0;
                        hentikan = true;
                        a = true;
                    } else if (pendidikan.equals("SMK")) {
                        this.nilaiPlus = 1;
                        hentikan = true;
                        a = true;
                    } else if (pendidikan.equals("SMA")) {
                        this.nilaiPlus = 1;
                        hentikan = true;
                        a = true;
                    } else if (pendidikan.equals("S1")) {
                        this.nilaiPlus = 1;
                        hentikan = true;
                        a = true;
                    } else if (pendidikan.equals("S2")) {
                        this.nilaiPlus = 1;
                        hentikan = true;
                        a = true;
                    } else if (pendidikan.equals("S3")) {
                        this.nilaiPlus = 1;
                        hentikan = true;
                        a = true;
                    } else {
                        System.out.println("Pilihan hanya (SD/SMP/SMA/SMK/S1/S2/S3)");
                    }
                }
            } catch (Exception e) {
                System.out.println("Inputan Tidak Menerima Angka");
                sc.nextLine();
            }
        }
    }
}
