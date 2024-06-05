import java.util.Scanner;
public class TP1_3_H071231012 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String tanggal = input.nextLine();
        String[] pisah = tanggal.split("-");
        konversiString(pisah);
        input.close();
    }
    static void konversiString(String[] hasil){
        int tanggal = Integer.parseInt(hasil[0]);
        int bulanAwal = Integer.parseInt(hasil[1]);
        int tahunAwal = Integer.parseInt(hasil[2]);
        int tahun = CekTahun(tahunAwal);
        String bulan = CekBulan(bulanAwal);
        System.out.println(tanggal + " " + bulan + " " + tahun);
    }

    static String CekBulan(int bulan){
        String x = "";
        switch (bulan){
            case 1:
                x = "Januari";
                break;
            case 2:
                x = "Februari";
                break;
            case 3:
                x = "Maret";
                break;
            case 4:
                x = "April";
                break;
            case 5:
                x = "Mei";
                break;
            case 6:
                x =  "Juni";
                break;
            case 7:
                x = "Juli";
                break;
            case 8:
                x = "Agustus";
                break;
            case 9:
                x = "September";
                break;
            case 10:
                x = "Oktober";
                break;
            case 11:
                x = "November";
                break;
            case 12:
                x = "Desember";
                break;
        }
        return x;
    }
    
    static int CekTahun(int tahun){
        if (tahun >= 40){
            return (1900 + tahun);
        } else {
            return (2000 + tahun);
        }
    }
}