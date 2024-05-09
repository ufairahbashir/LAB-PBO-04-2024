package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("=".repeat(40));
        System.out.println(" ".repeat(8) + "Aplikasi Login Sederhana");
        System.out.println("=".repeat(40));
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
                break;
            default:
                // Mengulang Pemanggilan Menu Utama
                System.out.println("Invalid opsi.\n");
                runApp();
                break;
        }
    }

    private static void showLoginMenu() {
        // Mengecek apakah listUser kosong
        if (listUser.isEmpty()) {
            System.out.println("Daftar pengguna masih kosong. Mohon lakukan registrasi terlebih dahulu.\n");
            runApp();
            System.exit(0);
        }
        // Halaman Login
        System.out.println("=".repeat(40));
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.nextLine().strip();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            /*
             * TODO
             * Buatlah sebuah perkondisian (IF) yang akan
             * Mengecek apakah user index ke i dari listUser memiliki username yang sama
             * dengan username yang diinput.
             * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
             * perulangan
             */
            if (listUser.get(i).getUsername().equals(username)) userIndex = i; break;
        }
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine().strip();
            
            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            boolean isPasswordMatch = false;
            if (listUser.get(userIndex).getPassword().equals(password)) isPasswordMatch = true;

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("=".repeat(40));
                System.out.println("Berhasil login!\n");
                /*
                 * TODO
                 * Panggil method showDetailUser dan kirimkan data Profile User yang login
                 */
                showDetailUser(listUser.get(userIndex).getProfile());
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password salah.\n");
            }
        } else System.out.println("Username tidak ditemukan.\n");
    }

    private static void showRegisterMenu() {
        System.out.println("=".repeat(40));
        System.out.println("REGISTER");

        // Menginput username dan password
        String username;
        do {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine().strip();
        } while (!isUsernameValid(username));

        String password;
        do {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine().strip();
        } while (!isPasswordValid(password));

        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User user = new User(username, password);
        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();

        // Menginput Data Profile
        String fullName;
        do {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine().strip();
        } while (!isNameValid(fullName));
        fullName = CEWname(fullName);

        String testAge;
        do {
            System.out.println("Umur");
            System.out.print("> ");
            testAge = sc.nextLine().strip();
        } while (!isAgeValid(testAge));

        String hobby;
        do {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine().strip();
        } while (!isHobbyValid(hobby));

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.setFullName(fullName);
        profile.setAge(Integer.parseInt(testAge));
        profile.setHobby(hobby);

        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        String nickName = StringUtils.getNickName(fullName);
        profile.setNickName(nickName);

        // Menambahkan user yang dibuat ke list user
        user.setProfile(profile);
        listUser.add(user);

        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);

        System.out.println("=".repeat(40));
        System.out.println("Berhasil membuat user baru!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /*
         * TODO *
         * Tampilkan semua data profile user yang login
         */
        System.out.println(
            "=".repeat(55) + "\n" +
            " ".repeat(20) + "SELAMAT DATANG" +
            "\n" + "=".repeat(55));
        System.out.println(
            "Nama Lengkap   : " + profile.getFullName() +
            "\nNama Panggilan : " + profile.getNickName() +
            "\nUmur           : " + profile.getAge() + " tahun" +
            "\nHobi           : " + profile.getHobby()
        );
    }

    private static boolean isUsernameValid(String username) {
//        if (!listUser.isEmpty()) {
            for (User user : listUser) {
                // Cek apakah nama pengguna telah ada sebelumnya
                if (user.getUsername().equals(username)) {
                    System.out.println("Username telah dipakai.\n");
                    return false;
                }
            }


        if (username.length() < 5 || username.length() > 15) {
            System.out.println("Username minimal 5 karakter dan maksimal 15 karakter.\n");
            return false;
        }

        char[] c = username.toCharArray();
        for (int i = 0; i < username.length(); i++) {
            // Cek apakah nama pengguna hanya mengandung huruf, angka, underscore, dan titik.
            if (Character.isAlphabetic(c[i]) || c[i] == '.' || c[i] == '_' || Character.isDigit(c[i])) continue;
            else {
                System.out.println("Username hanya boleh mengandung huruf, angka, garis bawah, dan titik.\n");
                return false;
            }
        }

        return true;
    }

    private static boolean isPasswordValid(String password) {
        if (password.length() < 8 || password.length() > 24) {
            System.out.println("Password minimal 8 karakter dan maksimal 24 karakter.\n");
            return false;
        }

        return true;
    }

    private static boolean isNameValid(String fullname) {
        if (fullname.length() == 0){
            System.out.println("Nama panjang tidak boleh kosong.\n");
            return false;
        }

        char[] c = fullname.toCharArray();
        for (int i = 0; i < fullname.length(); i++) {
            // Cek apakah nama panjang hanya mengandung huruf, titik, dan spasi.
            if (Character.isAlphabetic(c[i]) || ((c[i] == '.' || c[i] == ' ') && i > 0)) continue;
            else {
                System.out.println("Nama panjang hanya boleh mengandung huruf, titik dan spasi.\n");
                return false;
            }
        }
        
        return true;
    }

    private static String CEWname(String fullname) {
        String CEWname = "";

        for (int i = 0; i < fullname.length(); i++) {
            // Cek apakah huruf ke-i merupakan bagian dari kata baru. Jika ya, maka diubah menjadi kapital
            if (i == 0 || (i > 1 && fullname.charAt(i-1) == ' ')) { CEWname += fullname.substring(i, i+1).toUpperCase(); }
            else { CEWname += fullname.substring(i, i+1).toLowerCase(); } // Jika tidak, maka diubah menjadi huruf kecil
        }

        return CEWname;
    }

    private static boolean isAgeValid(String testAge) {
        if (testAge.isEmpty()) {
            System.out.println("Umur tidak boleh kosong.\n");
            return false;
        }
        
        char[] c = testAge.toCharArray();
        for (int i = 0; i < testAge.length(); i++) {
            // Cek apakah hobi hanya mengandung huruf dan spasi.
            if (Character.isDigit(c[i])) continue;
            else {
                System.out.println("Umur harus integer.\n");
                return false;
            }
        }

        if (Integer.parseInt(testAge) < 5) {
            System.out.println("Batas umur minimal adalah 5 tahun.\n");
            return false;
        }

        return true;
    }

    private static boolean isHobbyValid(String hobby) {
        if (hobby.length() < 3) {
            System.out.println("Hobi minimal 3 karakter.\n");
            return false;
        }

        char[] c = hobby.toCharArray();
        for (int i = 0; i < hobby.length(); i++) {
            // Cek apakah hobi hanya mengandung huruf dan spasi.
            if (Character.isAlphabetic(c[i]) || ((c[i] == ' ' || c[i] == ',') && i > 0)) continue;
            else {
                System.out.println("Hobi hanya boleh mengandung huruf dan spasi.\n");
                return false;
            }
        }
        
        return true;
    }
}
