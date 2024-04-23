package Tugas1;
import java.util.*;

public class No3 {

    public static String konversiTanggal(String input) {
        if (input.isEmpty()) {
            return "Inputan kosong.";
        }//revisi setelah tidak bisa menerima inputan kosong

        String[] bagian = input.split("-");
        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        
        int tanggal = Integer.parseInt(bagian[0]);
        int bulanIndex = Integer.parseInt(bagian[1]) - 1;
        int tahun = Integer.parseInt(bagian[2]);

        if (tahun >= 0 && tahun <= 25) {
            tahun += 2000;
            return tanggal + " " + namaBulan[bulanIndex] + " " + tahun;
        } else if (tahun >= 26 && tahun <= 99) {
            tahun += 1900; 
            return tanggal + " " + namaBulan[bulanIndex] + " " + tahun;
        } else {
            return "Inputan harus 1-99";
        }
    }

    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.print("Input Tanggal-Bulan-Tahun : ");
        String Tgl = inputan.nextLine();
        inputan.close();

        String hasilKonversi = konversiTanggal(Tgl);

        System.out.println(hasilKonversi);
    }
}

