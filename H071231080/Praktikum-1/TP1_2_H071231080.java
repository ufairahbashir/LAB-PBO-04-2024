import java.util.Scanner;

public class TP1_2_H071231080 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan Judul Film:\n> ");
        String kalimat = scan.nextLine();
        String kalimatDiubah = ubahHuruf(kalimat);
        System.out.println("> " + kalimatDiubah);
        scan.close();
    }

    public static String ubahHuruf(String kalimat) {
        StringBuilder result = new StringBuilder();
        boolean kapital = true;

        for (char karakter : kalimat.toCharArray()) {
            if (Character.isLetter(karakter)) {
                if (kapital) {
                    result.append(Character.toUpperCase(karakter));
                    kapital = false;
                } else {
                    result.append(Character.toLowerCase(karakter));
                }
            } else {
                result.append(karakter);
                kapital = true;

                if (karakter == ' ') {
                    kapital = true;
                }
            }
        }
        return result.toString();
    }
}