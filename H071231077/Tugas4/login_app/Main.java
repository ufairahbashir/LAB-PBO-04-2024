package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

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
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
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
            default:
                // Mengulang Pemanggilan Menu Utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.next();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }

        }
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);
            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");

                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        }
    }
    

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");
        String username;
      

        // Menginput username dan password
        do {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();
        
            if (username.isEmpty()) {
                System.out.println("Gaboleh kosong");   
                 
            }else if (username.matches(".*\\d.*")){
                System.out.println("No angka");
            
            }else
                for (User user : listUser )   {
                    if (user.getUsername().equals(username));
                    System.out.println("Username sudah digunakan");
                    break;
                }
            {

                break;
            }
        } while (true);

        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();

        if (password.length() < 8) {
            System.out.println("Minimal 8 karakter");
            runApp();
            return;

        }



        User pengguna = new User(username, password);

        Profile profile = new Profile();

        // Menginput Data Profile
        String fullName;

        do {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (fullName.isEmpty()) {
                System.out.println("Gaboleh kosong");    
            }else if (fullName.matches(".*\\d.*")){
                System.out.println("No angka");
            }else{

                break;
            }
        } while (true);

        System.out.println("Umur");
        System.out.print("> ");
        int age = 0;
        boolean validAgeInput = false;


        while (!validAgeInput) {
            if (!sc.hasNextLine()) {
                System.out.println("Masukkan input");
                sc.next();
                continue;
            }
            String kratos = sc.nextLine();
            if (kratos.isEmpty()){
                System.out.println("Jangan kosong");
            }else if (!kratos.matches("\\d+")){
                System.out.println("Harus angka");
            }else{
                age = Integer.parseInt(kratos);
                validAgeInput = true;

            
            }
        }

        String hobby;

        do {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (hobby.isEmpty()) {
                System.out.println("Gaboleh kosong");    
            }else if (hobby.matches(".*\\d.*")){
                System.out.println("No angka");
            }else{

                break;
            }
        } while (true);

        

        profile.setFullname(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickname(StringUtils.nickName(fullName));

        // Menambahkan user yang dibuat ke list user
        listUser.add(pengguna);
        listUserProfile.add(profile);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
        
    }

    private static void showDetailUser(Profile profile) {

        System.out.println("SELAMAT DATANG!!!!!!!!!!!");
        System.out.println("==================================");
        System.out.println("Nama lengkap : " + profile.getFullname());
        System.out.println("Age : " + profile.getAge());
        System.out.println("Hobby : " + profile.getHobby());
        System.out.println("Nickname : " + profile.getNickname());
        System.out.println("==================================");
    }
}
