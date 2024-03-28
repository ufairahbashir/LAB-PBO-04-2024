import java.util.Scanner;

public class TP1_1_H071231079 {
    public static void main(String[] args) {
        Scanner inputBatas = new Scanner(System.in);
        int  n = 0;
        try {
            n = inputBatas.nextInt();
        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat.");
            inputBatas.close();
            return;
        }

        inputBatas.nextLine();

        String[] value = inputBatas.nextLine().split(" ");
        
        if (value.length != n) {
            System.out.println("Jumlah bilangan yang dimasukkan tidak sesuai.");
            inputBatas.close();
            return;
        }

        int jumlahInt = 0;
        int jumlahDec = 0;

        for  (String input : value) {
            try {
                double angka = Double.parseDouble(input);
                if (angka == (int) angka) {
                    jumlahInt++;
                } else {
                    jumlahDec++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input " + input + " tidak valid.");
                inputBatas.close();
                return;
            }
        }
        
        System.out.println("Bilangan Bulat = " + jumlahInt);
        System.out.println("Bilangan Desimal = " + jumlahDec);

        inputBatas.close();
    }
}    