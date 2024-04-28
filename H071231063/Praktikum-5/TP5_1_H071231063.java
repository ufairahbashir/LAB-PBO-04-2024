import java.util.Scanner;
class BangunRuang{
    double hitungVolum(){
        return 0;
    }
    double hitungLuasPermukaan(){
        return 0;
    }
}
class BangunDatar{
    double hitungLuas(){
        return 0;
    }
    double hitungKeliling(){
        return 0;
    }
}

class Kubus extends BangunRuang{
    double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }
    double hitungVolum(){
        return sisi*sisi*sisi;
    }
    double hitungLuasPermukaan(){
        return 6*(sisi*sisi);
    }
}
class Balok extends BangunRuang{
    double panjang, lebar, tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }
    double hitungVolum(){
        return panjang*lebar*tinggi;
    }
    double hitungLuasPermukaan(){
        return 2*((panjang*lebar)+(panjang*tinggi)+(lebar*tinggi));
    }
}

class Bola extends BangunRuang{
    double jari;

    public Bola(double jari) {
        this.jari = jari;
    }
    double hitungVolum(){
        return 4/3*3.14*jari*jari*jari;
    }
    double hitungLuasPermukaan(){
        return 4*3.14*jari*jari;
    }
}

class Tabung extends BangunRuang{
    double jari, tinggi;

    public Tabung(double jari, double tinggi) {
        this.jari = jari;
        this.tinggi = tinggi;
    }
    double hitungVolum(){
        return jari*3.14*tinggi;
    }
    double hitungLuasPermukaan(){
        return 2*3.14*jari*(jari+tinggi);
    }
}

class Persegi extends BangunDatar{
    double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    double hitungLuas(){
        return sisi*sisi;
    }
    double hitungKeliling(){
        return sisi+sisi;
    }
}

class PersegiPanjang extends BangunDatar{
    double panjang, lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }
    double hitungLuas(){
        return panjang*lebar;
    }
    double hitungKeliling(){
        return 2*(panjang+lebar);
    }
}

class Lingkaran extends BangunDatar{
    double jari;

    public Lingkaran(double jari) {
        this.jari = jari;
    }
    double hitungLuas(){
        return 3.14*jari*jari;
    }
    double hitungKeliling(){
        return 2*3.14*(jari+jari);
    }
}

class Trapesium extends BangunDatar{
    double sisi1, sisi2, sisi3, sisi4, tinggi;

    public Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }
    double hitungLuas(){
        return  sisi1*sisi2*tinggi/2;
    }
    double hitungKeliling(){
        return sisi1+sisi2+sisi3+sisi4;
    }
}


public class TP5_1_H071231063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("-------------------------------");
                System.out.println("   ===== BANGUN RUANG ======");
                System.out.println("1. KUBUS");
                System.out.println("2. BALOK");
                System.out.println("3. BOLA");
                System.out.println("4. TABUNG");
                System.out.println("   \n===== BANGUN DATAR =====");
                System.out.println("5. PERSEGI");
                System.out.println("6. PERSEGI PANJANG");
                System.out.println("7. LINGKARAN");
                System.out.println("8. TRAPESIUM");
                System.out.println("-------------------------------");
                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();
                System.out.println("-------------------------------");
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan sisi kubus: ");
                        double sisiKubus = scanner.nextDouble();
                        Kubus kubus = new Kubus(sisiKubus);
                        System.out.println("Volume kubus: " + kubus.hitungVolum());
                        System.out.println("Permukaan kubus: " + kubus.hitungLuasPermukaan());
                        validInput=true;
                        break;
                    case 2:
                        System.out.print("Masukkan panjang balok: ");
                        double panjangBalok = scanner.nextDouble();
                        System.out.print("Masukkan lebar balok: ");
                        double lebarBalok = scanner.nextDouble();
                        System.out.print("Masukkan tinggi balok: ");
                        double tinggiBalok = scanner.nextDouble();
                        Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
                        System.out.println("Volume balok: " + balok.hitungVolum());
                        System.out.println("Permukaan balok: " + balok.hitungLuasPermukaan());
                        validInput=true;
                        break;
                    case 3:
                        System.out.print("Masukkan jari bola: ");
                        double jariBola = scanner.nextDouble();
                        Bola bola = new Bola(jariBola);
                        System.out.println("Volume bola: " + bola.hitungVolum());
                        System.out.println("Permukaan bola: " + bola.hitungLuasPermukaan());
                        validInput=true;
                        break;
                    case 4:
                        System.out.print("Masukkan jari tabung: ");
                        double jariTabung = scanner.nextDouble();
                        System.out.print("Masukkan tinggi tabung: ");
                        double tinggiTabung = scanner.nextDouble();
                        Tabung tabung = new Tabung(jariTabung, tinggiTabung);
                        System.out.println("Volume tabung: " + tabung.hitungVolum());
                        System.out.println("Permukaan tabung: " + tabung.hitungLuasPermukaan());
                        validInput=true;
                        break;
                    case 5:
                        System.out.print("Masukkan sisi persegi: ");
                        double sisiPersegi = scanner.nextDouble();
                        Persegi persegi =  new Persegi(sisiPersegi);
                        System.out.println("Luas persegi: " + persegi.hitungLuas());
                        System.out.println("Keliling persegi: " + persegi.hitungKeliling());
                        validInput=true;
                        break;
                    case 6:
                        System.out.print("Masukkan panjang persegi panjang: ");
                        double pPersegiPanjang = scanner.nextDouble();
                        System.out.print("Masukkan lebar persegi panjang: ");
                        double lPersegiPanjang = scanner.nextDouble();
                        PersegiPanjang persegiPanjang = new PersegiPanjang(pPersegiPanjang, lPersegiPanjang);
                        System.out.println("Luas persegi panjang: " + persegiPanjang.hitungLuas());
                        System.out.println("Keliling persegi panjang: " + persegiPanjang.hitungKeliling());
                        validInput=true;
                        break;
                    case 7:
                        System.out.print("Masukkan jari lingkaran: ");
                        double jariLingkaran = scanner.nextDouble();
                        Lingkaran lingkaran = new Lingkaran(jariLingkaran);
                        System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
                        System.out.println("Keliling lingkaran: " + lingkaran.hitungKeliling());
                        validInput=true;
                        break;
                    case 8:
                        System.out.print("Masukkan sisi1 trapesium: ");
                        double sisi1 = scanner.nextDouble();
                        System.out.print("Masukkan sisi2 trapesium: ");
                        double sisi2 = scanner.nextDouble();
                        System.out.print("Masukkan sisi3 trapesium: ");
                        double sisi3 = scanner.nextDouble();
                        System.out.print("Masukkan sisi4 trapesium: ");
                        double sisi4 = scanner.nextDouble();
                        System.out.print("Masukkan tinggi trapesium: ");
                        double tinggiTrapesium = scanner.nextDouble();
                        Trapesium trapesium = new Trapesium(sisi1, sisi2, sisi3, sisi4, tinggiTrapesium);
                        System.out.println("Luas trapesium: " + trapesium.hitungLuas());
                        System.out.println("Keliling trapesium: " + trapesium.hitungKeliling());
                        validInput=true;
                        break;
                    default:
                        System.out.println("Inputan tidak valid");
                        break;
                    }
            }catch(Exception e){
                System.out.println("Inputan tidak valid");
                scanner.nextLine();
            }        
        }
        scanner.close();
    }  
}