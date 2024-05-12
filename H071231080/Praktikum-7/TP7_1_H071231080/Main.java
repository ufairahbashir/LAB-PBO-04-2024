import java.util.ArrayList;
import java.util.Scanner;
import Sound.AudioSound;


public class Main { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Karyawan> daftarKaryawan = new ArrayList<>(); // ArrayList untuk menyimpan karyawan yang diterima
        
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Data Karyawan:");
            System.out.println("a. Tambah data Karyawan \nb. Tampilkan detail karyawan \nc. Keluar");
            System.out.print("Pilih opsi (a-c): ");
            
            String opsi = sc.nextLine();
            switch (opsi) {
                case "a":
                    String nama;
                    while(true){
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();
                        if(nama.isEmpty()){
                            System.out.println("inputan kosong, silahkan masukkan nama");
                        }else{
                            break;
                        }
                    }
                    
                    int umur;
                    while (true) {
                        System.out.print("Masukkan umur: ");
                        try {
                            umur = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Input yang dimasukkan bukan angka. Silakan coba lagi.");
                        }
                    }

                    
                    // Proses pengalaman dan pendidikan
                    Pengalaman pengalaman = new Pengalaman();
                    pengalaman.prosesKehidupan();

                    Pendidikan pendidikan = new Pendidikan();
                    pendidikan.prosesPendidikan();

                    Keluarga keluarga = new Keluarga();
                    keluarga.statusKeluarga();

                    // Proses projek
                    Projek projek = new Projek();
                    projek.jenisProjek();
                    
                    
                    int jumlahProjek = projek.getJumlahProjek();
                    String inputPendidikan = pendidikan.getInputPendidikan();
                    int inputPengalaman = pengalaman.getInputPengalaman();
                    String inputOrganisasi = pengalaman.getInputOganisasi();

                
                    if (!inputPendidikan.equalsIgnoreCase("SD") && !inputPendidikan.equalsIgnoreCase("SMP") && jumlahProjek > 4 && umur >= 18 && inputPengalaman != 4 && !inputOrganisasi.isEmpty()) {
                        System.out.println("Pengalaman sedang diproses...");
                        System.out.println("Pendidikan terakhir: " + inputPendidikan);
                        System.out.println("Jumlah projek IT: " + jumlahProjek);
                        AudioSound.playSound("Diterima.wav");
                        System.out.println("============================");
                        System.out.println("Selamat, karyawan diterima!");
                        System.out.println("============================");

                        pengalaman.gajiSebelumnya += 1000000;
                        
                        Karyawan karyawan = new Karyawan(nama, inputPendidikan, umur, pengalaman.getGajiSebelumnya()); // Buat objek karyawan baru
                        
                        daftarKaryawan.add(karyawan); // Tambahkan karyawan ke dalam daftar
                    } else {
                        System.out.println("Karyawan tidak memenuhi syarat.");
                        AudioSound.playSound("TidakDiTerima.wav");
                    }
                    break;
                    
                case "b":

                    if (daftarKaryawan.isEmpty()) {
                        System.out.println("Belum ada data karyawan");
                    } else {
                        System.out.println("Detail Semua Karyawan:");
                        for (Karyawan karyawan : daftarKaryawan) {
                            karyawan.detailKaryawan();
                        }
                    }
                    break;

                case "c":
                    System.out.println("Terima kasih!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Inputan tidak valid. Silahkan masukkan a-c");
            }
        }
        sc.close(); // Menutup scanner setelah digunakan
    }
}
