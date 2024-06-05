import java.util.Scanner;

class Mathematic{
    double angka1;
    double angka2;
    double angka3;

    static double inputUser(String tanya){
        Scanner input = new Scanner(System.in);
        double check;

        while (true) {
            System.out.print(tanya);
            String cek = input.nextLine().trim();
            if (cek.isEmpty()) {
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Inputan tidak boleh kosong");
            }
            else{
                try {
                    check = Integer.parseInt(cek);
                    if (check <= 0) {
                        System.out.printf("%s\n", "-".repeat(50));
                        System.out.println("Sisi tidak boleh nagatif ataupun bernilai 0");
                    }
                    else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Terjadi error karena " + e);
                }
            }
        }
        return check;
    }
}

class Ruang extends Mathematic{
    double luas_Permukaan;
    double volume;

    void Result(int menu){
        if (menu == 1) {
            luas_Permukaan = 6*(angka1*angka1);
            System.out.println("Luas permukaan : "+luas_Permukaan);
            volume = angka1*angka1*angka1;
            System.out.println("Volume : "+volume);
        }
        else if (menu == 2) {
            luas_Permukaan = 2*(angka1*angka2 + angka1*angka3 + angka2*angka3);
            System.out.println("Luas permukaan : "+luas_Permukaan);
            volume = angka1*angka2*angka3;
            System.out.println("Volume : "+volume);
        }
        else if (menu == 3) {
            luas_Permukaan = 4 * Math.PI * angka1 * angka1;
            System.out.println("Luas permukaan : "+luas_Permukaan);
            volume = (4/3) * Math.PI * angka1 * angka1 * angka1;
            System.out.println("Volume : "+volume);
        }
        else if (menu == 4) {
            luas_Permukaan = 2 * Math.PI * angka1 * (angka1 + angka2);
            System.out.println("Luas permukaan : "+luas_Permukaan);
            volume = Math.PI * angka1 * angka1 * angka2;
            System.out.println("Volume : "+volume);
        }
    }

    void kubus(){
        angka1 = inputUser("Masukkan sisi kubus : ");
        Result(1);
    }

    void balok(){
        angka1 = inputUser("Masukkan sisi 1 balok : ");
        angka2 = inputUser("Masukkan sisi 2 balok : ");
        angka3 = inputUser("Masukkan sisi 3 balok : ");
        Result(2);
    }

    void bola(){
        angka1 = inputUser("Masukkan jari-jari bola : ");
        Result(3);
    }

    void tabung(){
        angka1 = inputUser("Masukkan jari-jari tabung : ");
        angka2 = inputUser("Masukkan tinggi tabung : ");
        Result(4);
    }

}

class Datar extends Mathematic{
    double angka4;
    double angka5;
    double luas;
    double keliling;

    void Result(int menu){
        if (menu == 1) {
            luas = angka1 * angka1;
            System.out.println("Luas : "+luas);
            keliling = 4 * angka1;
            System.out.println("Keliling : "+keliling);
        }
        else if (menu == 2) {
            luas = angka1 * angka2;
            System.out.println("Luas : "+luas);
            keliling = 2 * (angka1 + angka2);
            System.out.println("Keliling : "+keliling);
        }
        else if (menu == 3) {
            luas = Math.PI * angka1 * angka1;
            System.out.println("Luas : "+luas);
            keliling = 2 * Math.PI * angka1;
            System.out.println("Keliling : "+keliling);
        }
        else if (menu == 4) {
            luas = (0.5) * (angka1 + angka2) * angka5;
            System.out.println("Luas : "+luas);
            keliling = angka1 + angka2 + angka3 + angka4;
            System.out.println("Keliling : "+keliling);
        }
    }

    void persegi(){
        angka1 = inputUser("Masukkan sisi persegi : ");
        Result(1);
    }

    void persegi_panjang(){
        angka1 = inputUser("Masukkan sisi 1 persegi panjang : ");
        angka2 = inputUser("Masukkan sisi 2 persegi panjang : ");
        Result(2);
    }

    void lingkaran(){
        angka1 = inputUser("Masukkan jari-jari lingkaran : ");
        Result(3);
    }

    void trapesium(){
        angka1 = inputUser("Masukkan sisi atas trapesium : ");
        angka2 = inputUser("Masukkan sisi bawah trapesium : ");
        angka3 = inputUser("Masukkan sisi samping 1 trapesium : ");
        angka4 = inputUser("Masukkan sisi samping 2 trapesium : ");
        angka5 = inputUser("Masukkan tinggi trapesium : ");
        Result(4);
    }
}



public class Soal01{
    static void Menu(){
        System.out.printf("%s\n","=".repeat(50));
        System.out.println("             ===== BANGUN RUANG =====\n1. Kubus\n2. Balok\n3. Bola\n4. Tabung");
        System.out.println("             ===== BANGUN DATAR =====\n5. Persegi\n6. Persegi Panjang\n7. Lingkaran\n8. Trapesium");
        System.out.printf("%s\n","=".repeat(50));
        }
    public static void main(String[] args) {
        Menu();
        while (true) {
            int menu = (int) Mathematic.inputUser("Pilihan : ");
            if (menu >= 1 && menu <= 4) {
                Ruang ruang = new Ruang();
                if (menu == 1) {
                    ruang.kubus();
                }
                else if (menu == 2) {
                    ruang.balok();
                }
                else if (menu == 3) {
                    ruang.bola();
                }
                else if (menu == 4) {
                    ruang.tabung();
                }
                Menu();
            }
            else if (menu >= 5 && menu <= 8) {
                Datar datar = new Datar();
                if (menu == 5) {
                    datar.persegi();
                }
                else if (menu == 6) {
                    datar.persegi_panjang();
                }
                else if (menu == 7) {
                    datar.lingkaran();
                }
                else if (menu == 8) {
                    datar.trapesium();
                }
                Menu();
            }
            else{
                System.out.printf("%s\n","=".repeat(50));
                System.out.println("Invalid input");
            }
        }
        
    }
}