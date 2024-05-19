import java.util.*;
import javax.sound.sampled.*;

abstract class Kehidupan {
    abstract void prosesKehidupan();
}

class Keluarga extends Kehidupan {
    String menikah;
    int anak;

    String getMenikah() {
        return menikah;
    }

    int getAnak() {
        return anak;
    }

    void setMenikah(String menikah) {
        this.menikah = menikah;
    }

    void setAnak(int anak) {
        this.anak = anak;
    }

    Scanner sc = new Scanner(System.in);

    void menikah() {
        String cekNikah;
        System.out.print("Menikah (y/t) : ");
        do {
            cekNikah = sc.nextLine().toLowerCase();
        } while (cekNikah.isEmpty());

        if (cekNikah.equals("y")) {
            anak();
            setMenikah("Sudah menikah");
        } else if (cekNikah.equals("t")) {
            setMenikah("Belum menikah");
            setAnak(0);
        }
    }

    void anak() {
        try {
            System.out.print("Jumlah Anak : ");
            setAnak(sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Inputan harus angka");
            anak();
        }
    }

    void prosesKehidupan() {
        menikah();
    }
}

// Class Pendidikan extends Kehidupan
class Pendidikan extends Kehidupan {
    String[] listPendidikan = { "SD", "SMP", "SMA", "SMK", "S1", "S2", "S3" };
    int pendidikan;

    int getPendidikan() {
        return pendidikan;
    }

    void setPendidikan(int pendidikan) {
        this.pendidikan = pendidikan;
    }

    Scanner sc = new Scanner(System.in);

    void prosesKehidupan() {
        System.out.print("Pendidikan terakhir (SD/SMP/SMA/SMK/S1/S2/S3): ");
        boolean validInput = false;
        while (!validInput) {
            String input = sc.nextLine().toUpperCase();
            for (int i = 0; i < listPendidikan.length; i++) {
                if (input.equals(listPendidikan[i])) {
                    pendidikan = i;
                    validInput = true;
                    break;
                }
            }
            if (!validInput) {
                System.out.println("Pilihan tidak ada. Masukkan kembali: ");
            }
        }
    }
}

class Projek extends Kehidupan {
    int projek;

    int getProyek() {
        return projek;
    }

    void setProyek(int projek) {
        this.projek = projek;
    }

    Scanner sc = new Scanner(System.in);

    void prosesKehidupan() {
        try {
            System.out.print("Proyek IT :\n1. Minimal 4\n2. Minimal 8\n3. Minimal 12\n4. Lebih dari 15\nInput : ");
            int jProjek = sc.nextInt();
            if (jProjek == 1) {
                setProyek(4);
            } else if (jProjek == 2) {
                setProyek(8);
            } else if (jProjek == 3) {
                setProyek(12);
            } else if (jProjek == 4) {
                setProyek(15);
            } else {
                System.out.println("Input diluar pilihan!");
                prosesKehidupan();
            }
        } catch (InputMismatchException e) {
            System.out.println("Hanya menerima integer");
            sc.nextLine();
            prosesKehidupan();
        }
    }
}

// Class Pengalaman extends Kehidupan
class Pengalaman extends Kehidupan {
    String pengalaman;
    String organisasi;

    String getPengalaman() {
        return pengalaman;
    }

    void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    String getOrganisasi() {
        return organisasi;
    }

    void setOrganisasi(String organisasi) {
        this.organisasi = organisasi;
    }

    Scanner scanner = new Scanner(System.in);

    void jenisPekerjaan() {
        try {
            System.out.println("Pengalaman sebelumnya :\n1. Freelancer\n2. Magang\n3. Pekerja tetap\n4.Tidak ada");
            System.out.print("input: ");
            int kerja = scanner.nextInt();
            if (kerja == 1) {
                setPengalaman("Freelancer");
            } else if (kerja == 2) {
                setPengalaman("Magang");
            } else if (kerja == 3) {
                setPengalaman("Pekerja tetap");
            } else if (kerja == 4) {
                setPengalaman("Tidak ada");
            } else {
                System.out.println("Input diluar pilihan!");
                jenisPekerjaan();
            }
        } catch (InputMismatchException e) {
            System.out.println("Hanya menerima integer");
            scanner.nextLine();
            jenisPekerjaan();
        }
    }

