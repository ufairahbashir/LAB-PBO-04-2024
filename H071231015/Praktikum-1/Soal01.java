
import java.util.Scanner;

public class Soal01 {
    public static void main(String[] args) {
        int x;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                x = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan kerena : " + e);
                input.nextLine();
            }
        }
        
        int bulat = 0, desimal = 0;
        double y;

        for (int i=0; i <x; i++){
            while (true) {
                try {
                    y = input.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Terjadi kesalahan kerena : " + e);
                    input.nextLine();
                }
            }

            if (y % 1 == 0) {
                bulat++;
            }
            else{
                desimal++;
            }

        }
        System.out.println(bulat + " Bilangan Bulat\n" + desimal + " BIlangan Desimal");
    }
    
    
}
