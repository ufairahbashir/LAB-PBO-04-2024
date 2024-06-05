import java.util.Scanner;

public class TP1_2_H071231012 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Judul Film :");
        String judul = input.nextLine();
        System.out.println(hurufJudul(judul));
        input.close();
    }
    static String hurufJudul(String judul){
        judul = judul.toLowerCase();
        String[] arrString = judul.split(" ");
        for (int i = 0; i < arrString.length; i++){
            arrString[i] = Character.toUpperCase(arrString[i].charAt(0)) + arrString[i].substring(1);
        }
        String hasil = String.join(" ", arrString);
        return hasil;
    }
}