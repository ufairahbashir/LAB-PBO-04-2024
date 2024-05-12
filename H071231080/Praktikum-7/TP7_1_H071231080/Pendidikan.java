import java.util.Scanner;

public class Pendidikan {
    
    String inputPendidikan;

    public void prosesPendidikan(){
        
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Masukkan tingkat pendidikan (SD/SMP/SMA/S1/S2/S3): ");
            
            inputPendidikan = scan.nextLine().toUpperCase();
            if (inputPendidikan.equals("SD") || inputPendidikan.equals("SMP") || inputPendidikan.equals("SMA") ||
                inputPendidikan.equals("S1") || inputPendidikan.equals("S2") || inputPendidikan.equals("S3")) {
                    break;
                } else {
                    System.out.println("Tingkat pendidikan yang dimasukkan tidak valid. Silakan coba lagi.");
                }
        }
    }

    public String getInputPendidikan() {
        return inputPendidikan;
    }

    public void setInputPendidikan(String inputPendidikan) {
        this.inputPendidikan = inputPendidikan;
    }
    
    
}

