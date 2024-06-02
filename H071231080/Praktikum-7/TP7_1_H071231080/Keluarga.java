import java.util.Scanner;

public class Keluarga {
    
    String status;
    
    void statusKeluarga(){

        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Status (Menikah/Belum Menikah) : ");

            status = sc.nextLine().toLowerCase();
            if (status.equals("menikah") || status.equals("belum menikah")){
                break;
            } else {
                System.out.println("Status yang dimasukkan tidak valid. Silakan coba lagi.");
            }
            
        }
        
    }
}
