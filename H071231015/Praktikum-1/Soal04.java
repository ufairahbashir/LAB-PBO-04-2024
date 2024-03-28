import java.util.Scanner;

public class Soal04 {
    public static void main(String[] args) {
        double r;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan jari-jari : ");                
                r = input.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan karena " + e);
                input.nextLine();
            }
        }
        double luas = 3.14*r*r;
        System.out.printf("Luas : %.2f", luas);
        
    }
    
    
}
