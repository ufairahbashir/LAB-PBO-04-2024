class Tipe {

    String tipe;
    int hargaPerKg;

//method
    public Tipe(String tipe) {
        this.tipe = tipe.toLowerCase();
        switch (this.tipe) {
            case "premium":
                hargaPerKg = 7000;
                break;

            default:
                hargaPerKg = 5000;
                break;
        }
    }
//getter
    public String getTipe() {
        return tipe;
    }

    public int getHargaPerKg() {
        return hargaPerKg;
    }
}
//Main class
public class TP3_1_H071231080 {

    String namaKostumer;
    int berat;
    Tipe tipe;

    // Constructor 1
    public TP3_1_H071231080(String nama, int berat, Tipe tipe) {
        this.namaKostumer = nama;
        this.berat = berat;
        this.tipe = tipe;
    }

    // Constructor 2
    public TP3_1_H071231080(String nama, int berat) {
        this(nama, berat, new Tipe("Standard"));
    }

    // Behavior 3: Menghitung total biaya laundry
    public int totalBiaya() {
        return berat * tipe.getHargaPerKg();
    }

    // Behavior 4: Mengubah tipe laundry pelanggan
    public void ubahTipe(Tipe tipeBaru) {
        this.tipe = tipeBaru;
        System.out.println("Tipe laundry untuk " + namaKostumer + " telah diubah menjadi " + tipe.getTipe());
    }

    // Behavior 5: Menambah berat laundry
    public void tambahBerat(int tambahanBerat) {
        this.berat += tambahanBerat;
        System.out.println("Berat laundry untuk " + namaKostumer + " ditambah menjadi " + berat + " KG");
    }

    // Behavior 6: Menampilkan detail laundry dengan tambahan informasi
    public void display() {

        System.out.println("====== Detail Laundry ======");
        System.out.println("Nama Kostumer: " + namaKostumer);
        System.out.println("Berat: " + berat + " KG");
        System.out.println("Tipe Laundry: " + tipe.getTipe());
        System.out.println("Total Biaya: Rp. " + totalBiaya());
       
    }

    // Method main untuk pengujian
    public static void main(String[] args) {
        TP3_1_H071231080 pelanggan1 = new TP3_1_H071231080("Nur fadillah", 4, new Tipe("standard"));
        // Menampilkan detail laundry dengan informasi tambahan
        pelanggan1.display();
    }
} 