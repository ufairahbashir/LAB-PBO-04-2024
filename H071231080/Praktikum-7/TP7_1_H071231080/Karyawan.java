public class Karyawan {

    String nama, jabatan;
    int umur;
    double gaji;
    
    String pendidikanTerakhir;
    Pengalaman pengalaman;

    public Karyawan(String nama, String pendidikanTerakhir, int umur, double gaji){
        this.nama = nama;
        this.umur = umur;
        this.gaji = gaji;
        this.jabatan = "Karyawan";
        this.pendidikanTerakhir = pendidikanTerakhir;
        this.pengalaman = new Pengalaman();
    }

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

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
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

    public void detailKaryawan(){
        System.out.println("-----------------------------------");
        System.out.println("Nama      : " + getNama());
        System.out.println("Umur      : " + getUmur());
        System.out.println("Jabatan   : "+ getJabatan());
        System.out.println("Gaji      : " + getGaji());
    }
}
