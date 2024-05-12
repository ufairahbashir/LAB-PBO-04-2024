import java.util.Scanner;

public class Pengalaman extends Kehidupan {
    String[] pengalaman = {"Freelancer", "Magang", "Pekerja Tetap", "Tidak ada"};
    int inputPengalaman;
    double gajiSebelumnya;
    String organisasi;
    String inputOganisasi;
    String[] sertifikasi = {"Sertifikasi Keamanan Informasi (CISSP)",
                            "Sertifikasi Administrasi Sistem",
                            "Sertifikasi Jaringan (Cisco CCNA)",
                            "Sertifikasi Pengembangan Perangkat Lunak",
                            "Sertifikasi Cloud Computing",
                            "Lainnya",
                            "Tidak Ada"};
    String sertifikasiLainnya; // Tambahkan variabel baru untuk menyimpan sertifikasi kustom

    @Override
    void prosesKehidupan() {
        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("       PENGALAMAN SEBELUMNYA");
        System.out.println("-----------------------------------");
        for (int i = 0; i < pengalaman.length; i++) {
            System.out.println((i + 1) + ". " + pengalaman[i]);
        }

        boolean cekInput = false;
        do {
            try {
                System.out.print("Pilih pengalaman (1-4): ");
                inputPengalaman = Integer.parseInt(scan.nextLine());

                switch (inputPengalaman) {
                    case 1:
                    case 2:
                    case 3:
                        cekInput = true;
                        break;
                    case 4: // "Tidak ada" selected
                        inputPengalaman = 4; // Set inputPengalaman to 4 for processing
                        cekInput = true;
                        break;
                    default:
                        System.out.println("Input tidak valid. Silahkan masukkan angka 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        } while (!cekInput);

        if (inputPengalaman != 4) {
            System.out.print("Gaji sebelumnya                   : ");
            gajiSebelumnya = Double.parseDouble(scan.nextLine());
        }

        System.out.print("Pengalaman Organisasi (opsional)  : ");
        inputOganisasi = scan.nextLine();
    }

    public void sertifikasi() {
        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("         SERTIFIKASI");
        System.out.println("-----------------------------------");
        for (int i = 0; i < sertifikasi.length; i++) {
            System.out.println((i + 1) + ". " + sertifikasi[i]);
        }

        boolean cekInput = false;
        do {
            try {
                System.out.print("Pilih sertifikasi (1-7): ");
                int inputSertifikasi = Integer.parseInt(scan.nextLine());

                switch (inputSertifikasi) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                        cekInput = true;
                        break;
                    case 6:
                        System.out.print("Masukkan jenis sertifikasi : ");
                        sertifikasiLainnya = scan.nextLine(); // Simpan sertifikasi kustom
                        cekInput = true;
                        break;
                    default:
                        System.out.println("Input tidak valid. Silahkan masukkan angka 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        } while (!cekInput);
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

    public String getSertifikasiLainnya() {
        return sertifikasiLainnya;
    }

    public void setSertifikasiLainnya(String sertifikasiLainnya) {
        this.sertifikasiLainnya = sertifikasiLainnya;
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