import java.util.ArrayList;

public class Karyawan {
    protected String nama, jabatan;
    protected int umur, gaji;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }
}

abstract class Kehidupan {
    public abstract void prosesKehidupan();
}

class Pengalaman extends Kehidupan {
    private ArrayList<String> riwayatPekerjaan = new ArrayList<>();
    private ArrayList<String> sertifikat = new ArrayList<>();
    private ArrayList<String> organisasi = new ArrayList<>();
    private Karyawan karyawan = new Karyawan();
    private Pendidikan pendidikan = new Pendidikan();
    private Proyek proyek = new Proyek();
    private Keluarga keluarga = new Keluarga();

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public void setPendidikan(Pendidikan pendidikan) {
        this.pendidikan = pendidikan;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    // Overload method pengalamanKerja() wajib
    public void pengalamanKerja(ArrayList<String> riwayatPekerjaan) {
        this.riwayatPekerjaan = riwayatPekerjaan;
    }

    // Overload method pengalamanKerja() tambahan
    public void pengalamanKerja(ArrayList<String> sertifikat, ArrayList<String> organisasi) {
        this.sertifikat = sertifikat;
        this.organisasi = organisasi;
    }

    @Override
    public void prosesKehidupan() {
        System.out.println("Nama    : " + karyawan.nama);
        System.out.println("Umur    : " + karyawan.umur);
        System.out.println("Gaji    : " + karyawan.gaji);
        System.out.println("Jabatan : " + karyawan.jabatan);
        System.out.println("\nPendidikan terakhir: "
        + this.pendidikan.getPendidikanTerakhir() + " di " +
        this.pendidikan.getNamaSekolahAtauKampus());

        System.out.println("\nPengalaman kerja:");
        for (String i : riwayatPekerjaan) {
            System.out.println("- " + i);
        }

        System.out.println("\nSertifikat:");
        if (!this.sertifikat.isEmpty()){
            for (String i : this.sertifikat) {
                System.out.println("- " + i);
            }
        } else { System.out.println("-"); }

        System.out.println("\nOrganisasi:");
        if (!this.organisasi.isEmpty()){
            for (String i : this.organisasi) {
                System.out.println("- " + i);
            }
        } else { System.out.println("-"); }

        System.out.println("\nJumlah proyek yang telah diselesaikan: " + this.proyek.getTotalProyek());

        if (keluarga.getMenikah().equals("Sudah")) {
            System.out.println("\nSudah menikah: " + keluarga.getMenikah());
            System.out.println("Jumlah anak : " + keluarga.getJumlahAnak() + "orang");
            System.out.println("Lama menikah: " + keluarga.getLamaMenikah() + " tahun\n");
        } else {
            System.out.println("\nSudah menikah: " + keluarga.getMenikah() + "\n");
        }
    }
}

class Pendidikan {
    private String namaSekolahAtauKampus;
    private String pendidikanTerakhir;

    public void setPendidikan(String pendidikanTerakhir, String namaSekolahAtauKampus) {
        this.pendidikanTerakhir = pendidikanTerakhir;
        this.namaSekolahAtauKampus = namaSekolahAtauKampus;
    }

    public String getPendidikanTerakhir(){
        return this.pendidikanTerakhir;
    }

    public String getNamaSekolahAtauKampus(){
        return this.namaSekolahAtauKampus;
    }
}

class Proyek {
    private int totalProyek;

    public void setTotalProjek(int totalProyek) {
        this.totalProyek = totalProyek;
    }

    public int getTotalProyek() {
        return totalProyek;
    }
}

class Keluarga {
    private boolean menikah;
    private int jumlahAnak, lamaMenikah;
    
    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public void setLamaMenikah(int lamaMenikah) {
        this.lamaMenikah = lamaMenikah;
    }
    
    public String getMenikah() {
        if (this.menikah) return "Sudah";
        else return "Belum";
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public int getLamaMenikah() {
        return lamaMenikah;
    }
}