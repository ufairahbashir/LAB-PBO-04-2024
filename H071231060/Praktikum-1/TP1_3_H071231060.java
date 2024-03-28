import java.util.Scanner;
public class Nomor3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan Tanggal: ");
        String input1 = scanner.nextLine();

        System.out.println(convertToDateFormat(input1));
        
    }

    public static String convertToDateFormat(String input) {
        String[] parts = input.split("-");

        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
                              "Agustus", "September", "Oktober", "November", "Desember"};

        String tanggal = removeLeadingZero(parts[0]);
        int indexBulan = Integer.parseInt(parts[1]) - 1 ; // Mengurangi 1 karena array dimulai dari 0
        String bulan = (indexBulan >= 0 && indexBulan < namaBulan.length) ? namaBulan[indexBulan] : "Invalid Bulan";
        String tahun = convertYear(parts[2]);
        return tanggal + " " + bulan + " " + tahun;
    }

    public static String convertYear(String year) {
        if (year.length() == 2) {
            int tahun = Integer.parseInt(year);
            return (tahun >= 0 && tahun <= 21 ) ? "20" + year : "19" + year;
        }
        return year;
    }
    public static String removeLeadingZero(String str) {
        return str.replaceFirst("^0+(?!$)", "");
    }
}       