    void organisasi() {
        try {
            System.out.print("pengalaman berorganisasi:\n1. Ada\n2. Tidak ada\ninput: ");
            int organisasi = scanner.nextInt();
            if (organisasi == 1) {
                System.out.print("Masukkan organisasi: ");
                do {
                    setOrganisasi(scanner.nextLine());
                } while (getOrganisasi().isEmpty());
            } else if (organisasi == 2) {
                setOrganisasi("Tidak ada");
            } else {
                System.out.println("Input diluar pilihan!");
                organisasi();
            }
        } catch (InputMismatchException e) {
            System.out.println("Hanya menerima integer");
            scanner.nextLine();
            organisasi();
        }
    }

    void prosesKehidupan() {
        jenisPekerjaan();
        organisasi();
    }
}

// Class Karyawan extends Kehidupan
class Karyawan extends Kehidupan {
    String nama;
    int umur;
    String jabatan;
    int gaji;
    String namaPasangan;
    List<String> namaAnak = new ArrayList<>();
    String pekerjaanSebelumnya;
    int lamaKerja; // dalam tahun
    List<String> proyekDikerjakan = new ArrayList<>();
    String pendidikanTerakhir;
    String namaOrganisasi;
    String jabatanOrganisasi;
    int lamaOrganisasi; // dalam tahun
    double rataRataNilai;
    double ipk;

    Scanner scanner = new Scanner(System.in);

    public Karyawan() {
    }

    boolean cekKelayakan() {
        // Cek umur karyawan
        if (umur < 18 || umur > 35) {
            System.out.println("Alasan tidak diterima: Umur tidak memenuhi syarat.");
            return false;
        }
        // Cek jumlah proyek yang sudah dikerjakan
        if (proyekDikerjakan.size() < 4) {
            System.out.println("Alasan tidak diterima: Jumlah proyek IT tidak memenuhi syarat.");
            return false;
        }
        // Cek pengalaman kerja
        if (lamaKerja < 2) {
            System.out.println("Alasan tidak diterima: Pengalaman kerja tidak mencukupi.");
            return false;
        }
        // Cek pendidikan terakhir dan nilai rata-rata
        if ("SMA".equals(pendidikanTerakhir) && rataRataNilai < 88) {
            System.out.println("Alasan tidak diterima: Nilai SMA tidak memenuhi syarat.");
            return false;
        }
        // Cek IPK untuk lulusan S1/S2/S3
        if (("S1".equals(pendidikanTerakhir) || "S2".equals(pendidikanTerakhir) || "S3".equals(pendidikanTerakhir))
                && ipk < 3.2) {
            System.out.println("Alasan tidak diterima: IPK tidak memenuhi syarat.");
            return false;
        }
        // Cek pengalaman berorganisasi
        if (namaOrganisasi == null || namaOrganisasi.isEmpty()) {
            System.out.println("Alasan tidak diterima: Tidak memiliki pengalaman berorganisasi.");
            return false;
        }
        // Jika semua kriteria terpenuhi
        return true;
    }

    void prosesKehidupan() {
        inputInfoPersonal();
        if (!inputInfoPekerjaanSebelumnya()) {
            System.out.println("Karyawan tidak memenuhi syarat karena tidak memiliki pekerjaan sebelumnya.");
            return;
        }
        inputInfoKeluarga();
        inputInfoPendidikan();
    }

    // Metode untuk input informasi personal
    void inputInfoPersonal() {
        System.out.print("Masukkan nama: ");
        nama = scanner.nextLine();
        System.out.print("Masukkan umur: ");
        umur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan jabatan: ");
        jabatan = scanner.nextLine();
        System.out.print("Masukkan gaji: ");
        gaji = scanner.nextInt();
        scanner.nextLine();
    }

    // Metode untuk input informasi keluarga
    void inputInfoKeluarga() {
        System.out.println("Apakah anda sudah menikah? (ya/tidak) : ");
        String statusMenikah = scanner.nextLine();
        if ("ya".equalsIgnoreCase(statusMenikah))
            System.out.println("Masukkan nama pasangan : ");
        namaPasangan = scanner.nextLine();
        System.out.println("Masukkan jumlah anak : ");
        int jumlahAnak = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < jumlahAnak; i++) {
            System.out.println("Masukkan nama anak ke-" + (i + 1) + ": ");
            namaAnak.add(scanner.nextLine());
        }
    }

