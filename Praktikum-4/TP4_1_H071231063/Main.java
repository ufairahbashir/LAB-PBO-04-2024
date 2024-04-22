package TP4_1_H071231063;
import java.util.ArrayList;
import java.util.Scanner;
import TP4_1_H071231063.models.Profile;
import TP4_1_H071231063.models.User;
import TP4_1_H071231063.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        try {
            System.out.println("-------------------------");
            System.out.println("Aplikasi Login Sederhana");
            System.out.println("-------------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("> ");

            int selectMenu = sc.nextInt();
            sc.nextLine();

            switch (selectMenu) {
                case 1:
                    showLoginMenu();
                    break;
                case 2:
                    showRegisterMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    return; // Keluar dari method runApp()
                default:
                    System.out.println("Menu tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Pastikan Anda memasukkan nomor menu.");
            sc.nextLine(); // Membersihkan buffer
        }
        // Panggil runApp() lagi untuk menampilkan menu lagi
        runApp();
    }

    private static void showLoginMenu() {
        try {
            System.out.println("-------------------------");
            System.out.println("Login");
            System.out.println("Masukkan Username");
            System.out.print("> ");

            String username = sc.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
                showLoginMenu();
                return;
            }

            int userIndex = -1;
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getUsername().equals(username)) {
                    userIndex = i;
                    break;
                }
            }

            if (userIndex == -1) {
                System.out.println("Username tidak ditemukan.");
                showLoginMenu();
                return;
            }

            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
            } else {
                System.out.println("Password Salah");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            sc.nextLine(); // Membersihkan buffer
            showLoginMenu(); // Meminta masukan ulang
        }
    }

    private static void showRegisterMenu() {
        try {
            System.out.println("-------------------------");
            System.out.println("REGISTER");

            System.out.println("Username");
            System.out.print("> ");
            String username = sc.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
                showRegisterMenu();
                return;
            }
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username sudah digunakan.");
                    showRegisterMenu();
                    return;
                }
            }

            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            String password = sc.nextLine();
            if (password.length() < 8) {
                System.out.println("Password harus memiliki minimal 8 karakter.");
                showRegisterMenu();
                return;
            }

            User user = new User(username, password);
            Profile profile = new Profile("", "", 0, "");

            System.out.println("Nama Lengkap");
            System.out.print("> ");
            String fullName = sc.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
                showRegisterMenu();
                return;
            }

            System.out.println("Umur");
            System.out.print("> ");
            int age=0;
            try {
                String umur= sc.nextLine();
                if (!umur.isEmpty()) {
                    age= Integer.parseInt(umur);
                }else{
                    System.out.println("Inputan tidak boleh kosong");
                    runApp();
                }
            } catch (Exception e) {
                System.out.print("Input berupa angka\n> ");
            }

            System.out.println("Hobby");
            System.out.print("> ");
            String hobby = sc.nextLine();
            
            while (hobby.isEmpty()) {
                System.out.print("Inputan tidak boleh kosong\n> ");
                hobby= sc.nextLine();
            }

            profile.setFullName(fullName);
            profile.setAge(age);
            profile.setHobby(hobby);
            profile.setNickName(StringUtils.generateNickName(fullName));

            listUser.add(user);
            listUserProfile.add(profile);
            System.out.println("-------------------------");
            System.out.println("Berhasil Membuat User Baru!!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            sc.nextLine(); // Membersihkan buffer
            showRegisterMenu(); // Meminta masukan ulang
        }
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("SELAMAT DATANG ! !");
        System.out.println("-------------------------");
        System.out.println("Nama lengkap   : " + profile.getFullName());
        System.out.println("Nama panggilan : " + profile.getNickName());
        System.out.println("Umur           : " + profile.getAge());
        System.out.println("Hobby          : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}