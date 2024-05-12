package Livecode7;
import java.util.ArrayList;

abstract class Kehidupan {
    public abstract void prosesKehidupan();
}

class Pengalaman extends Kehidupan {
    private String riwayatPekerjaan = new String();
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

    public void pengalamanKerja( String riwayatPekerjaan) {
        this.riwayatPekerjaan = riwayatPekerjaan;
    }

    public void pengalamanKerja(ArrayList<String> sertifikat, ArrayList<String> organisasi) {
        this.sertifikat = sertifikat;
        this.organisasi = organisasi;
    }

    public void prosesKehidupan() {
        System.out.println("Nama    : " + karyawan.nama);
        System.out.println("Umur    : " + karyawan.umur);
        System.out.println("Gaji    : " + karyawan.gaji);
        System.out.println("Jabatan : " + karyawan.jabatan);
        System.out.println("Pendidikan terakhir: "+ this.pendidikan.getPendidikanTerakhir() + " di " + this.pendidikan.getNamaSekolah());

        System.out.println("\nPengalaman kerja: "+ riwayatPekerjaan);
        
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
        } else {
            System.out.println("\nSudah menikah: " + keluarga.getMenikah() + "\n");
        }
    }
}

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



class Pendidikan {
    private String namaSekolah;
    private String pendidikanTerakhir;

    public void setPendidikan(String pendidikanTerakhir, String namaSekolah) {
        this.pendidikanTerakhir = pendidikanTerakhir;
        this.namaSekolah = namaSekolah;
    }

    public String getPendidikanTerakhir(){
        return this.pendidikanTerakhir;
    }

    public String getNamaSekolah(){
        return this.namaSekolah;
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
    private int jumlahAnak;
    
    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }
    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }
    public String getMenikah() {
        if (this.menikah) return "Sudah";
        else return "Belum";
    }
}