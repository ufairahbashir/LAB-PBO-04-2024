package TP7_H071231012.Utils;

public class util {
    public static void dataKaryawan() {
        System.out.println("Data Karyawan : ");
        System.out.println("a. Tambah Data Karyawan");
        System.out.println("b. Tampilkan Detail karyawan");
        System.out.println("c. Cek Gaji");
        System.out.println("d. keluar");
        System.out.print("Pilih Opsi (a-d) : ");

    }

    public static void isiPengalaman() {
        System.out.println("Pengalaman sebelumnya :");
        System.out.println("1. Freelance");
        System.out.println("2. Magang");
        System.out.println("3. Pekrja Tetap");
        System.out.println("4. Tidak Ada");
        System.out.print("input : ");
    }

    public static void isiPendidikan() {
        System.out.print("Pendidikan terakhir (SD/SMP/SMA/SMK/S1/S2/S3) : ");

    }

    public static void isiProjek() {
        System.out.println("Projek IT :");
        System.out.println("1. Minimal 4");
        System.out.println("2. Minimal 8");
        System.out.println("3. Minimal 12");
        System.out.println("4. Lebih Dari 15");
        System.out.print("Input : ");
    }

    public static void karyawanDitolak() {
        System.out.println("Karyawan tidak memenuhi syarat.");
    }

    public static void tidakAdaData() {
        System.out.println("Belum ada data karyawan.");
    }

    public static void sedangProses() {
        System.out.println("Pengalaman sedang diproses...");
    }

    public static void karyawanDiterima() {
        System.out.println("Selamat, Karyawan diterima!");
    }

    public static void batas() {
        System.out.println("==============================");
    }

    public static void jumlahGaji() {
        System.out.print("Gaji Sebelumnya : ");
    }

    public static void nama() {
        System.out.print("Masukkan nama : ");
    }

    public static void umur() {
        System.out.print("Masukkan umur : ");
    }

    public static void selamatTinggal() {
        System.out.println("Terima Kasih Sudah Mendaftar");
    }

    public static void isiOrganisasi() {
        System.out.print("Pengalaman Organisasi (Jika tidak ada ketik 'Tidak Ada'): ");

    }
}