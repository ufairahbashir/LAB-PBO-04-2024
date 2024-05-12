package Livecode7;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {
    static Karyawan karyawan = new Karyawan();
    static ArrayList<Karyawan> karyawanList = new ArrayList<>();
    static Pengalaman pengalaman = new Pengalaman();
    static Pendidikan pendidikan = new Pendidikan();
    static Proyek proyek = new Proyek();
    static Keluarga keluarga = new Keluarga();

    public static void main(String[] args) throws InterruptedException {
        menu();
    }

    private static void menu() throws InterruptedException {
        while (true) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Menu:");
                System.out.println("a. Tambah data karyawan");
                System.out.println("b. Tampilkan detail karyawan");
                System.out.println("c. Keluar");
                System.out.print("Pilih opsi (a-c): ");
                String opsi = sc.nextLine().strip();
                switch (opsi) {
                    case "a":
                        tambahKaryawan(sc);
                        break;
                    case "b":
                        System.out.println();
                        if (karyawanList.isEmpty()) { 
                            System.out.println("Belum ada data karyawan.\n"); 
                            menu(); 
                        }else{
                            pengalaman.prosesKehidupan(); 
                            menu();
                        }    
                        break;
                    case "c":
                        System.out.println("\nProgram selesai.\n");
                        System.exit(0);
                    default:
                        System.out.println("Invalid opsi.\n");
                        menu();
                        break;
                }
            }
        }
    }

    private static void tambahKaryawan(Scanner sc) throws InterruptedException {
        String riwayatPekerjaan = new String();
        ArrayList<String> sertifikat = new ArrayList<>();
        ArrayList<String> organisasi = new ArrayList<>();

        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();

        int umur;
        while (true) {
            try {
                System.out.print("Masukkan umur: ");
                String test = sc.nextLine().strip();

                if (test.isEmpty()) {
                    System.out.println("Umur tidak boleh kosong.\n");
                    continue;
                }
                umur = Integer.parseInt(test);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Umur harus integer.\n");
            }
        }

        int gaji;
        while (true) {
            try {
                System.out.print("Masukkan gaji sebelumnya: ");
                String gaji1 = sc.nextLine().strip();

                if (gaji1.isEmpty()) {
                    System.out.println("Gaji tidak boleh kosong.\n");
                    continue;
                }
                gaji = Integer.parseInt(gaji1);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Gaji harus integer.\n");
            }
        }

        System.out.print("Masukkan jabatan sebelumnya: ");
        String jabatan = sc.nextLine();
        System.out.println("Pengalaman Sebelumnya: ");
        System.out.println("1. Freelancer");
        System.out.println("2. Magang");
        System.out.println("3. Pekerja tetap");
        System.out.println("4. Tidak ada");
        System.out.print("input: ");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1:
                riwayatPekerjaan="Freelancer";
                break;
            case 2:
                riwayatPekerjaan="Magang";
                break;
            case 3:
                riwayatPekerjaan="Pekerja tetap";
                break;
            case 4:
                System.out.println("Karyawan tidak memenuhi syarat.\n");
                playSound("SoundFiles/TidakDiterima.wav");
                menu();
            default:
                System.out.println("Inputan harus 1, 2, 3, atau 4.");
                sc.nextLine();
        }

        System.out.println("Masukkan sertifikat (isi '-' jika tidak ada/enter jika telah selesai): ");
        while (true) {
            String sertif = sc.nextLine();
            if (sertif.equals("-") || sertif.isEmpty()) break;
            sertifikat.add(sertif);
        }

        System.out.println("Masukkan organisasi (isi '-' jika tidak punya/enter jika telah selesai): ");
        while(true) {
            String organisasi1 = sc.nextLine();
            if (organisasi1.equals("-") || organisasi1.isEmpty()) break;
            organisasi.add(organisasi1);
        }
        
        String pendidikanTerakhir;
        while (true) {
            System.out.print("Pendidikan terakhir (SD/SMP/SMA/SMK/S1/S2/S3): ");
            pendidikanTerakhir = sc.nextLine();
            String[] validEducations = {"SD", "SMP", "SMA", "SMK", "S1", "S2", "S3"};
            if (Arrays.asList(validEducations).contains(pendidikanTerakhir.toUpperCase())) {
               break;
            } else{
                 System.out.println("Input tidak valid.\n");
            }
        }

        System.out.print("Proses");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println();

        if (pendidikanTerakhir.equals("SD") || pendidikanTerakhir.equals("SMP") || umur < 18) {
            System.out.println("Karyawan tidak memenuhi syarat.\n");
            playSound("SoundFiles/TidakDiterima.wav");
            menu();
        }

        System.out.print("Dari sekolah/kampus: ");
        String TempatPendidikan = sc.nextLine();
        int totalProyek;
        while (true) {
            try {
                System.out.println("Proyek IT");
                System.out.println("1. Minimal 4");
                System.out.println("2. Minimal 8");
                System.out.println("3. Minimal 12");
                System.out.println("4. Minimal 15");
                System.out.print("input: ");
                int opsi = sc.nextInt();
                sc.nextLine();

                if (opsi == 1) { 
                    totalProyek = 4; 
                }else if (opsi == 2) { 
                    totalProyek = 8; 
                }else if (opsi == 3) {
                    totalProyek = 12; 
                }else if (opsi == 4) { 
                    totalProyek = 15; 
                }else { 
                    System.out.println("Hanya ada opsi 1-4.\n"); 
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Opsi harus angka.\n");
                sc.nextLine();
            }
        }

        String sudahMenikah;
        int jumlahAnak = 0;

        while (true) {
            System.out.print("Apakah sudah menikah? (Y/N): ");
            sudahMenikah = sc.nextLine().strip().toLowerCase();

            if (sudahMenikah.equals("y")) {    
                while (true) {
                    try {
                        System.out.print("Jumlah anak: ");
                        String test = sc.nextLine().strip();

                        if (test.isEmpty()) {
                            System.out.println("Jumlah anak tidak boleh kosong.\n");
                            continue;
                        }
                        jumlahAnak = Integer.parseInt(test);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Jumlah anak harus integer.\n");
                    }
                }
                keluarga.setMenikah(true);
                break;
            } else if (sudahMenikah.equals("n")) {
                keluarga.setMenikah(false);
                break;
            } else {
                System.out.println("Hanya dua pilihan 'y' atau 'n'.");
                continue;
            }
        }

        System.out.print("Proses");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println();

        if (totalProyek <= 4) {
            System.out.println("Maaf, calon karyawan tidak memenuhi syarat.\n");
            playSound("SoundFiles/TidakDiterima.wav");
        } else {
            karyawan.nama = nama;
            karyawan.umur = umur;
            karyawan.gaji = gaji;
            karyawan.jabatan = jabatan;

            pendidikan.setPendidikan(pendidikanTerakhir, TempatPendidikan);
            proyek.setTotalProjek(totalProyek);

            pengalaman.setKaryawan(karyawan);
            pengalaman.setPendidikan(pendidikan);
            pengalaman.setProyek(proyek);
            pengalaman.pengalamanKerja(riwayatPekerjaan);
            pengalaman.pengalamanKerja(sertifikat, organisasi);

            keluarga.setJumlahAnak(jumlahAnak);

            System.out.println("Selamat! karyawan diterima.\n");
            playSound("SoundFiles/Diterima.wav");
            karyawanList.add(karyawan);
        }
        menu();
    }

    private static void playSound(String soundFile) {
        File file = new File(soundFile);
        Clip clip = null;
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e){
            e.printStackTrace();
        }

        if (clip != null) {
            clip.start();
            while (!clip.isRunning()) {
                Thread.yield();
            }
            while (clip.isRunning()) {
                Thread.yield();
            }
            clip.close();
        }
    }
}