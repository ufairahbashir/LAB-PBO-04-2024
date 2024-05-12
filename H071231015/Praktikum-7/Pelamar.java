public class Pelamar {
    private String nomorInduk;
    private String name;
    private int umur;
    private int exp;
    private String edu;
    private int project;
    private double gajiDulu;
    private String berkeluarga;
    private String organisasi;
    
    
    
    public Pelamar(String nomorInduk, String name, int umur, int exp, String edu, int project, double gajiDulu,
            String berkeluarga, String organisasi) {
        this.nomorInduk = nomorInduk;
        this.name = name;
        this.umur = umur;
        this.exp = exp;
        this.edu = edu;
        this.project = project;
        this.gajiDulu = gajiDulu;
        this.berkeluarga = berkeluarga;
        this.organisasi = organisasi;
    }
    
    public String getNomorInduk() {return nomorInduk;}
    public void setNomorInduk(String nomorInduk) {this.nomorInduk = nomorInduk;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getUmur() {return umur;}
    public void setUmur(int umur) {this.umur = umur;}
    public int getExp() {return exp;}
    public void setExp(int exp) {this.exp = exp;}
    public String getEdu() {return edu;}
    public void setEdu(String edu) {this.edu = edu;}
    public int getProject() {return project;}
    public void setProject(int project) {this.project = project;}
    public double getGajiDulu() {return gajiDulu;}
    public void setGajiDulu(double gajiDulu) {this.gajiDulu = gajiDulu;}
    public String getBerkeluarga() {return berkeluarga;}
    public void setBerkeluarga(String berkeluarga) {this.berkeluarga = berkeluarga;}
    public String getOrganisasi() {return organisasi;}
    public void setOrganisasi(String organisasi) {this.organisasi = organisasi;}
}
