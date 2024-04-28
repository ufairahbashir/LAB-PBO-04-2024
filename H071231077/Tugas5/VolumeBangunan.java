import java.util.*;

public class VolumeBangunan{
    double sisi;
    double panjang;
    double lebar;
    double tinggi;
    double radius;
    double volume;
    double luas;
    double keliling;



    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        VolumeBangunan main  = new VolumeBangunan();
        main.menuUtama();
        
    }

    public static int tangkisIntKosong(){
        while (true) {
            String input = sc.nextLine();

            if (input.isEmpty()) {
                System.out.println("Tidak boleh kosong");
                continue;
            }
            try {
                int opsi = Integer.parseInt(input);
                return opsi;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
        }
    }
    public static double tangkisDoubleKosong(){
        while (true) {
            String input = sc.nextLine();

            if (input.isEmpty()) {
                System.out.println("Tidak boleh kosong");
                continue;
            }
            try {
                Double opsi = Double.parseDouble(input);
                return opsi;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
            
        }
    }





    public void menuUtama(){
        System.out.println("=== Bangun Ruang ===");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Bola");
        System.out.println("4. Tabung");
        System.out.println();
        System.out.println("=== Bangun Datar ===");
        System.out.println("5. Persegi");
        System.out.println("6. Persegi Panjang");
        System.out.println("7. Lingkaran");
        System.out.println("8. Trapesium");
        System.out.print("> ");
        int selectMenu = tangkisIntKosong();

        switch (selectMenu) {
            case 1:
                Kubus kubus = new Kubus();
                kubus.hitungKubus();
                break;
            case 2:
                Balok balok = new Balok();
                balok.hitungBalok();
                break;
            case 3:
                Bola bola = new Bola();
                bola.hitungBola();
                break;
            case 4:
                Tabung tabung = new Tabung ();
                tabung.hitungTabung();
                break;
            case 5:
                Persegi persegi = new Persegi();
                persegi.hitungPersegi();
                break;
            case 6:
                PersegiPanjang Panjang2 = new PersegiPanjang();
                Panjang2.hitungPersegiPanjang();
                break;
            case 7:
                Lingkaran lingkaran = new Lingkaran();
                lingkaran.hitungLingkaran();
                break;
            case 8:
                Trapesium trapesium = new Trapesium();
                trapesium.hitungTrapesium();
                break;
            default:
                break;
        }


    }
}

class Kubus extends VolumeBangunan{
    public double hitungKubus(){
        System.out.print("Masukkan sisi kubus: ");
        sisi = tangkisDoubleKosong();

        luas = 6 * sisi * sisi;
        volume = sisi * sisi * sisi;

        System.out.println("-----------------");
        System.out.println("Luas kubus : " + luas);
        System.out.println("Volume kubus: " + volume);
        System.out.println("-----------------");
        menuUtama();
        return luas;
    }
}

class Balok extends VolumeBangunan{
    public double hitungBalok(){
        System.out.print("Masukkan Panjang Balok : ");
        panjang = tangkisDoubleKosong();
        System.out.print("Masukkan Lebar Balok : ");
        lebar = tangkisDoubleKosong();
        System.out.print("Masukkan Tinggi Balok : ");
        tinggi = tangkisDoubleKosong();


        volume = panjang * lebar * tinggi;
        luas = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        System.out.println("-----------------");
        System.out.println("Luas balok : " + luas);
        System.out.println("Volume balok: " + volume);
        System.out.println("-----------------");
        menuUtama();
        return luas;
  
    }
}

class Bola extends VolumeBangunan{
    public double hitungBola(){
        System.out.print("Masukkan radius bola: ");
        radius = tangkisDoubleKosong();

        volume = (4.0 / 3.0) * Math.PI * radius * 3;
        luas = 4 * Math.PI * radius * 2;
        System.out.println("-----------------");
        System.out.println("Luas bola : " + luas);
        System.out.println("Volume bola: " + volume);
        System.out.println("-----------------");
        menuUtama();
        return luas;
    }
}
class Tabung extends VolumeBangunan{
    public double hitungTabung(){
        System.out.print("Masukkan Radius tabung : ");
        radius = tangkisDoubleKosong();
        System.out.print("Masukka Tinggi tabung : ");
        tinggi = tangkisDoubleKosong();
        
        luas = 2 * Math.PI * radius * (radius + radius);
        volume = Math.PI * radius *(radius * tinggi) ;
        System.out.println("-----------------");
        System.out.println("Luas tabung : " + luas);
        System.out.println("Volume tabung: " + volume);
        System.out.println("-----------------");
        menuUtama();
        return luas;
    }
}


class Persegi extends VolumeBangunan{
    public double hitungPersegi(){
        System.out.print("Masukkan sisi persegi: ");
        sisi = tangkisDoubleKosong();

        luas = sisi * sisi;
        keliling = 4*sisi;

        System.out.println("-----------------");
        System.out.println("Luas persegi : " + luas);
        System.out.println("Volume persegi: " + keliling);
        System.out.println("-----------------");
        menuUtama();
        return luas;

    }
}
class PersegiPanjang extends VolumeBangunan{
    public double hitungPersegiPanjang(){
        System.out.print("Masukkan panjang persegi panjang: ");
        panjang = tangkisDoubleKosong();
        System.out.println("Masukkan lebar persegi panjang: ");
        lebar = tangkisDoubleKosong();

        luas = panjang * lebar;
        keliling = (2* panjang) + (2 * lebar);

        System.out.println("-----------------");
        System.out.println("Luas persegi : " + luas);
        System.out.println("Volume persegi: " + keliling);
        System.out.println("-----------------");
        menuUtama();
        return luas;
    }
}
class Lingkaran extends VolumeBangunan{
    public double hitungLingkaran(){
        System.out.print("Masukkan radius: ");
        radius = tangkisDoubleKosong();

        luas = 2 * Math.PI * radius;
        keliling = Math.PI * radius* radius;

        System.out.println("-----------------");
        System.out.println("Luas persegi : " + luas);
        System.out.println("Volume persegi: " + keliling);
        System.out.println("-----------------");
        menuUtama();
        return luas;

    }
}
class Trapesium extends VolumeBangunan{
    public double hitungTrapesium(){
        System.out.print("Masukkan sisi 1 trapesium: ");
        sisi =tangkisDoubleKosong();
        System.out.print("Masukkan sisi 2 trapesium: ");
        double sisi2 = tangkisDoubleKosong();
        System.out.print("Masukkan tinggi trapesium: ");
        tinggi = tangkisDoubleKosong();
        System.out.print("Masukkan sisi miring trapesium: ");
        double miring =tangkisDoubleKosong();

        luas = ((sisi + sisi2) * tinggi)/2;
        keliling = sisi + sisi2 + tinggi + miring;

        System.out.println("-----------------");
        System.out.println("Luas persegi : " + luas);
        System.out.println("Volume persegi: " + keliling);
        System.out.println("-----------------");
        menuUtama();
        return luas;

    }
}
   
        