import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Menu {

    static void tambah(ArrayList<Pelamar> daftarPelamar, ArrayList<Karyawan> daftarKaryawan, ArrayList<String> daftarNomorInduk) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        outerloop:
        while (true) {
            System.out.printf("%s\n", "=".repeat(50));
            int menu = (int) Main.inputUserAngka("Login sebagai:\n1. Applicant\n2. Reviewer\n3. Kembali\n= ");
            switch (menu) {
                case 1:
                Applicant(daftarPelamar, daftarNomorInduk);
                    break;
                case 2:
                Reviewer(daftarPelamar, daftarKaryawan);
                    break;
                case 3:
                    break outerloop;
                default:
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Invalid Input");
                AudioFile.Audio("wrong_input.wav");
                    break;
            }
        }
    }


    static void Applicant(ArrayList<Pelamar> daftarPelamar, ArrayList<String> daftarNomorInduk) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        String nomorInduk;
        while (true) {
            System.out.printf("%s\n", "=".repeat(50));
            boolean out = true;
            nomorInduk = Main.inputUserKosong("Masukkan nomor induk: ");
            for (String i : daftarNomorInduk){
                if (i.equals(nomorInduk)) {
                    out = false;
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Nomor induk sudah ada");
                    AudioFile.Audio("wrong_input.wav");
                    break;
                }
            }
            if (out == true) {
                daftarNomorInduk.add(nomorInduk);
                break;
            }
        }
        String name = Main.inputUserKosong("Masukkan nama: ");
        int age = (int) Main.inputUserAngka("Masukkan umur: ");
        new Pengalaman().prosesKehidupan(); // cekout exp, gaji dulu, dan organisasi
        int exp = (Pengalaman.getExp());
        double salary = Pengalaman.getSalary();
        String organisasi = Pengalaman.getOrganisasi();
        new Pendidikan().prosesKehidupan(); // cekout edu
        String edu = Pendidikan.getEdu();
        new Projek().prosesKehidupan(); // cekout project
        int project = (int) Projek.getProject();
        new Keluarga().prosesKehidupan(); // cekout berkeluarga
        String berkeluarga = Keluarga.getBerkeluarga();
        daftarPelamar.add(new Pelamar(nomorInduk, name, age, exp, edu, project, salary, berkeluarga, organisasi));
    }

    static void Reviewer(ArrayList<Pelamar> daftarPelamar, ArrayList<Karyawan> daftarKaryawan) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        int exp;
        String edu;
        int project;
        if (daftarPelamar.size() == 0) {
            System.out.printf("%s\n", "=".repeat(50));
            System.out.println("Saat ini belum ada pelamar");
        }
        else{
            outerloop:
            while (true) {
                System.out.printf("%s\n", "=".repeat(50));
                int menu = (int) Main.inputUserAngka("Silahkan pilih mode:\n1. Auto\n2. Manual\n3. Kembali\n= ");
                switch (menu) {
                    case 1:
                    // MINTA SYARAT
                    System.out.printf("%s\n", "=".repeat(50));
                    System.out.println("Masukkan semua syarat yang harus dipenuhi : ");
                    new Pengalaman().prosesKehidupan(); // cekout exp, gaji dulu, organisasi
                    exp = (Pengalaman.getExp());
                    new Pendidikan().prosesKehidupan(); // cekout edu
                    edu = Pendidikan.getEdu();
                    new Projek().prosesKehidupan(); // cekout project
                    project = (int) Projek.getProject();
                    //SELEKSI
                    int count1 = 1;
                    int jumlahAwal = daftarKaryawan.size(); //10
                    ArrayList<Pelamar> simpan = new ArrayList<>();
                    for (Pelamar i : daftarPelamar){
                        if (i.getExp() == exp) {
                            if (i.getEdu().equals(edu)) {
                                if (i.getProject() >= project) {
                                    System.out.printf("%s\n", "=".repeat(50));
                                    System.out.println("Karyawan ini sesuai dengan kriteria yang Anda cari");
                                    System.out.println("Pelamar ke-" + count1 + " :");
                                    count1++;
                                    System.out.println("Nomor Induk : " + i.getNomorInduk());
                                    System.out.println("Nama : " + i.getName());
                                    System.out.println("Umur : " + i.getUmur());
                                    String jabatan = Main.inputUserKosong("Masukkan posisi jabatan: ");
                                    System.out.println("Gaji sebelumnya : " + i.getGajiDulu());
                                    System.out.println(i.getBerkeluarga());
                                    double gaji = Main.inputUserAngka("Masukkan jumlah gaji: ");
                                    daftarKaryawan.add(new Karyawan(i.getNomorInduk(), i.getName(), i.getUmur(), jabatan, gaji));
                                }else{
                                    simpan.add(i);
                                }
                            }else{
                                simpan.add(i);
                            }
                        }else{
                            simpan.add(i);
                        }
                    }
                    daftarPelamar.clear();
                    for(Pelamar i : simpan){
                        daftarPelamar.add(i);
                    }
                    int jumlahAkhir = daftarKaryawan.size(); //10
                    if (jumlahAwal == jumlahAkhir) {
                        System.out.printf("%s\n", "=".repeat(50));
                        System.out.println("Tidak ada karyawan yang sesuai dengan kriteria");
                    }
                        break outerloop;


                    case 2:
                    int count2 = 1;
                    ArrayList<Pelamar> titip = new ArrayList<>();
                    for(Pelamar i : daftarPelamar){
                        System.out.printf("%s\n", "=".repeat(50));
                        System.out.println("Pelamar ke-" + count2 + " :");
                        count2++;
                        System.out.println("Nomor Induk : " + i.getNomorInduk());
                        System.out.println("Nama : " + i.getName());
                        System.out.println("Umur : " + i.getUmur());
                        String pengalaman = "";
                        switch (i.getExp()) {
                            case 1:
                            pengalaman = "Freelancer";
                                break;
                            case 2:
                            pengalaman = "Magang";
                                break;
                            case 3:
                            pengalaman = "Pekerja tetap";
                                break;
                            case 4:
                            pengalaman = i.getOrganisasi();
                                break;
                            case 5:
                            pengalaman = "Tidak ada";
                                break;
                            default:
                                break;
                        }
                        System.out.println("Pengalaman : " + pengalaman);
                        System.out.println("Pendidikan : " + i.getEdu());
                        String projek = "";
                        switch (i.getProject()) {
                            case 1:
                                projek = "Minimal 4";
                                break;
                            case 2:
                                projek = "Minimal 8";
                                break;
                            case 3:
                                projek = "Minimal 12";
                                break;
                            case 4:
                                projek = "Lebih dari 15";
                                break;
                            default:
                                break;
                        }
                        System.out.println("Project : " + projek);
                        System.out.printf("%s\n", "-".repeat(50));
                        String confirm = Main.inputUserKosong("Terima/Tolak : ").toLowerCase();
                        if (confirm.equals("terima")) {
                            String jabatan = Main.inputUserKosong("Masukkan posisi jabatan: ");
                            System.out.println("Gaji sebelumnya : " + i.getGajiDulu());
                            System.out.println(i.getBerkeluarga());
                            double gaji = Main.inputUserAngka("Masukkan jumlah gaji: ");
                            daftarKaryawan.add(new Karyawan(i.getNomorInduk(), i.getName(), i.getUmur(), jabatan, gaji));
                        }
                        else if (confirm.equals("tolak")) {
                            titip.add(i);
                        }
                        else{
                            System.out.printf("%s\n", "-".repeat(50));
                            System.out.println("Invalid Input");
                            AudioFile.Audio("wrong_input.wav");
                        }
                    }
                    daftarPelamar.clear();
                    for(Pelamar i : titip){
                        daftarPelamar.add(i);
                    }
                    
                        break outerloop;
                    case 3:
                        break outerloop;
                    default:
                        break;
                }
            }
        }
    }

    static void tampil(ArrayList<Pelamar> daftarPelamar, ArrayList<Karyawan> daftarKaryawan) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        if (daftarKaryawan.size() != 0 || daftarPelamar.size() != 0) {
            String nomorInduk = Main.inputUserKosong("Masukkan nomor induk: ");
            if (daftarKaryawan.size() != 0) {// karyawan ada
                for(Karyawan i : daftarKaryawan){
                    if (i.getNomorInduk().equals(nomorInduk)) {
                        System.out.printf("%s\n", "-".repeat(50));
                        System.out.println("Nomor Induk : " + i.getNomorInduk());
                        System.out.println("Nama : " + i.getNama());
                        System.out.println("Umur : " + i.getUmur());
                        System.out.println("Jabatan : " + i.getJabatan());
                        System.out.println("Gaji : " + i.getGaji());
                        System.out.printf("%s\n", "=".repeat(50));
                        System.out.println("Selamat, karyawan diterima!");
                        AudioFile.Audio("accept.wav");
                        System.out.printf("%s\n", "=".repeat(50));
                    }
                }
            }
            else if (daftarPelamar.size() != 0) {
                boolean get = false;
                for (Pelamar j : daftarPelamar){
                    if (j.getNomorInduk().equals(nomorInduk)) {
                        System.out.printf("%s\n", "-".repeat(50));
                        System.out.println("Nomor Induk : " + j.getNomorInduk());
                        System.out.println("Nama : " + j.getName());
                        System.out.println("Umur : " + j.getUmur());
                        String pengalaman = "";
                        switch (j.getExp()) {
                            case 1:
                            pengalaman = "Freelancer";
                                break;
                            case 2:
                            pengalaman = "Magang";
                                break;
                            case 3:
                            pengalaman = "Pekerja tetap";
                                break;
                            case 4:
                            pengalaman = "Tidak ada";
                                break;
                            default:
                                break;
                        }
                        System.out.println("Pengalaman : " + pengalaman);
                        System.out.println("Pendidikan : " + j.getEdu());
                        String projek = "";
                        switch (j.getProject()) {
                            case 1:
                                projek = "Minimal 4";
                                break;
                            case 2:
                                projek = "Minimal 8";
                                break;
                            case 3:
                                projek = "Minimal 12";
                                break;
                            case 4:
                                projek = "Lebih dari 15";
                                break;
                            default:
                                break;
                        }
                        System.out.println("Project : " + projek);
                        System.out.printf("%s\n", "=".repeat(50));
                        System.out.println("Karyawan tidak memenuhi syarat");
                        AudioFile.Audio("reject.wav");
                        System.out.printf("%s\n", "=".repeat(50));
                        get = true;
                        break;
                    }
                    else{
                        get = false;
                    }
                }
                if (get == false) {
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Nomor induk tidak ditemukan");
                    AudioFile.Audio("wrong_input.wav");
                }
            }
        }
        else{
            System.out.printf("%s\n", "-".repeat(50));
            System.out.println("Mohon pilih opsi tambah data terlebih dahulu");                
            AudioFile.Audio("wrong_input.wav");
        }
    }
}
