
import java.util.Scanner;
import java.util.ArrayList;
import models.AnggotaPerpustakaan;
import models.Buku;

public class Perpustakaan {
    public static ArrayList<Buku> katalog = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== DETAIL ANGGOTA ===");
        System.out.println("Nama Anggota     : ");
        String namaAnggota = sc.nextLine();

        System.out.println("Alamat           : ");
        String alamatAnggota = sc.nextLine();

        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(namaAnggota, alamatAnggota);
        System.out.println("=== MASUKKAN DETAIL BUKU ===");
        System.out.println("Judul Buku                 : ");
        String judul = sc.nextLine();

        System.out.println("Pengarang                  : ");
        String pengarang = sc.nextLine();

        String input;
        int jumlahHalaman = 0;
        do {
            System.out.println("Masukkan Jumlah Halaman :");
            input = sc.nextLine();

            if (!input.isEmpty()) {
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    jumlahHalaman = Integer.parseInt(input);
                } else {
                    System.out.println("Input harus berupa angka");
                }
            } else {
                System.out.println("Inputan kosong. Tolong masukkan angka.");
            }
        } while (!input.matches("-?\\d+(\\.\\d+)?"));
        

            System.out.println("Apakah buku fiksi? (true/false)");
            boolean isFiksi = sc.nextBoolean();
            sc.nextLine();


        Buku buku = new Buku(judul, pengarang, jumlahHalaman, isFiksi);
        katalog.add(buku);
        anggota.pinjamBuku(buku);
        anggota.daftarBukuPinjaman();
        anggota.tampilkanInfoAnggota();
        System.out.println("Jumlah buku yg dipinjam " + anggota.judulBukuDipinjam());
        System.out.println("Jumlah buku fiksi " + anggota.jumlahBukuFiksiDipinjam());
        System.out.println("Jumlah buku non fiksi " + anggota.jumlahBukuNonFiksi());
        sc.close();

    }
}
