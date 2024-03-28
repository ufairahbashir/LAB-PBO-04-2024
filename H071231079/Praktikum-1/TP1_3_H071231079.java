import java.util.Scanner;

public class TP1_3_H071231079 {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input : \n");
        String tanggal = scan.nextLine();

        String konversi = konversi(tanggal);
        System.out.println("output : \n" + konversi);
        scan.close();
    }

    public static String konversi(String tanggal) {
        String[] splitTanggal = tanggal.split("-");
        int tanggalAngka = Integer.parseInt(splitTanggal[0]);
        int bulanAngka = Integer.parseInt(splitTanggal[1]);
        int tahunAngka = Integer.parseInt(splitTanggal[2]);

        String bulanKata = "";

        switch (bulanAngka) {
            case 1:
                bulanKata = "Januari";
                break;
            case 2:
                bulanKata = "Februari";
                break;
            case 3:
                bulanKata = "Maret";
                break;
            case 4:
                bulanKata = "April";
                break;
            case 5:
                bulanKata = "Mei";
                break;
            case 6:
                bulanKata = "Juni";
                break;
            case 7:
                bulanKata = "Juli";
                break;
            case 8:
                bulanKata = "Agustus";
                break;
            case 9:
                bulanKata = "September";
                break;
            case 10:
                bulanKata = "Oktober";
                break;
            case 11:
                bulanKata = "November";
                break;
            case 12:
                bulanKata = "Desember";
                break;
            default:
                bulanKata = "Bulan tidak valid";
                break;
        }

        if (tahunAngka >= 0 && tahunAngka <= 24) {
            tahunAngka += 2000;
        } else if (tahunAngka >= 25 && tahunAngka <= 99) {
            tahunAngka += 1900;
        }

        return tanggalAngka + " " + bulanKata + " " + tahunAngka;
        
    }
}
