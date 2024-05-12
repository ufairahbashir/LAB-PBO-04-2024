package TP7_H071231012.Models;

import TP7_H071231012.Utils.util;

public class Karyawan extends Keluarga {
    String name, occupation = "Karyawan";
    int salary, age;

    public Karyawan() {
    }

    public Karyawan(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Karyawan(String name, String occupation, int salary, int age) {
        this.name = name;
        this.occupation = occupation;
        this.salary = salary;
        this.age = age;
    }

    public Karyawan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        util.batas();
        System.err.println("Detail Karyawan :");
        System.out.println("Nama : " + this.name);
        System.out.println("Umur : " + this.age);
        System.out.println("Status : " + this.status);
        System.out.println("Jumlah Anak : " + this.jumlahAnak);
        System.out.println("Jabatan : " + this.occupation);
        System.out.println("Gaji : " + this.salary);
        util.batas();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
