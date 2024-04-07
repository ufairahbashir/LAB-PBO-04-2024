import java.util.Scanner;

public class TP1_1_H071231080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Masukkan jumlah bilangan: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String input = sc.nextLine();

        String[] bilanganStrings = input.split(" "); 
        sc.close(); 
        if (bilanganStrings.length != n) {
            System.out.println("Input tidak valid: Jumlah bilangan tidak sesuai");
            return;
        }

        int bilanganBulat = 0;
        int bilanganDesimal = 0;

        for (String bilanganStr : bilanganStrings) {
            try {
                double x = Double.parseDouble(bilanganStr); 
                if (x == (int) x) {
                    bilanganBulat++;
                } else {
                    bilanganDesimal++;
                }
            } catch (NumberFormatException e) { 
                System.out.println("Input yang Anda masukkan bukan angka. Silakan coba lagi.");
            }
        }

        System.out.println(bilanganBulat + " Bilangan Bulat");
        System.out.println(bilanganDesimal + " Bilangan Desimal");

        sc.close(); 
    }
}

    

