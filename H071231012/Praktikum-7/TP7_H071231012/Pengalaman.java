package TP7_H071231012.Models;

import java.util.InputMismatchException;

import TP7_H071231012.Utils.util;

public class Pengalaman extends Kehidupan {

    int pengalaman;

    public Pengalaman(String name, int salary, int pengalaman) {
        super(name, salary);
        this.pengalaman = pengalaman;
    }

    public Pengalaman(String name, int salary) {
        super(name, salary);
    }

    public Pengalaman() {
    }

    @Override
    public void prosesKehidupan() {
        if (pengalaman == 1) {
            System.out.println("Freelancer");
        } else if (pengalaman == 2) {
            System.out.println("Magang");
        } else if (pengalaman == 3) {
            System.out.println("Kerja tetap");
        } else if (pengalaman == 4) {
            System.out.println("Tidak Ada");
        }

    }

    public void organisasi() {
        util.isiOrganisasi();
        String organisasi = sc.nextLine();
        if (organisasi.equalsIgnoreCase("Tidak Ada")) {
            this.nilaiPlus = 0;
        } else {
            this.nilaiPlus = 1;
        }

    }

    public void pengalamanKerja() {
        boolean hentikan = false;
        while (!hentikan) {
            try {
                boolean a = false;
                while (!a) {
                    util.isiPengalaman();
                    this.pengalaman = sc.nextInt();
                    sc.nextLine();

                    if (pengalaman >= 1 && pengalaman <= 3) {
                        util.jumlahGaji();
                        this.salary = sc.nextInt();
                        sc.nextLine();
                        hentikan = true;
                        a = true;
                    } else if (pengalaman == 4) {
                        organisasi();
                        hentikan = true;
                        a = true;

                    } else {
                        System.out.println("Pilihan hanya dari 1-4");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Inputan Hanya Menerima Angka");
                sc.nextLine();
            }
        }
    }

    public int getPengalaman() {
        return pengalaman;
    }

}
