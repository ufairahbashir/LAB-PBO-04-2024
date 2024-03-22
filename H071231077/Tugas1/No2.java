package Tugas1;
import java.util.*;

public class No2 {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
            
        System.out.print("Masukkan Judul Film : ");
        String kalimat = inputan.nextLine();
        inputan.close();
            
        String[] arrKata = kalimat.split(" ");
            
        for (int i = 0; i < arrKata.length; i++) {
            arrKata[i] = HurufPertama(arrKata[i]);
        }
            
        String output = String.join(" ", arrKata);
        System.out.println(output); //judul film ini 
    }
    
    public static String HurufPertama(String kata) {
        if (kata == null || kata.isEmpty()) {
            return kata;
        }
        return Character.toUpperCase(kata.charAt(0)) + kata.substring(1).toLowerCase();
    }
}