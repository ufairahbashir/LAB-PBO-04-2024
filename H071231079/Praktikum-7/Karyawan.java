public class Karyawan {
    String nama;
    int umur;
    String jabatan;
    double gaji;
    boolean statusMenikah;
    String sertifikasi; 

    public Karyawan(String nama, int umur, String jabatan, double gaji, boolean statusMenikah, String sertifikasi) {
        this.nama = nama;
        this.umur = umur;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.statusMenikah = statusMenikah;
        this.sertifikasi = sertifikasi; 
    }

    public String getSertifikasi() {
        return sertifikasi;
    }

    public void setSertifikasi(String sertifikasi) {
        this.sertifikasi = sertifikasi;
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

    public boolean isStatusMenikah() {
        return statusMenikah;
    }
    public void setStatusMenikah(boolean statusMenikah) {
        this.statusMenikah = statusMenikah;
    }
    public double getGaji() {
        return gaji;
    }
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
}