import java.util.InputMismatchException;
import java.util.Scanner;

public class TP5_1_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            runProgram(sc);
        }
    }

    private static void runProgram(Scanner sc) {
        while (true) {
            try {
                System.out.println("-".repeat(40));
                System.out.println(" ".repeat(8) + "===== BANGUN RUANG =====");
                System.out.println(
                        "1. KUBUS\n" +
                        "2. BALOK\n" +
                        "3. BOLA\n" +
                        "4. KUBUS"
                );
                System.out.println(" ".repeat(8) + "===== BANGUN DATAR =====");
                System.out.println(
                        "5. PERSEGI\n" +
                        "6. PERSEGI PANJANG\n" +
                        "7. LINGKARAN\n" +
                        "8. TRAPESIUM"
                );
                System.out.println("-".repeat(40));

                System.out.print("Pilihan: ");
                int opsi = sc.nextInt();
                sc.nextLine();
                System.out.println("-".repeat(40));

                if (opsi == 1) { kubus(sc); break; }
                else if (opsi == 2) { balok(sc); break; }
                else if (opsi == 3) { bola(sc); break; }
                else if (opsi == 4) { tabung(sc); break; }
                else if (opsi == 5) { persegi(sc); break; }
                else if (opsi == 6) { persegiPanjang(sc); break; }
                else if (opsi == 7) { lingkaran(sc); break; }
                else if (opsi == 8) { trapesium(sc); break; }
                else { System.out.println("Hanya tersedia opsi 1-8.\n"); }

            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }
    // ===== Bangun Ruang ===== //
    private static void kubus(Scanner sc) {
        Kubus kubus = new Kubus();

        while (true) {
            try {
                System.out.print("Masukkan panjang sisi kubus (cm): ");
                double sisi = sc.nextDouble();
                sc.nextLine();

                kubus.setSisi(sisi);

                System.out.println("-".repeat(40));
                System.out.printf("Luas kubus    : %.1f cm^2\n", kubus.getLuas());
                System.out.printf("Volume kubus  : %.1f cm^3\n", kubus.getVolume());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }

    private static void balok(Scanner sc) {
        Balok balok = new Balok();

        while (true) {
            try {
                System.out.print("Masukkan panjang balok (cm) : ");
                double panjang = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan lebar balok (cm)   : ");
                double lebar = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan tinggi balok (cm)  : ");
                double tinggi = sc.nextDouble();
                sc.nextLine();

                balok.setPanjang(panjang);
                balok.setLebar(lebar);
                balok.setTinggi(tinggi);

                System.out.println("-".repeat(40));
                System.out.printf("Luas balok    : %.1f cm^2\n", balok.getLuas());
                System.out.printf("Volume balok  : %.1f cm^3\n", balok.getVolume());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }

    private static void bola(Scanner sc) {
        Bola bola = new Bola();

        while (true) {
            try {
                System.out.print("Masukkan jari-jari bola (cm): ");
                double r = sc.nextDouble();
                sc.nextLine();

                bola.setR(r);

                System.out.println("-".repeat(40));
                System.out.printf("Luas bola    : %.1f cm^2\n", bola.getLuas());
                System.out.printf("Volume bola  : %.1f cm^3\n", bola.getVolume());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }

    private static void tabung(Scanner sc) {
        Tabung tabung = new Tabung();

        while (true) {
            try {
                System.out.print("Masukkan jari-jari tabung (cm) : ");
                double r = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan tinggi tabung (cm)    : ");
                double tinggi = sc.nextDouble();
                sc.nextLine();

                tabung.setR(r);
                tabung.setTinggi(tinggi);

                System.out.println("-".repeat(40));
                System.out.printf("Luas tabung    : %.1f cm^2\n", tabung.getLuas());
                System.out.printf("Volume tabung  : %.1f cm^3\n", tabung.getVolume());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }
    // ===== Bangun Datar ===== //
    private static void persegi(Scanner sc) {
        Persegi persegi = new Persegi();

        while (true) {
            try {
                System.out.print("Masukkan panjang sisi persegi (cm): ");
                double sisi = sc.nextDouble();
                sc.nextLine();

                persegi.setSisi(sisi);

                System.out.println("-".repeat(40));
                System.out.printf("Keliling persegi : %.1f cm\n", persegi.getKeliling());
                System.out.printf("Luas persegi     : %.1f cm^2\n", persegi.getLuas());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }

    private static void persegiPanjang(Scanner sc) {
        PersegiPanjang persegiPanjang = new PersegiPanjang();

        while (true) {
            try {
                System.out.print("Masukkan panjang persegi panjang (cm) : ");
                double panjang = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan lebar persegi panjang (cm)   : ");
                double lebar = sc.nextDouble();
                sc.nextLine();

                persegiPanjang.setPanjang(panjang);
                persegiPanjang.setLebar(lebar);

                System.out.println("-".repeat(40));
                System.out.printf("Keliling persegi panjang : %.1f cm\n", persegiPanjang.getKeliling());
                System.out.printf("Luas persegi panjang     : %.1f cm^2\n", persegiPanjang.getLuas());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }

    private static void lingkaran(Scanner sc) {
        Lingkaran lingkaran = new Lingkaran();

        while (true) {
            try {
                System.out.print("Masukkan jari-jari lingkaran (cm): ");
                double r = sc.nextDouble();
                sc.nextLine();

                lingkaran.setR(r);

                System.out.println("-".repeat(40));
                System.out.printf("Keliling lingkaran : %.1f cm\n", lingkaran.getKeliling());
                System.out.printf("Luas lingkaran     : %.1f cm^2\n", lingkaran.getLuas());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }

    private static void trapesium(Scanner sc) {
        Trapesium trapesium = new Trapesium();

        while (true) {
            try {
                // sisi1 dan sisi2 = sisi horizontal
                // sisi3 dan sisi4 = sisi miring
                System.out.print("Masukkan sisi 1 trapesium (cm): ");
                double sisi1 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan sisi 2 trapesium (cm): ");
                double sisi2 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan sisi 3 trapesium (cm): ");
                double sisi3 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan sisi 4 trapesium (cm): ");
                double sisi4 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Masukkan tinggi trapesium (cm): ");
                double tinggi = sc.nextDouble();
                sc.nextLine();

                trapesium.setSisi1(sisi1);
                trapesium.setSisi2(sisi2);
                trapesium.setSisi3(sisi3);
                trapesium.setSisi4(sisi4);
                trapesium.setTinggi(tinggi);

                System.out.println("-".repeat(40));
                System.out.printf("Keliling trapesium : %.1f cm\n", trapesium.getKeliling());
                System.out.printf("Luas trapesium     : %.1f cm^2\n", trapesium.getLuas());
                System.out.println("-".repeat(40));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka.\n");
                sc.nextLine();
            }
        }
    }
}

class BangunRuang {
    protected double sisi, panjang, lebar, tinggi, r;
    protected final double PI = Math.PI;

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getLuas() { return 0; }

    public double getVolume() { return 0; }
}

class Kubus extends BangunRuang {
    @Override
    public double getLuas() {
        return 6 * super.sisi * super.sisi;
    }

    @Override
    public double getVolume() {
        return super.sisi * super.sisi * super.sisi;
    }
}

class Balok extends BangunRuang {
    @Override
    public double getLuas() {
        return 2 * ((super.panjang * super.lebar) + (super.panjang * super.tinggi) + (super.lebar * super.tinggi));
    }

    @Override
    public double getVolume() {
        return panjang * lebar * tinggi;
    }
}

class Bola extends BangunRuang {
    @Override
    public double getLuas() {
        return 4 * super.PI * super.r * super.r;
    }

    @Override
    public double getVolume() {
        return 4 / 3 * super.PI * super.r * super.r * super.r;
    }
}

class Tabung extends BangunRuang {
    @Override
    public  double getLuas() { return 2 * super.PI * super.r * (super.r + super.tinggi); }

    @Override
    public double getVolume() {
        return super.PI * super.r * super.r * super.tinggi;
    }
}

class BangunDatar {
    protected double sisi, panjang, lebar, tinggi, r;
    protected final double PI = Math.PI;

    public void setSisi(double sisi) { this.sisi = sisi; }

    public void setPanjang(double panjang) { this.panjang = panjang; }

    public void setLebar(double lebar) { this.lebar = lebar; }

    public void setTinggi(double tinggi) { this.tinggi = tinggi; }

    public void setR(double r) { this.r = r; }

    public double getKeliling() { return 0; }

    public double getLuas() { return 0; }
}

class Persegi extends BangunDatar {
    @Override
    public double getKeliling() { return 4 * super.sisi; }

    @Override
    public double getLuas() { return super.sisi * super.sisi; }
}

class PersegiPanjang extends BangunDatar {
    @Override
    public double getKeliling() { return 2 * (super.panjang + super.lebar); }

    @Override
    public double getLuas() { return super.panjang * super.lebar; }
}

class Lingkaran extends BangunDatar {
    @Override
    public double getKeliling() { return 2 * super.PI * super.r; }

    @Override
    public double getLuas() { return super.PI * super.r * super.r; }
}

class Trapesium extends BangunDatar {
    // sisi1 dan sisi2 = sisi horizontal
    // sisi3 dan sisi4 = sisi miring
    private double sisi1, sisi2, sisi3, sisi4;

    public void setSisi1(double sisi1) { this.sisi1 = sisi1; }

    public void setSisi2(double sisi2) { this.sisi2 = sisi2; }

    public void setSisi3(double sisi3) { this.sisi3 = sisi3; }

    public void setSisi4(double sisi4) { this.sisi4 = sisi4; }

    @Override
    public double getKeliling() { return this.sisi1 + this.sisi2 + this.sisi3 + this.sisi4; }

    @Override
    public double getLuas() { return 0.5 * (this.sisi1 + this.sisi2) * super.tinggi; }
}