    // Metode untuk input informasi pekerjaan
    boolean inputInfoPekerjaanSebelumnya() {
        System.out.print("Apakah Anda memiliki pekerjaan sebelumnya? (ya/tidak): ");
        String memilikiPekerjaan = scanner.nextLine();
        if ("tidak".equalsIgnoreCase(memilikiPekerjaan)) {
            return false; // Karyawan tidak memenuhi syarat
        } else if ("ya".equalsIgnoreCase(memilikiPekerjaan)) {
            System.out.print("Masukkan pekerjaan sebelumnya: ");
            pekerjaanSebelumnya = scanner.nextLine();
            System.out.print("Masukkan lama kerja (tahun): ");
            lamaKerja = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer
            System.out.print("Masukkan jumlah proyek yang sudah dikerjakan: ");
            int jumlahProyek = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer
            for (int i = 0; i < jumlahProyek; i++) {
                System.out.print("Masukkan nama proyek ke-" + (i + 1) + ": ");
                proyekDikerjakan.add(scanner.nextLine());
            }
            return true;
        } else {
            System.out.println("Input tidak valid. Silakan masukkan 'ya' atau 'tidak'.");
            return inputInfoPekerjaanSebelumnya(); // Ulangi pertanyaan jika input tidak valid
        }
    }

    // Metode untuk input informasi pendidikan
    void inputInfoPendidikan() {
        System.out.print("Masukkan pendidikan terakhir (SD/SMP/SMA/SMK/S1/S2/S3): ");
        pendidikanTerakhir = scanner.nextLine();
        scanner.nextLine();
        if (pendidikanTerakhir.equals("S1") || pendidikanTerakhir.equals("S2") || pendidikanTerakhir.equals("s1")
                || pendidikanTerakhir.equals("s2") || pendidikanTerakhir.equals("s3")
                || pendidikanTerakhir.equals("S3")) {
            System.out.print("Masukkan IPK: ");
            ipk = scanner.nextDouble();
            scanner.nextLine();
        } else {
            System.out.print("Masukkan rata-rata nilai: ");
            rataRataNilai = scanner.nextDouble();
        }
        System.out.print("Masukkan nama organisasi: ");
        namaOrganisasi = scanner.nextLine();
        System.out.print("Masukkan jabatan di organisasi: ");
        jabatanOrganisasi = scanner.nextLine();
        System.out.print("Masukkan lama berorganisasi (tahun): ");
        lamaOrganisasi = scanner.nextInt();
        scanner.nextLine();
    }

