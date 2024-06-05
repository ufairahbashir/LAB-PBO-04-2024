import java.util.*;

public class Livecoding01 {
    double angka1;
    double angka2;
    double angka3;

    static double inputUserAngka(String tanya){
        String huruf;
        double result;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(tanya);
            huruf = input.nextLine().trim();
            if (huruf.isEmpty()) {
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("Inputan tidak boleh kosong");
            }
            else{
                try {
                    result = Integer.parseInt(huruf);
                    break;
                } catch (Exception e) {
                    System.out.printf("%s\n","-".repeat(50));
                    System.out.println("Terjadi error karena " + e);
                }
            }
        }
        return result;
    }

    // static String inputUserKosong(String tanya){
    //     String kosong;
    //     Scanner input = new Scanner(System.in);
    //     while (true) {
    //         System.out.println(tanya);
    //         kosong = input.nextLine();
    //         if (kosong.isEmpty()) {
    //             System.out.printf("%s\n","-".repeat(50));
    //             System.out.println("Inputan tidak boleh kosong");
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return kosong;
    // }
}


class Ruang extends Livecoding01{
    double luas_Permukaan;
    double volume;

    void kubus(){
        angka1 = inputUserAngka("Masukkan sisi kubus : ");
        luas_Permukaan = 6*angka1;
        System.out.println("Luas permukaan : " + luas_Permukaan);
        volume = angka1*angka1*angka1;
        System.out.println("Volume : " + volume);
    }

    void balok(){
        angka1 = inputUserAngka("Masukkan sisi 1 balok : ");
        angka2 = inputUserAngka("Masukkan sisi 2 balok : ");
        angka3 = inputUserAngka("Masukkan sisi 3 balok : ");
        luas_Permukaan = 2*(angka1*angka2 + angka1+angka3 + angka2*angka3);
        System.out.println("Luas permukaan : " + luas_Permukaan);
        volume = angka1*angka2*angka3;
        System.out.println("Volume : " + volume);
    }

    void bola(){
        angka1 = inputUserAngka("Masukan jari-jari bola : ");
        luas_Permukaan = 4*Math.PI*angka1*angka1;
        System.out.println("Luas permukaan : " + luas_Permukaan);
        volume = (4/3) * Math.PI * angka1*angka1*angka1;
        System.out.println("Volume : " + volume);
    }

    void tabung(){
        angka1 = inputUserAngka("Masukkan jari-jari tabung : ");
        angka2 = inputUserAngka("Masukkan tinggi tabung : ");
        luas_Permukaan = (2 * Math.PI * angka1 * angka1) + (2*Math.PI*angka1*angka2);
        System.out.println("Luas permukaan : " + luas_Permukaan);
        volume = Math.PI * angka1*angka1 * angka2;
        System.out.println("Volume : " + volume);
    }
}

class Datar extends Livecoding01{
    double luas;
    double keliling;
    double angka4;
    double angka5;

    void persegi(){
        angka1 = inputUserAngka("Masukkan sisi persegi : ");
        luas = angka1*angka1;
        System.out.println("Luas : " +luas);
        keliling = angka1 * 4;
        System.out.println("Keliling : " + keliling);
    }

    void persegi_panjang(){
        angka1 = inputUserAngka("Masukkan sisi 1 persegi panjang : ");
        angka2 = inputUserAngka("Masukkan sisi 2 persegi panjang : ");
        luas = angka1*angka2;
        System.out.println("Luas : " +luas);
        keliling = 2*angka1 + 2*angka2;
        System.out.println("Keliling : " + keliling);
    }

    void lingkaran(){
        angka1 = inputUserAngka("Masukkan jari-jari lingkaran : ");
        luas = Math.PI * angka1*angka1;
        System.out.println("Luas : " +luas);
        keliling = 2*Math.PI*angka1;
        System.out.println("Keliling : " + keliling);
    }

    void trapesium(){
        angka1 = inputUserAngka("Masukkan sisi atas trapesium : ");
        angka2 = inputUserAngka("Masukkan sisi bawah trapesium : ");
        angka3 = inputUserAngka("Masukkan sisi samping 1 trapesium : ");
        angka4 = inputUserAngka("Masukkan sisi samping 2 trapesium : ");
        angka5 = inputUserAngka("Masukkan tinggi trapesium : : ");

        luas = (0.5)*angka5*(angka1 + angka2);
        System.out.println("Luas : " +luas);
        keliling = angka1 + angka2 + angka3 + angka4;
        System.out.println("Keliling : " + keliling);
    }
}


class Main{
    public static void main(String[] args) {
        while (true) {
            System.out.printf("%s\n","-".repeat(50));
            System.out.println("        ===== BANGUN RUANG =====\n1. Kubus\n2. Balok\n3. Bola\n4. Tabung");
            System.out.println("        ===== BANGUN DATAR =====\n5. Persegi\n6. Persegu Panjang\n7. Lingkaran\n8. Trapesium");
            System.out.printf("%s\n","-".repeat(50));
            int pilih = (int) Livecoding01.inputUserAngka("Pilihan : ");
            if (pilih >= 1 && pilih <= 4) {
                Ruang ruang = new Ruang();
                if (pilih == 1) {
                    ruang.kubus();
                }
                else if (pilih == 2) {
                    ruang.balok();
                }
                else if(pilih == 3){
                    ruang.bola();
                }
                else if (pilih == 4) {
                    ruang.tabung();
                }
            }
            else if (pilih >= 5 && pilih <= 8) {
                Datar datar = new Datar();
                if (pilih == 5) {
                    datar.persegi();
                }
                else if(pilih == 6){
                    datar.persegi_panjang();
                }
                else if (pilih == 7) {
                    datar.lingkaran();
                }
                else if (pilih == 8) {
                    datar.trapesium();
                }
            }
            else{
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("Invalid input");
            }
        }
    }
}


