package TP7_H071231012.Models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Keluarga {
    String status;
    int jumlahAnak;
    Scanner sc = new Scanner(System.in);

    public void status() {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Status (y/t) : ");
                String hubungan = sc.nextLine();
                if (hubungan.equalsIgnoreCase("y")) {
                    this.status = "Sudah Menikah";
                    anak();
                    valid = true;
                } else if (hubungan.equalsIgnoreCase("t")) {
                    this.status = "Belum Menikah";
                    valid = true;
                } else {
                    System.out.println("Inputan Hanya (y/t)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Inputan tidak valid");
                sc.nextLine();
            }
        }
    }

    public void anak() {
        boolean valid1 = false;
        while (!valid1) {
            try {
                System.out.print("Jumlah Anak : ");
                this.jumlahAnak = sc.nextInt();
                sc.nextLine();
                valid1 = true;
            } catch (InputMismatchException e) {
                System.out.println("Inputan tidak valid");
                sc.nextLine();
            }
        }
    }
}