    public void playSound(String filePath) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem
                    .getAudioInputStream(Karyawan.class.getResourceAsStream(filePath));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    void displayInfoDasar() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
    }

    void displayInfoLengkap() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Keluarga:");
        System.out.println("\tNama Pasangan: " + namaPasangan);
        System.out.print("\tNama Anak: ");
        namaAnak.forEach(anak -> System.out.print(anak + " "));
        System.out.println("\nPekerjaan:");
        System.out.println("\tPekerjaan Sebelumnya: " + pekerjaanSebelumnya + " selama " + lamaKerja + " tahun");
        System.out.println("\tJabatan: " + jabatan);
        System.out.println("\tGaji: Rp. " + gaji);
        System.out.print("\tProyek yang sudah dikerjakan: ");
        proyekDikerjakan.forEach(proyek -> System.out.print(proyek + " "));
        System.out.println("\nPendidikan:");
        System.out.println("\tPendidikan Terakhir: " + pendidikanTerakhir);
        System.out.println("\tOrganisasi: " + namaOrganisasi + " sebagai " + jabatanOrganisasi + " selama "
                + lamaOrganisasi + " tahun");
        System.out.println("\tRata-rata Nilai: " + rataRataNilai);
        if (!Double.isNaN(ipk)) {
            System.out.println("\tIPK: " + ipk);
        }
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

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public String getNamaPasangan() {
        return namaPasangan;
    }

    public void setNamaPasangan(String namaPasangan) {
        this.namaPasangan = namaPasangan;
    }

    public List<String> getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(List<String> namaAnak) {
        this.namaAnak = namaAnak;
    }

    public String getPekerjaanSebelumnya() {
        return pekerjaanSebelumnya;
    }

    public void setPekerjaanSebelumnya(String pekerjaanSebelumnya) {
        this.pekerjaanSebelumnya = pekerjaanSebelumnya;
    }

    public int getLamaKerja() {
        return lamaKerja;
    }

    public void setLamaKerja(int lamaKerja) {
        this.lamaKerja = lamaKerja;
    }

    public List<String> getProyekDikerjakan() {
        return proyekDikerjakan;
    }

    public void setProyekDikerjakan(List<String> proyekDikerjakan) {
        this.proyekDikerjakan = proyekDikerjakan;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getNamaOrganisasi() {
        return namaOrganisasi;
    }

    public void setNamaOrganisasi(String namaOrganisasi) {
        this.namaOrganisasi = namaOrganisasi;
    }

    public String getJabatanOrganisasi() {
        return jabatanOrganisasi;
    }

    public void setJabatanOrganisasi(String jabatanOrganisasi) {
        this.jabatanOrganisasi = jabatanOrganisasi;
    }

    public int getLamaOrganisasi() {
        return lamaOrganisasi;
    }

    public void setLamaOrganisasi(int lamaOrganisasi) {
        this.lamaOrganisasi = lamaOrganisasi;
    }

    public double getRataRataNilai() {
        return rataRataNilai;
    }

    public void setRataRataNilai(double rataRataNilai) {
        this.rataRataNilai = rataRataNilai;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Karyawan> daftarKaryawan = new ArrayList<>();

        // Menu utama
        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Lihat Info Karyawan");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                case 1:
                    Karyawan karyawanBaru = new Karyawan();
                    karyawanBaru.prosesKehidupan(); // Memanggil metode untuk menginput data karyawan
                    if (karyawanBaru.cekKelayakan()) { // Memeriksa kelayakan karyawan
                        daftarKaryawan.add(karyawanBaru); // Menambahkan karyawan yang layak ke daftar
                        System.out.println("Karyawan berhasil ditambahkan.");
                        karyawanBaru.playSound("UI.wav");
                    } else {
                        System.out.println("Karyawan tidak memenuhi syarat dan tidak ditambahkan.");
                        karyawanBaru.playSound("fail.wav");
                    }
                    break;

                case 2:
                    if (daftarKaryawan.isEmpty()) {
                        System.out.println("Belum ada karyawan yang ditambahkan.");
                    } else {
                        for (int i = 0; i < daftarKaryawan.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarKaryawan.get(i).nama);
                            daftarKaryawan.get(i).displayInfoDasar();
                        }
                        System.out.print("Masukkan nomor karyawan untuk melihat info lengkap atau 0 untuk kembali: ");
                        int nomor = scanner.nextInt();
                        scanner.nextLine();
                        if (nomor > 0 && nomor <= daftarKaryawan.size()) {
                            daftarKaryawan.get(nomor - 1).displayInfoLengkap();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}

// konsepnya sama, tapi yang berbeda itu classnya
// bikin coding ini karyawan ada semua datanya (data personal harus lengkap),
// terus kalau misalkan
// yang ditampilkan keluarga, pekerjaan, pendidikan
// keluarga : nama pasangan, nama anak, pekerjaan istri kalau ada,
// pekerjaan : nama pekerjaan sebelumnya (kalau ada sebut juga berapa lama dia
// kerja) , jabatan, gaji, proyek yang
// sudah dikerja apa saja,
// pendidikan : tampilkan sebelumnya dia belajar dimana (sd - s3) dan tampilkan,
// tampilkan nama organisasi dan jabatan di organisasi serta berapa lama dia di
// organisasi (kalau ada)
// rata2 nilai setiap strata.
// syarat diterima karyawan : pengalaman 2 tahun, proyek minimal 4, umur 18-35,
// minimal sma dengan nilai 88, kalau lulusan s1/2/3 minimal ipk 3.2, dan
// berorganisasi
// outputnya : dijelaskan alasan dia tidak diterima ( contoh : pengalaman tahun
// tidak mencukupi)