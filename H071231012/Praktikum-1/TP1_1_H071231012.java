import java.util.Scanner;

public class TP1_1_H071231012 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int bilbulat = 0;
        int bildesimal = 0;
        try {
            for (int i = 0; i<n; i++){
                double angka = input.nextDouble();
                if (angka % 1 == 0){
                    bilbulat++;
                } else {
                    bildesimal++;
                }
            }
        }catch (Exception e) {
            System.out.println("Input yang bukan angka");
        }
            System.out.println(bilbulat + " Bilangan bulat");
            System.out.println(bildesimal + " Bilangan desimal");

            input.close();
           }
}