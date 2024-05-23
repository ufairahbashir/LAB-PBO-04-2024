import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class Karyawan {
    private String nama;
    private int umur;
    private String jabatan;
    private double gaji;
    private Pengalaman pengalaman;
    private Pendidikan pendidikanTerakhir;
    private Projek projek;
    private Keluarga keluarga;

    public Keluarga getKeluarga() {
        return keluarga;
    }

    public void setKeluarga(Keluarga keluarga) {
        this.keluarga = keluarga;
    }

    public Karyawan(String nama, int umur, String jabatan, double gaji) {
        this.nama = nama;
        this.umur = umur;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    public Karyawan(String nama, int umur, String jabatan, int gaji) {
        this.nama = nama;
        this.umur = umur;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public Pengalaman getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(Pengalaman pengalaman) {
        this.pengalaman = pengalaman;
    }

    public Pendidikan getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(Pendidikan pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public Projek getProjek() {
        return projek;
    }

    public void setProjek(Projek projek) {
        this.projek = projek;
    }
}

abstract class Kehidupan {
    abstract void prosesKehidupan();
}

class Pengalaman extends Kehidupan {
    private String jenisPekerjaan;
    private String PengalamanOrganisasi;

    public Pengalaman(String jenisPekerjaan, String pengalamanOrganisasi) {
        this.jenisPekerjaan = jenisPekerjaan;
        this.PengalamanOrganisasi = pengalamanOrganisasi;
    }

    @Override
    void prosesKehidupan() {
        System.out.println("Proses Pengalaman");
    }

    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    public void setJenisPekerjaan(String jenisPekerjaan) {
        this.jenisPekerjaan = jenisPekerjaan;
    }

    public String getPengalamanOrganisasi() {
        return PengalamanOrganisasi;
    }

    public void setPengalamanOrganisasi(String pengalamanOrganisasi) {
        PengalamanOrganisasi = pengalamanOrganisasi;
    }
}

class Pendidikan {
    private String StrataPendidikan;

    public Pendidikan(String strataPendidikan) {
        StrataPendidikan = strataPendidikan;
    }

    public String getStrataPendidikan() {
        return StrataPendidikan;
    }

    public void setStrataPendidikan(String strataPendidikan) {
        StrataPendidikan = strataPendidikan;
    }

}

class Projek {
    private int jumlahProjek;

    public Projek(int jumlahProjek) {
        this.jumlahProjek = jumlahProjek;
    }

    public int getJumlahProjek() {
        return jumlahProjek;
    }

    public void setJumlahProjek(int jumlahProjek) {
        this.jumlahProjek = jumlahProjek;
    }

    void prosesProjek() {
        System.out.println("Proses Projek");
    }
}

class Keluarga {
    private String menikah, istri;
    
    private int  anak;
    
    public Keluarga(String menikah, String istri, int anak) {
        this.menikah = menikah;
        this.istri = istri;
        this.anak = anak;
    }
    
    public String isMenikah() {
        return menikah;
    }
    
    public void setMenikah(String menikah) {
        this.menikah = menikah;
    }
    public String getIstri() {
        return istri;
    }

    public void setIstri(String istri) {
        this.istri = istri;
    }

    

    public int getAnak() {
        return anak;
    }

    public void setAnak(int anak) {
        this.anak = anak;
    }

    double Tunjangan() {
        return (anak * 100);
    }

    void Tunjangan1() {
        int Bonus = (anak * 100);
        System.out.println(
                "Tunjangan yang diteriman karena memiliki " + " istri dan " + anak + " anak adalah: " + Bonus);
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu Utama:");
            System.out.println("a. Tambah data karyawan");
            System.out.println("b. Tampilkan detail karyawan");
            System.out.println("c. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = readLine();

            switch (pilihan) {
                case "a":
                    tambahDataKaryawan();
                    break;
                case "b":
                    tampilkanDetailKaryawan();
                    break;
                case "c":
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tambahDataKaryawan() {
        System.out.print("Masukkan nama karyawan: ");
        String nama = readLine();
        System.out.print("Masukkan umur karyawan: ");
        int umur = readInt();
        System.out.print("Masukkan jabatan karyawan: ");
        String jabatan = readLine();
        System.out.print("Masukkan gaji karyawan: ");
        double gaji = readDouble();

        System.out.println("Masukkan pengalaman karyawan:");
        System.out.println("a. Freelance");
        System.out.println("b. Magang");
        System.out.println("c. Pegawai Tetap");
        System.out.println("d. Tidak Bekerja");
        System.out.print("Pilih jenis pengalaman: ");
        String jenisPengalaman = readLine();

        System.out.println(
                "Masukkan pengalaman berorganisasi Karyawan(Wajib Ada Untuk Diterima. Dan tulis tidak ada jika tidak ada pengalaman.)");
        String OrganisasiKry = readLine();

        System.out.println("Masukkan pendidikan terakhir karyawan:");
        System.out.println("SD/SMP/SMA/S1/S2/S3");
        String Terakhir = read();
        String pendidikanTerakhir = Terakhir.toUpperCase();

        System.out.println("Masukkan jumlah projek IT yang telah terselesaikan(Minimal 4 untuk memenuhi kriteria):");
        System.out.print("Jumlah projek: ");
        int jumlahProjek = readInt();

        
        
        Karyawan karyawan = new Karyawan(nama, umur, jabatan, gaji);
        
        Pengalaman pengalaman = new Pengalaman(jenisPengalaman, OrganisasiKry);
        Projek projek = new Projek(jumlahProjek);
        Pendidikan pendidikan = new Pendidikan(pendidikanTerakhir);
        
        System.out.println("Apakah sudah menikah? Y/T");
        String status = readLine();
        switch (status) {
            case "Y":
            System.out.print("Masukkan Nama Istri: ");
            String Istri = readLine();
            System.out.print("Masukkan jumlah anak nya: ");
            int Anak = readInt();
            Keluarga keluarga = new Keluarga(status, Istri, Anak);
            keluarga.Tunjangan1();
            karyawan.setKeluarga(keluarga);
                break;
            case "T":
            System.out.println("Tidak menikah == tidak dapat tunjangan.");
        
            default:
                break;
        }
        
        karyawan.setPengalaman(pengalaman);
        karyawan.setPendidikanTerakhir(pendidikan);
        karyawan.setProjek(projek);
        

        boolean lulus = evalPersyaratanLulus(karyawan);
        if (lulus) {
            daftarKaryawan.add(karyawan);
            System.out.println("=========================================================");
            System.out.println("Data karyawan berhasil ditambahkan.");
            System.out.println("=========================================================");
            try {

                File soundFile = new File(
                        "C:\\Users\\Rezky Robbyyanto A\\algoritma_dan_pemograman\\JAVA_SMES2\\Tugas_Praktikum\\TP7\\Diterima.wav");

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

                Clip clip = AudioSystem.getClip();

                clip.open(audioInputStream);

                clip.start();

                Thread.sleep(clip.getMicrosecondLength() / 500);

                clip.stop();

                audioInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("=========================================================");
            System.out.println("Maaf, karyawan tidak memenuhi persyaratan untuk diterima.");
            System.out.println("=========================================================");
            try {

                File soundFile = new File(
                        "C:\\Users\\Rezky Robbyyanto A\\algoritma_dan_pemograman\\JAVA_SMES2\\Tugas_Praktikum\\TP7\\GAgal.wav");

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

                Clip clip = AudioSystem.getClip();

                clip.open(audioInputStream);

                clip.start();

                Thread.sleep(clip.getMicrosecondLength() / 500);

                clip.stop();

                audioInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean evalPersyaratanLulus(Karyawan karyawan) {
        if (karyawan.getUmur() > 18 && karyawan.getProjek().getJumlahProjek() >= 4 &&
                (!karyawan.getPendidikanTerakhir().getStrataPendidikan().equals("SD") &&
                        !karyawan.getPendidikanTerakhir().getStrataPendidikan().equals("SMP"))
                && !karyawan.getPengalaman().getPengalamanOrganisasi().equals("tidak ada")) {
            return true;
        } else {
            return false;
        }
    }

    public static void tampilkanDetailKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan yang tersimpan.");
            return;
        }

        System.out.println("Daftar Karyawan:");
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            Karyawan karyawan = daftarKaryawan.get(i);
            System.out.println("Karyawan ke-" + (i + 1));
            System.out.println("Nama: " + karyawan.getNama());
            System.out.println("Umur: " + karyawan.getUmur());
            System.out.println("Jabatan: " + karyawan.getJabatan());
            System.out.println("Gaji: " + (karyawan.getGaji()+karyawan.getKeluarga().Tunjangan()));
            System.out.println("Pengalaman: " + karyawan.getPengalaman().getJenisPekerjaan());
            System.out.println("Pendidikan Terakhir: " + karyawan.getPendidikanTerakhir().getStrataPendidikan());
            System.out.println("Jumlah Projek IT: " + karyawan.getProjek().getJumlahProjek());
            System.out.println();
        }
    }

    public static int readInt() {
        while (true) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
                continue;
            }
            try {
                int input = Integer.parseInt(next);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka");
            }
        }
    }

    public static String readLine() {
        String input = sc.nextLine();
        while (input.isEmpty() || containNumber(input)) {
            if (input.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
            } else {
                System.out.println("Tidak boleh ada angka");
            }
            input = sc.nextLine();
        }
        return input;
    }

    public static String read() {
        String input = sc.nextLine();
        while (input.isEmpty()) {
            if (input.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
            }
            input = sc.nextLine();
        }
        return input;
    }

    public static double readDouble() {
        while (true) {
            String next = sc.nextLine();
            if (next.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
                continue;
            }
            try {
                double input = Double.parseDouble(next);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka");
            }
        }
    }

    public static boolean containNumber(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}