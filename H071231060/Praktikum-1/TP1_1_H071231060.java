import java.util.Scanner;

public class Nomor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah bilangan: ");
        int n = scanner.nextInt();

        int jumlahBulat = 0;
        int jumlahDesimal = 0;

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan bilangan: ");
            String bilangan = scanner.nextLine();

            try {
                Integer.parseInt(bilangan);
                jumlahBulat++;
            } catch (NumberFormatException e1) {
                try {
                    Double.parseDouble(bilangan);
                    jumlahDesimal++;
                } catch (NumberFormatException e2) {
                    System.out.println("'" + bilangan + "' bukan bilangan, akan diskip.");
                    
                }
            }
        }

        System.out.println(jumlahBulat + " Bilangan Bulat");
        System.out.println(jumlahDesimal + " Bilangan Desimal");

        scanner.close();
    }
}
