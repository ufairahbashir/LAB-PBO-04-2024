import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private int usia;
    private String jurusan;
    private double ipk;

    public Mahasiswa() {
        this.nama = "Belum diisi";
        this.usia = 0;
        this.jurusan = "Belum diisi";
        this.ipk = 0.0;
    }

    public Mahasiswa(String nama, int usia, String jurusan, double ipk) {
        this.nama = nama;
        this.usia = usia;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Behavior 1
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
    }

    // Behavior 2
    public void tambahIPK(double nilaiTambah) {
        ipk += nilaiTambah;
    }

    // Behavior 3
    public void cekLulus() {
        if (ipk >= 3.9) {
            System.out.println("Selamat, anda lulus!");
        } else {
            System.out.println("Maaf, anda belum lulus.");
        }
    }

    // Behavior 4
    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan nama: ");
            String inputNama = scanner.nextLine();
            if (inputNama.matches("[a-zA-Z]+")) { // Memeriksa apakah input hanya terdiri dari huruf
                nama = inputNama;
            } else {
                System.out.println("Input tidak valid! Nama harus berupa huruf.");
                return; // Keluar dari method jika input tidak valid
            }

            System.out.print("Masukkan usia: ");
            usia = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan jurusan: ");
            jurusan = scanner.nextLine();

            System.out.print("Masukkan IPK: ");
            ipk = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid! Masukkan angka untuk usia dan IPK.");
        }
    }

    // Behavior 5
    public void perbaruiInfo(String nama, int usia, String jurusan, double ipk) {
        this.nama = nama;
        this.usia = usia;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Behavior 6
    public void tampilkanStatus() {
        System.out.println("Status: " + (ipk >= 3.0 ? "Lulus" : "Belum Lulus"));
    }
}

public class TP4_2_H071231012 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("-----Input Data Mahasiswa-----");
        mahasiswa.inputInfo();

        System.out.println("\n-----Informasi Mahasiswa-----");
        mahasiswa.displayInfo();
        mahasiswa.cekLulus();

        scanner.close();
    }
}
