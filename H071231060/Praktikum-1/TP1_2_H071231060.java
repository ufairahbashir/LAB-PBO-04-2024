import java.util.Scanner;

public class Nomor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        String kalimatKecil = kalimat.toLowerCase();

        String hasil = capitalizeFirstLetter(kalimatKecil);
        System.out.println("Hasil: " + hasil);

        scanner.close();
    }
    public static String capitalizeFirstLetter(String kalimat) {

        String[] kataKata = kalimat.split(" ");
        StringBuilder hasil = new StringBuilder();

        for (String kata : kataKata) {

            if (!kata.isEmpty()) {
                char hurufPertama = Character.toUpperCase(kata.charAt(0));

                hasil.append(hurufPertama).append(kata.substring(1)).append(" ");
            }
        }

        return hasil.toString().trim();
    }
}


