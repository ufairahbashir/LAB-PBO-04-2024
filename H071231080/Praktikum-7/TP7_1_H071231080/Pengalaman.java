import java.util.Scanner;

public class Pengalaman extends Kehidupan {
    
    String[] pengalaman = {"Freelancer", "Magang", "Pekerja Tetap", "Tidak ada", "Lainnya"};
    
    String pengalamanLain;
    int inputPengalaman;
    double gajiSebelumnya;
    String organisasi;
    String inputOganisasi;

    
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void prosesKehidupan() {
        System.out.println("Pengalaman sebelumnya:");
        for (int i = 0; i < pengalaman.length; i++) {
            System.out.println((i + 1) + ". " + pengalaman[i]);
        }

        boolean cekInput = false;
        do {
            try {
                System.out.print("Input: ");
                inputPengalaman = Integer.parseInt(scanner.nextLine());
                if (inputPengalaman >= 1 && inputPengalaman <= pengalaman.length) {
                    cekInput = true;
                } else {
                    System.out.println("inputan tidak valid. Silahkan masukkan angka 1-5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka");
            }
        } while (!cekInput);
        
        if (inputPengalaman == 5){
            do {
                System.out.print("Pengalaman Lainnya: ");
                pengalamanLain = scanner.nextLine();
                if (pengalamanLain.isEmpty()) {
                    System.out.println("Pengalaman Lainnya tidak boleh kosong.");
                }
            } while (pengalamanLain.isEmpty());
            
            prosesKehidupan(pengalamanLain, gajiSebelumnya, inputOganisasi);
        }
        
        if (inputPengalaman != 4) {
            System.out.print("Gaji sebelumnya: ");
            gajiSebelumnya = Double.parseDouble(scanner.nextLine());
        }
        System.out.print("Pengalaman Organisasi: ");
        inputOganisasi = scanner.nextLine();

    }

    public void prosesKehidupan(String pengalamanLain, double gajiSebelumnya, String inputOganisasi) {
        this.pengalamanLain = pengalamanLain;
        this.gajiSebelumnya = gajiSebelumnya;
        this.inputOganisasi = inputOganisasi;
    }

    public String[] getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String[] pengalaman) {
        this.pengalaman = pengalaman;
    }

    public int getInputPengalaman() {
        return inputPengalaman;
    }

    public void setInputPengalaman(int inputPengalaman) {
        this.inputPengalaman = inputPengalaman;
    }

    public double getGajiSebelumnya() {
        return gajiSebelumnya;
    }

    public void setGajiSebelumnya(double gajiSebelumnya) {
        this.gajiSebelumnya = gajiSebelumnya;
    }

    public String getOrganisasi() {
        return organisasi;
    }

    public void setOrganisasi(String organisasi) {
        this.organisasi = organisasi;
    }

    public String getInputOganisasi() {
        return inputOganisasi;
    }

    public void setInputOganisasi(String inputOganisasi) {
        this.inputOganisasi = inputOganisasi;
    }

}
