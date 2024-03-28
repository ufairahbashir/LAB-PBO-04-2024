import java.util.Scanner;

public class TP1_3_H071231080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: \n");
        String tanggal = sc.nextLine();
        String konversi = convertDateString(tanggal);
        System.out.println("output : \n" + konversi);
        sc.close();
    }

    public static String convertDateString(String input) {
        String[] parts = input.split("-");
        int hari = Integer.parseInt(parts[0]);         
        int bulan = Integer.parseInt(parts[1]);
        int tahun = Integer.parseInt(parts[2]);

        String namaBulan = "";

        switch (bulan) {
            case 1:
                namaBulan = "Januari";
                break;
            case 2:
                namaBulan = "Februari";
                break;
            case 3:
                namaBulan = "Maret";
                break;
            case 4:
                namaBulan = "April";
                break;
            case 5:
                namaBulan = "Mei";
                break;
            case 6:
                namaBulan = "Juni";
                break;
            case 7:
                namaBulan = "Juli";
                break;
            case 8:
                namaBulan = "Agustus";
                break;
            case 9:
                namaBulan = "September";
                break;
            case 10:
                namaBulan = "Oktober";
                break;
            case 11:
                namaBulan = "November";
                break;
            case 12:
                namaBulan = "Desember";
                break;
        }
         
        if (tahun >= 0 && tahun <= 25) {
            tahun += 2000;
        } else if (tahun >= 26 && tahun <= 99) {
            tahun += 1900;
        }

        return hari + " " + namaBulan + " " + tahun;
        
    }
}
    