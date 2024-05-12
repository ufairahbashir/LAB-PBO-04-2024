import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            String opsi = scan.nextLine().toLowerCase();

            switch (opsi) {
                case "a":
                    tambahDataKaryawan(scan, daftarKaryawan);
                    break;
                case "b":
                    tampilkanDetailKaryawan(daftarKaryawan);
                    break;
                case "c":
                    keluarProgram();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Inputan tidak valid. Silahkan masukkan a-c");
            }
        }

        scan.close();
    }

    // Input dan validasi inputan bertipe data integer
    public static int inputInt(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine();
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        }
    }

    // Input dan validasi inputan bertipe data String
    public static String inputString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
            } else {
                return input;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("-----------------------------------");
        System.out.println("           DATA KARYAWAN");
        System.out.println("-----------------------------------");
        System.out.println("a. Tambah Data Karyawan");
        System.out.println("b. Tampilkan Detail Karyawan");
        System.out.println("c. Keluar");
        System.out.print("Pilih Opsi (a-c) : ");
    }

    //overload
    public static void tambahDataKaryawan(Scanner scan, ArrayList<Karyawan> daftarKaryawan) {
        String nama = inputString(scan, "Masukkan Nama                     : ");
        int umur = inputInt(scan, "Masukkan Umur                     : ");
        boolean statusMenikah = inputStatusMenikah(scan, "Apakah sudah menikah? (iya/tidak) : "); // Ambil input status menikah
        
        // Memanggil metode tambahDataKaryawan() yang memiliki lebih banyak parameter
        tambahDataKaryawan(nama, umur, daftarKaryawan, statusMenikah, scan);
    }
    
    public static void tambahDataKaryawan(String nama, int umur, ArrayList<Karyawan> daftarKaryawan, boolean statusMenikah, Scanner scan) {
        // Proses pengalaman dan pendidikan
        Pengalaman pengalaman = new Pengalaman();
        pengalaman.prosesKehidupan();
        pengalaman.sertifikasi();
    
        Pendidikan pendidikan = new Pendidikan();
        pendidikan.prosesKehidupan();
    
        // Proses projek
        Projek projek = new Projek();
        projek.prosesKehidupan();
        int jumlahProjek = projek.getJumlahProjek();
        String inputPendidikan = pendidikan.getInputPendidikan();
    
        if (!inputPendidikan.equalsIgnoreCase("SD") && !inputPendidikan.equalsIgnoreCase("SMP") && jumlahProjek > 4 && umur >= 18) {
            System.out.println("Pengalaman sedang diproses...");
            System.out.println("Pendidikan terakhir : " + inputPendidikan);
            System.out.println("Jumlah projek IT    : " + jumlahProjek);
            System.out.println("-----------------------------------");
            System.out.println("    SELAMAT, KARYAWAN DITERIMA");
            System.out.println("-----------------------------------");
            AudioPlayer audioPlayer = new AudioPlayer();
            audioPlayer.playAudio("Audio/Accept.wav");
            
            pengalaman.gajiSebelumnya += 2500000;
            
            // Membuat objek Karyawan dengan jabatan "karyawan"
            Karyawan karyawan = new Karyawan(nama, umur,"Karyawan", pengalaman.gajiSebelumnya, statusMenikah, pengalaman.sertifikasiLainnya);
            daftarKaryawan.add(karyawan); // Menambahkan karyawan ke daftar
        } else {
            System.out.println("Karyawan tidak memenuhi syarat.");
            AudioPlayer audioPlayer = new AudioPlayer();
            audioPlayer.playAudio("Audio/Reject.wav");
            System.out.println("-----------------------------------");
            System.out.println("     MAAF, ANDA TIDAK DITERIMA");
            System.out.println("-----------------------------------");
        }
    }    
    
    private static void tampilkanDetailKaryawan(ArrayList<Karyawan> daftarKaryawan) {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
        } else {
            System.out.println("-----------------------------------");
            System.out.println("       DETAIL SEMUA KARYAWAN       ");
            System.out.println("-----------------------------------");
            for (Karyawan karyawan : daftarKaryawan) {
                // Memanggil metode tampilkanDetilKaryawan() dari setiap objek Karyawan
                System.out.println("Nama           : " + karyawan.getNama());
                System.out.println("Umur           : " + karyawan.getUmur());
                System.out.println("Jabatan        : " + karyawan.getJabatan());
                System.out.println("Gaji           : " + karyawan.getGaji());
                System.out.println("Sertifikasi    : " + karyawan.getSertifikasi());
                System.out.println("Status Menikah : " + (karyawan.isStatusMenikah() ? "Sudah Menikah" : "Belum Menikah"));
                System.out.println();
            }
        }
    }

    public static boolean inputStatusMenikah(Scanner scan, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine().toLowerCase().trim();
            if (input.equals("iya")) {
                return true;
            } else if (input.equals("tidak")) {
                return false;
            } else {
                System.out.println("Input tidak valid. Silakan masukkan 'iya' atau 'tidak'.");
            }
        }
    }

    private static void keluarProgram() {
        System.out.println("-----------------------------------------------");
        System.out.println("TERIMAKASIH SUDAH MENGGUNAKAN APLIKASI KARYAWAN");
        System.out.println("-----------------------------------------------");
    }
}