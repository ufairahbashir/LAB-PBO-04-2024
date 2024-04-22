import java.util.Scanner;
import java.util.ArrayList;

class Player{
    private String Nama;
    private int Umur;
    private String Posisi;
    private int Skill;
    public Player(String nama, int umur, String posisi, int skill) {
        Nama = nama;
        Umur = umur;
        Posisi = posisi;
        Skill = skill;
    }
    public String getNama() {
        return Nama;
    }
    public void setNama(String nama) {
        Nama = nama;
    }
    public int getUmur() {
        return Umur;
    }
    public void setUmur(int umur) {
        Umur = umur;
    }
    public String getPosisi() {
        return Posisi;
    }
    public void setPosisi(String posisi) {
        Posisi = posisi;
    }
    public int getSkill() {
        return Skill;
    }
    public void setSkill(int skill) {
        Skill = skill;
    }
    public void tampilkanplayerInfo(){
        System.out.println("Nama :"+getNama()+"\nUmur :"+getUmur()+
        "\nPosisi :"+getPosisi()+"\nSkill :"+getSkill());
    }
}
class Club{
    private String Nama;
    private ArrayList<Player> Players = new ArrayList<>();
    public Club(String nama) {
        this.Nama = nama;
        this.Players = new ArrayList<>();
    }
    public String getNama() {
        return Nama;
    }
    public ArrayList<Player> getPlayer() {
        return Players;
    }

    public void informasiClub(){
        System.out.println("Nama Club :"+getNama());
        System.out.println("Jumlah Pemain :"+Players.size());
    }

    public void addPemain(Player Player){
        Players.add(Player);
        System.out.println("Berhasil menambahkan :"+Player.getNama()+" Kedalam Club :"+Nama);
    }

    public void removePemain(Player Player){
        Players.remove(Player);
        System.out.println("Berhasil menambahkan :"+Player.getNama()+" Kedalam Club :"+Nama);
    }

    public void displayPlayer(){
        System.out.println("Player yang ada didalam club "+Nama);
        for (Player Player : Players){
            Player.tampilkanplayerInfo();
            System.out.println();
        }
    }
    public int getPlayerNumber(){
        return Players.size();
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Club> Clubs = new ArrayList<>();

        while (true) {
            System.out.println("1. Tambahkan Nama Club");
            System.out.println("2. Menambahkan Pemain dalam club");
            System.out.println("3. Hapus Pemain dari club");
            System.out.println("4. Tampilkan pemain di club");
            System.out.println("5. System Out");
            System.out.println("masukkan pilihan");
            int Pilihan = readInt();

            switch (Pilihan) {
                case 1:
                    System.err.println("Masukkan nama club");
                    String newClub = readLine();
                    Club club = new Club(newClub);
                    Clubs.add(club);
                    break;
                case 2:
                    if (Clubs.isEmpty()){
                        System.out.println("nama club kosong harap isi nama club terlebih dahulu");
                        break;
                    }
                    System.out.println("Club yang tersedia");
                    for (int i = 0; i < Clubs.size(); i++) {
                        System.out.println((i + 1)+". "+Clubs.get(i).getNama());
                    }
                    
                    System.out.println("Pilih club");
                    int clubindex = readInt()-1;

                    System.out.println("Masukkan nama pemain");
                    String namaPlayer = readLine();

                    System.out.println("Masukkan Umur");
                    int umurPlayer = readInt();

                    System.out.println("Masukkan Posisi");
                    String posisiPlayer = readLine();

                    System.out.println("Masukkan Skill");
                    int skillPlayer = readInt();

                    Player player = new Player(namaPlayer, umurPlayer, posisiPlayer, skillPlayer);
                    
                    Clubs.get(clubindex).addPemain(player);
                    break;

                case 3:
                    if (Clubs.isEmpty()){
                        System.out.println("nama club kosong harap isi nama club terlebih dahulu");
                        break;
                    }
                    System.out.println("Club yang tersedia");
                    for (int i = 0; i < Clubs.size(); i++) {
                        System.out.println((i + 1)+". "+Clubs.get(i).getNama());
                    }
                    
                    System.out.println("Pilih club");
                    clubindex = readInt()-1;

                    if (Clubs.get(clubindex).getPlayerNumber() == 0) {
                        System.out.println("Tidak ada pemain di club ini");
                        break;
                    }

                    Clubs.get(clubindex).displayPlayer();
                    System.out.println("Masukkan nama pemain yang akan dihapus");
                    String playerremove = readLine();
                    boolean playerditemukan = false;
                    for (Player Player : Clubs.get(clubindex).getPlayer()) {
                        if (Player.getNama() == playerremove ) {
                            Clubs.get(clubindex).removePemain(Player);
                            playerditemukan = true;
                            break;
                        }
                    }
                    if (!playerditemukan) {
                        System.out.println("Player tidak ditemukan di di club ini");                        
                    }

                case 4:
                    System.out.println("Menampilkan pemain dari club");
                    if (Clubs.isEmpty()){
                        System.out.println("nama club kosong harap isi nama club terlebih dahulu");
                        break;
                    }
                    System.out.println("Club yang tersedia");
                    for (int i = 0; i < Clubs.size(); i++) {
                        System.out.println((i + 1)+". "+Clubs.get(i).getNama());
                    }
                    System.out.println("Pilih club");
                    clubindex = readInt()-1;
                    Clubs.get(clubindex).displayPlayer();
                    break;

                case 5:
                    System.out.println("Sistem berhenti, Sampai jumpa laagi");
                    System.exit(0);

                default:
                System.out.println("Inputan tidak valid, masukkan nilai antara 1-5");
                    break;
            }
        }

        
    
    }
    static Scanner sc = new Scanner(System.in);
    public static int readInt(){
        while (true) {
            while (!sc.hasNextInt()) {
                String next = sc.nextLine();
                if (next.isEmpty()) {
                    System.out.println("Inputan tidak boleh kosong");
                } else {
                    System.out.println("Inputan harus berupa angka");
                }
            }
            int input = sc.nextInt();
            sc.nextLine();
            return input;
        }    
    }
    public static String readLine(){
        String input = sc.next();
        while (input.isEmpty() || containnumber(input)) {
            if (input.isEmpty()) {
                System.out.println("Inputan tidak boleh kosong");
            } else {
                System.out.println("Tidak boleh ada angka");
            } input = sc.next();
            }
        return input;
    } 

    public static boolean containnumber(String input){
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}