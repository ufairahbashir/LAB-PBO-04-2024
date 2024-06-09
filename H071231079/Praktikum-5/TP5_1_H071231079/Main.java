package TP5_1_H071231079;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean validInput = false;
        while (!validInput) {
            System.out.println("--------BANGUN RUANG--------");
            System.out.println("1. Kubus");
            System.out.println("2. Balok");
            System.out.println("3. Bola");
            System.out.println("4. Tabung");
            System.out.println("--------BANGUN DATAR--------");
            System.out.println("5. Persegi");
            System.out.println("6. Persegi Panjang");
            System.out.println("7. Lingkaran");
            System.out.println("8. Trapesium");
            System.out.println("----------------------------");
            System.out.print(">> Pilihan : ");

            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
                    continue;
                }

                int opsi = Integer.parseInt(input);
                
                // Lakukan validasi range menu di sini
                if (opsi < 1 || opsi > 8) {
                    System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 4.");
                    continue;
                }

                validInput = true;

                switch (opsi) {
                    case 1:
                        double sisiKubus = inputDouble(sc, "Masukkan Sisi Kubus : ");
                        Kubus kubus = new Kubus(sisiKubus);
                        kubus.display();
                        break;
                    case 2:
                        double panjangBalok = inputDouble(sc, "Masukkan Panjang Balok : ");
                        double lebarBalok = inputDouble(sc, "Masukkan Lebar Balok   : ");
                        double tinggiBalok = inputDouble(sc, "Masukkan Tinggi Balok  : ");
                        Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
                        balok.display();
                        break;
                    case 3:
                        double jariJariBola = inputDouble(sc, "Masukkan Jari-jari Bola : ");
                        Bola bola = new Bola(jariJariBola);
                        bola.display();
                        break;
                    case 4:
                        double jariJariTabung = inputDouble(sc, "Masukkan Jari-jari Tabung : ");
                        double tinggiTabung = inputDouble(sc, "Masukkan Tinggi Tabung    : ");
                        Tabung tabung = new Tabung(jariJariTabung, tinggiTabung);
                        tabung.display();
                        break;
                    case 5:
                        double sisiPersegi = inputDouble(sc, "Masukkan Sisi Persegi : ");
                        Persegi persegi = new Persegi(sisiPersegi);
                        persegi.display();
                        break;
                    case 6:
                        double panjangPersegiPanjang = inputDouble(sc, "Masukkan Panjang Persegi Panjang : ");
                        double lebarPersegiPanjang   = inputDouble(sc, "Masukkan Lebar Persegi Panjang   : ");
                        PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);
                        persegiPanjang.display();
                        break;
                    case 7:
                        double jariJariLingkaran = inputDouble(sc, "Masukkan Jari-jari Lingkaran : ");
                        Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);
                        lingkaran.display();
                        break;
                    case 8:
                        double sisi1 = inputDouble(sc, "Masukkan Sisi 1           : ");
                        double sisi2 = inputDouble(sc, "Masukkan Sisi 2           : ");
                        double sisi3 = inputDouble(sc, "Masukkan Sisi 3           : ");
                        double sisi4 = inputDouble(sc, "Masukkan Sisi 4           : ");
                        double tinggiTrapesium = inputDouble(sc, "Masukkan Tinggi Trapesium : ");
                        Trapesium trapesium = new Trapesium(sisi1, sisi2, sisi3, sisi4, tinggiTrapesium);
                        trapesium.display();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Masukkan angka antara 1 sampai 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka sebagai pilihan. Silahkan coba lagi.");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan. Silahkan coba lagi.");
                sc.nextLine(); // Membersihkan input buffer
            }
        }
        sc.close(); 
    }

    // Input dan validasi inputan bertipe data double
    public static double inputDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine();
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        }
    }
}