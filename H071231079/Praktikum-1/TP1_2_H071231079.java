import java.util.Scanner;

public class TP1_2_H071231079 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Judul Film : \n> ");
        String judul = input.nextLine();

        title(judul);

        input.close();
    }

    public static void title(String judul) {
        String[] kata = judul.split(" ");

        for(String kataJudul : kata) {
            char karakterPertama = Character.toUpperCase(kataJudul.charAt(0));
            String karakterSisa = kataJudul.substring(1).toLowerCase();

            System.out.print(karakterPertama + karakterSisa + " ");
        }
    }
}
