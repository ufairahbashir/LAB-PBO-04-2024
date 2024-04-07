import java.util.Scanner;

public class TP1_3_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String hasil;
            String[] tanggal; // inputan bukan hanya integer, tetapi terdapat tanda '-'
            
            while (true) {
                boolean IsValid = true;

                System.out.println("Masukkan tanggal: ");
                tanggal = sc.nextLine().split("-"); // inputan dipisah di antara '-'
                
                if (tanggal.length != 3) { 
                    System.out.println("Harus dan hanya ada 3 komponen, yaitu tanggal, bulan, dan tahun.\n");
                    continue;
                }

                for (int i = 0; i < tanggal.length; i++) {
                    try {
                        @SuppressWarnings("unused")
                        int tester = Integer.parseInt(tanggal[i]); // inputan diubah ke integer agar memfilter inputan bukan angka
                    } catch (NumberFormatException e) {
                        System.out.println("Tanggal, bulan, dan tahun harus berupa integer.\n");
                        IsValid = false;
                        break;
                    }
                }

                if (!IsValid) { continue; }

                hasil = FormatTanggal(tanggal);

                if (hasil == "invalid") { continue; }

                System.out.println('\n' + hasil.strip());
                break;
            }
        }
    }

    public static String FormatTanggal(String[] tanggal) {
        String hasil = "";
        String[] NamaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        
        while (true) {
            int tgl = Integer.parseInt(tanggal[0]);
            int bln = Integer.parseInt(tanggal[1]);
            int thn = Integer.parseInt(tanggal[2]);

            // Bulan
            if (bln > 0 && bln < 13) { tanggal[1] = NamaBulan[bln-1]; }
            else { System.out.println("Bulan tidak valid.\n"); return "invalid"; }

            // Tahun
            if (thn >= 0 && thn <= 24) {
                tanggal[2] = Integer.toString(2000+thn);
            } else if (thn > 24 && thn < 100) {
                tanggal[2] = Integer.toString(1900+thn);
            } else {
                System.out.println("Tahun tidak valid.\n");
                return "invalid";
            }

            // Tanggal
            if (bln == 2) { // Pembatasan tanggal pada bulan Februari kabisat dan bukan kabisat
                if (thn % 4 == 0 && thn % 100 != 0) { // Kabisat
                    if (tgl < 1 || tgl > 29) {
                        System.out.printf(
                            "Tanggal tidak valid.\nTahun %s merupakan tahun kabisat. Batas tanggal pada bulan %s %s adalah 1 s.d. 29.\n\n",
                            tanggal[2], tanggal[1], tanggal[2]);
                        return "invalid";
                    } else { tanggal[0] = Integer.toString(tgl); }
                } else { // Bukan kabisat
                    if (tgl < 1 || tgl > 28) {
                        System.out.printf(
                            "Tanggal tidak valid.\nTahun %s bukan tahun kabisat. Batas tanggal pada bulan %s %s adalah 1 s.d. 28.\n\n",
                            tanggal[2], tanggal[1], tanggal[2]);
                        return "invalid";
                    } else { tanggal[0] = Integer.toString(tgl); }
                }
            } else if ((bln  % 2 != 0 && bln < 8) || (bln % 2 == 0 && bln > 7)) { // Bulan yang memiliki 31 hari
                if (tgl < 1 || tgl > 31) {
                    System.out.printf("Tanggal tidak valid.\nBatas tanggal pada bulan %s adalah 1 s.d. 31.\n\n", tanggal[1]);
                    return "invalid";
                } else { tanggal[0] = Integer.toString(tgl); }
            } else {
                if (tgl < 1 || tgl > 30) { // Bulan yang memiliki 30 hari
                    System.out.printf("Tanggal tidak valid.\nBatas tanggal pada bulan %s adalah 1 s.d. 30.\n\n", tanggal[1]);
                    return "invalid";
                } else { tanggal[0] = Integer.toString(tgl); }
            }

            break;
        }

        for (int i = 0; i < tanggal.length; i++) {
            hasil += tanggal[i] + ' '; // Menambahkan setiap nilai di dalam tanggal[] ke variabel hasil
        }

        return hasil;
    }
}