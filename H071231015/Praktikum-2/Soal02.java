import java.util.HashMap;
import java.util.Scanner;

public class Soal02 {
    
    String ID;
    String nama;
    int stok;
    double harga;

    public Soal02(String iD, String nama, int stok, double harga) {
        ID = iD;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    void cekData(){
        System.out.println("\nBerikut data " + nama + " :");
        System.out.println("ID: " + ID);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: " + harga);
    }

    void cekStok(){
        if (stok > 0) {
            System.out.println("Stok " + nama + " masih ada sebanyak " + stok);
        }
        else{
            System.out.println("Stok " +  nama + " sudah habis");
        }
    }

    static Soal02 cetakObjek(String id, String nama, int stok, double harga){
        return new Soal02(id, nama, stok, harga);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String id;
        String nama;
        int stok;
        double harga;
        HashMap<String, Soal02> daftarProduk = new HashMap<>(); 

        int x;
        while (true) {
            while (true) {
                System.out.printf("%n%s", "=".repeat(50));
                System.out.print("\n1. Input baru\n2. Cek Data\n3. Cek Stok\n4. Exit\n= ");
                x = input.nextInt();
                input.nextLine();
                try {
                    if (x == 1 || x == 2 || x == 3 || x == 4) {
                        break;
                    }
                    else{
                        System.out.println("Pilih antara 1/2/3/4");
                        input.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println("Terjadi kesalahan karena " + e);
                    input.nextLine();
                }
            }

            if (x == 1) {
                System.out.printf("%s", "=".repeat(50));
                System.out.print("\nMasukkan ID : ");
                id = input.nextLine();
                System.out.print("Masukkan nama produk : ");
                nama = input.nextLine();
                System.out.print("Masukkan jumlah stok : ");
                stok = input.nextInt();
                System.out.print("Masukkan harga : ");
                harga = input.nextDouble();
                Soal02 produk = cetakObjek(id, nama, stok, harga);
                daftarProduk.put(id, produk);
                input.nextLine();

            }
            else if (x == 2) {
                System.out.printf("%s", "=".repeat(50));
                System.out.print("\nMasukkan id produk : ");
                id = input.nextLine();

                Soal02 cari = daftarProduk.get(id);

                if (cari != null) {
                    cari.cekData();
                } else {
                    System.out.println("\nProduk dengan ID " + id + " tidak ditemukan.");
                }
            }
            else if (x == 3) {
                System.out.printf("%s", "=".repeat(50));
                System.out.print("\nMasukkan id produk : ");
                id = input.nextLine();

                Soal02 cari = daftarProduk.get(id);

                if (cari != null) {
                    cari.cekStok();
                } else {
                    System.out.println("\nProduk dengan ID " + id + " tidak ditemukan.");
                }
            }
            else if (x == 4) {
                System.out.println("Terima kasih");
                break;
            }
        input.close();
        }
    }

}
