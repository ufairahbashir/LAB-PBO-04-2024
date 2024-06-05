public class Karyawan{
    private String nomorInduk;
    private String nama;
    private int umur;
    private String jabatan;
    private double gaji;
    
    public Karyawan(String nomorInduk, String nama, int umur, String jabatan, double gaji) {
        this.nomorInduk = nomorInduk;
        this.nama = nama;
        this.umur = umur;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }
    
    public String getNomorInduk() {return nomorInduk;}
    public void setNomorInduk(String nomorInduk) {this.nomorInduk = nomorInduk;}
    public String getNama() {return nama;}
    public void setNama(String nama) {this.nama = nama;}
    public int getUmur() {return umur;}
    public void setUmur(int umur) {this.umur = umur;}
    public String getJabatan() {return jabatan;}
    public void setJabatan(String jabatan) {this.jabatan = jabatan;}
    public double getGaji() {return gaji;}
    public void setGaji(double gaji) {this.gaji = gaji;}
}