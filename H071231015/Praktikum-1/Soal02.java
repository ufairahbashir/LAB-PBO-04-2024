import java.util.Scanner;

public class Soal02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Judul Film : \n>");
        String judul = input.nextLine().toLowerCase();
        ubahJudul(judul);

    }

    public static void ubahJudul(String judul){
        char []isi = new char[judul.length()];
        char x = ' ', y, ubah;
        boolean spasi = false;


        for (int i=0; i < judul.length(); i++){
            y = judul.charAt(i);
            if (y == x) {
                isi[i] = ' ';  // isi : " Na"
                spasi = true;

                
            }
            else{

                if (spasi) {
                    ubah = Character.toUpperCase(y); // input :  Nama saya
                    isi[i] = ubah;
                    spasi = false;
                }
                else if (i == 0) {
                    ubah = Character.toUpperCase(y);
                    isi[i] = ubah;
                }
                else{
                    isi[i] = y;
                }
            }

        }
        for (int i =0; i < judul.length(); i++){
                System.out.print(isi[i]);
        }


    }
}
