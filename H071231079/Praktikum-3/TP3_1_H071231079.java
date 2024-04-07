import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Mobil { 
    private String nomorPlat;
    private String merek;

    public Mobil(String nomorPlat, String merek) {
        this.nomorPlat = nomorPlat;
        this.merek = merek;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public void setNomorPlat(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }
}

class SmartParking {
    private String namaTempat;
    private int kapasitas;
    private List<Mobil> daftarMobil; //variable instance (Objek Mobil)

    //Contructor 1
    public SmartParking(String namaTempat, int kapasitas, List<Mobil> daftarMobil) {
        this.namaTempat = namaTempat;
        this.kapasitas = kapasitas;
        this.daftarMobil = daftarMobil;
    }

    //Contructor 2
    public SmartParking(String namaTempat, int kapasitas) {
        this.namaTempat = namaTempat;
        this.kapasitas = kapasitas;
        this.daftarMobil = new ArrayList<>();
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public List<Mobil> getDaftarMobil() {
        return daftarMobil;
    }

    public void setDaftarMobil(List<Mobil> daftarMobil) {
        this.daftarMobil = daftarMobil;
    }

    // Behavior 1: Parkir mobil
    public void parkirMobil(Mobil mobil) {
        if (getDaftarMobil().size() < getKapasitas()) {
            daftarMobil.add(mobil);
        } else {
            System.out.println("Parkiran di " + getNamaTempat() + " penuh. Mobil " + mobil.getNomorPlat() + " tidak dapat diparkir.");
        }
    }

    // Behavior 2: Keluarkan mobil
    public void keluarkanMobil(String nomorPlat) {
        Iterator<Mobil> iterator = daftarMobil.iterator();
        while (iterator.hasNext()) {
            Mobil mobil = iterator.next();
            if (mobil.getNomorPlat().equals(nomorPlat)) {
                iterator.remove();
                System.out.println("Mobil dengan plat nomor " + nomorPlat + " berhasil dikeluarkan dari " + namaTempat);
                return;
            }
        }
        System.out.println("Mobil dengan plat nomor " + nomorPlat + " tidak ditemukan di " + namaTempat);
    }

    // Behavior 3: Daftar mobil berdasarkan merek
    public void daftarMobilBerdasarkanMerek(String merek) {
        boolean found = false;
        System.out.println("====== Daftar Mobil Terparkir Dengan Merek " + merek + " ======");
        for (Mobil mobil : daftarMobil) {
            if (mobil.getMerek().equalsIgnoreCase(merek)) {
                System.out.println("- " + mobil.getNomorPlat());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Mobil dengan merek " + merek + " tidak ditemukan di " + getNamaTempat());
        }
    }

    // Behavior 4: Tampilkan informasi parkiran
    public void displayInfoParkiran() {
        System.out.println("============ Info Parkiran di " + getNamaTempat() + " ============="); 
        System.out.println("Kapasitas Parkir         : " + getKapasitas());
        System.out.println("Jumlah Mobil Terparkir   : " + getDaftarMobil().size());
        System.out.println("Daftar Mobil Terparkir   : ");
        for (Mobil mobil : daftarMobil) {
            System.out.println("- " + mobil.getMerek() + " (" + mobil.getNomorPlat() + ")");
        }
    }
}

public class TP3_1_H071231079 {
    public static void main(String[] args) {
        SmartParking tempatParkir = new SmartParking("Parkiran MIPA", 20);

        tempatParkir.parkirMobil(new Mobil("B 1234 AB", "Toyota"));
        tempatParkir.parkirMobil(new Mobil("B 5678 CD", "Honda"));
        tempatParkir.parkirMobil(new Mobil("B 9012 EF", "Suzuki"));
        tempatParkir.parkirMobil(new Mobil("B 3456 GH", "Toyota"));
        tempatParkir.parkirMobil(new Mobil("B 9019 EF", "Suzuki"));
        tempatParkir.parkirMobil(new Mobil("B 3458 GH", "Toyota"));

        tempatParkir.keluarkanMobil("B 5678 CD");

        System.out.println();
        tempatParkir.displayInfoParkiran();

        System.out.println();
        tempatParkir.daftarMobilBerdasarkanMerek("Toyota");
    }
}