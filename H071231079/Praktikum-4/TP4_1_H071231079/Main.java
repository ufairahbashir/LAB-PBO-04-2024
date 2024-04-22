package TP4_1_H071231079;

import java.util.ArrayList;
import java.util.Scanner;
import TP4_1_H071231079.models.Profile;
import TP4_1_H071231079.models.User;
import TP4_1_H071231079.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    // Mothod 1
    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        try {
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
                default:
                    // Mengulang Pemanggilan Menu Utama
                    System.out.println("Input hanya angka 1 & 2.");
                    runApp();    
            }
        } catch (Exception e) { //untuk inputan diluar integer
            System.out.println("Inputan tidak valid. Harap masukkan angka.");
            sc.nextLine();
        } finally {
            runApp();
        }
    }

    // Method 2
    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.next();
        int userIndex = -1; 
        for (int i = 0; i < listUser.size(); i++) { 
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) { //username ditemukan
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();
            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah");
            }
        } else {
            System.out.println("User tidak ditemukan");
            runApp();
        }
    }

    // Method 3
    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");
    
        // Input for username
        String username;
        while (true) {
            System.out.println("Username ");
            System.out.print("> ");
            username = sc.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong. Silakan coba lagi.");
            } else {
                boolean usernameExists = false;
                for (User user : listUser) {
                    if (user.getUsername().equals(username)) {
                        usernameExists = true;
                        break;
                    }
                }
                if (usernameExists) {
                    System.out.println("Username sudah digunakan. Silakan gunakan username lain.");
                } else {
                    break; // keluar dari loop jika username valid dan belum digunakan
                }
            }
        }
    
        // Input for password
        String password;
        while (true) {
            System.out.println("Password (minimal 8 karakter, huruf besar, huruf kecil, dan angka) ");
            System.out.print("> ");
            password = sc.nextLine();
            if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong. Silakan coba lagi.");
            } else if (password.length() < 8) { // Pass lebih kecil dari 8 karakter
                System.out.println("Password harus memiliki minimal 8 karakter. Silakan coba lagi.");
            } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                System.out.println("Password harus mengandung setidaknya satu huruf kecil, satu huruf besar, dan satu angka. Silakan coba lagi.");
            } else {
                break;
            }
        }
        
        // Detail tambahan spt nama lengkap, umur, hobby, dan nama panggilan
        String fullName;
        while (true) {
            System.out.println("Nama Lengkap ");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Nama lengkap tidak boleh kosong. Silakan coba lagi.");
                continue;
            }
            // Memeriksa apakah input hanya terdiri dari huruf
            if (!fullName.matches("[a-zA-Z ]+")) {
                System.out.println("Nama lengkap hanya boleh mengandung huruf. Silakan coba lagi.");
            } else {
                break;
            }
        }
    
        int age;
        while (true) {
            System.out.println("Umur ");
            System.out.print("> ");
            String input = sc.nextLine().trim(); 
            // Memeriksa apakah input kosong
            if (input.isEmpty()) {
                System.out.println("Umur tidak boleh kosong. Silakan coba lagi.");
                continue; // Melanjutkan loop untuk meminta input kembali
            }
            // Memeriksa apakah input merupakan bilangan bulat
            if (input.matches("\\d+")) {
                age = Integer.parseInt(input);
                // Memeriksa apakah umur berada dalam rentang yang valid
                if (age <= 7 || age > 100) {
                    System.out.println("Umur harus di antara 7 dan 100 tahun. Silakan coba lagi.");
                    continue; 
                }
                break; // Keluar dari loop
            } else {
                System.out.println("Silakan masukkan angka untuk umur.");
            }
        }
        
        System.out.println("Hobby ");
        System.out.print("> ");
        String hobby;
        while (true) {
            hobby = sc.nextLine().trim(); 
            // Memeriksa apakah hobby tidak kosong
            if (hobby.isEmpty()) {
                System.out.println("Hobby tidak boleh kosong. Silakan coba lagi.");
                System.out.print("> ");
                continue; // Melanjutkan loop untuk meminta input kembali
            }
            // Memeriksa apakah hobby mengandung angka
            if (hobby.matches(".*\\d.*")) {
                System.out.println("Hobby tidak boleh mengandung angka. Silakan coba lagi.");
                System.out.print("> ");
            } else {
                break; // Keluar dari loop jika hobby valid
            }
        }
        
        // Membuat User dan Objek Profil
        User user = new User(username, password);
        String nickName = StringUtils.generateNickname(fullName);
        Profile profile = new Profile(fullName, age, hobby, nickName);
    
        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    } 

    //Method
    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap    : " + profile.getFullName());
        System.out.println("Nama Panggilan  : " + profile.getNickName());
        System.out.println("Umur            : " + profile.getAge());
        System.out.println("Hobby           : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}