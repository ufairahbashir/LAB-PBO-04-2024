package TP4_1_H071231080;

import java.util.ArrayList;
import java.util.Scanner;
import TP4_1_H071231080.models.Profile;
import TP4_1_H071231080.models.User;
import TP4_1_H071231080.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        // Menu Utama
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Mmebuka halaman login
                showLoginMenu();
                break;
            case 2:
                // Membuka halaman Regist
                showRegisterMenu();
                break;
            default:
                // Mengulang pemanggilan menu utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.next();

        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1; // perulangan utk username yg sdh d input/sdh di register

        for (int i = 0; i < listUser.size(); i++) {
            // TODO Mengecek user index i memiliki username yang sama
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }
        // saat userindex tdk sama dgn -1/userindex tdk ditemukan
        if (userIndex != -1) { // jika ditemukan usernamenya
            // Menginput Paaworsd
            System.out.println("Password");
            System.out.print("> ");

            boolean isPasswordMatch;
            do {
                String password = sc.next();

                // TODO menecek apakah password dari user login berdasarkan username
                // sama dgn pass yg diinput sblumnya dan disimpan di variabel isPasswordMatch
                isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);// ditambahkan
                if (isPasswordMatch) {
                    System.out.println("Berhasil Login");

                    // TODO panggil method showDetailUser dan
                    // kirimkan data prodile user yg login
                    showDetailUser(listUserProfile.get(userIndex));
                    System.exit(0);
                    // jika passnya sama maka berhasil login
                } else {
                    // jika salah akan menampilkan salah
                    System.out.println("Password Salah");
                }
            } while (!isPasswordMatch);
        } else {
            System.out.println("Username tidak di temukan");
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        String username, password;
        do {
            System.out.println("Username ");
            System.out.print("> ");
            username = sc.nextLine().trim(); //menghapus Spasi
        } while (username.isEmpty()); //memeriksa kosong atau ada
    
        do {
            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            password = sc.nextLine().trim();
        } while (password.isEmpty() || password.length() < 8);
    


        // mengecek jika username sudah ada
        boolean usernameExists;
        do {
            usernameExists = false;
            for (User existingUser : listUser) {
                if (existingUser.getUsername().equals(username)) {
                    usernameExists = true;
                    System.out.println("Username sudah digunakan, silakan masukkan username lain");
                    System.out.print("> ");
                    username = sc.nextLine().trim();
                    break;
                }
            }
        } while (usernameExists);
    
        // Menginput Data Profile
        String fullName;
        int age;
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        fullName = sc.nextLine();
        System.out.println("Umur");
        do {
            System.out.print("> ");
            while (!sc.hasNextInt()) {
                System.out.println("Umur harus berupa angka");
                System.out.print("> ");
                sc.next();
            }
            age = sc.nextInt();
            sc.nextLine(); 
        } while (age <= 0);
        

        String hobby;
        do {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine().strip();
        } while (!isHobbyValid(hobby));


    
        Profile profile = new Profile(fullName, age, hobby);
        profile.setNickname(StringUtils.getNickname(fullName));
    
        // Menambahkan user yang dibuat ke list user
        listUser.add(new User(username, password));
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();

    }
    private static boolean isHobbyValid(String hobby) {
        char[] c = hobby.toCharArray();
        for (int i = 0; i < hobby.length(); i++) {
            // Cek apakah hobi hanya mengandung huruf dan spasi.
            if (Character.isAlphabetic(c[i]) || ((c[i] == ' ' || c[i] == ',') && i > 0))
                continue;
            else {
                System.out.println("Hobi hanya boleh mengandung huruf dan spasi.\n");
                return false;
            }
        }

        return true;
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Selamat Datang !!");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap    : " + profile.getFullName());
        System.out.println("Nama Panggilan  : " + profile.getNickname());
        System.out.println("Umur            : " + profile.getAge());
        System.out.println("Hobby           : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}