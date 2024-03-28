import java.util.Scanner;

public class TP1_2_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Masukkan judul film: ");
            String judul = sc.nextLine();
            
            System.out.println(CEW(judul));
        }
    }

    public static String CEW(String judul) {
        String hasil = "";

        for (int j = 0; j < judul.length(); j++) {
            if (j == 0 || (j > 0 && judul.charAt(j-1) == ' ')) {
                hasil += judul.toUpperCase().charAt(j);
            } else {
                hasil += judul.toLowerCase().charAt(j);
            }
        }

        return hasil;
    }
}