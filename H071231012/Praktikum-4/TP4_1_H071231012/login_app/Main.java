package TP4_1_H071231012.login_app;

import java.util.ArrayList;
import java.util.Scanner;
import TP4_1_H071231012.models.Profile;
import TP4_1_H071231012.models.User;
import TP4_1_H071231012.utils.StringUtils;

public class Main {
    static ArrayList<User> listUser = new ArrayList<>();
    static ArrayList<Profile> listUserProfile = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
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
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
                break;
            default:
                System.out.println("Input hanya angka 1 dan 2");
                runApp();
        }
    }

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

        if (userIndex != -1) {
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            boolean isPaswordMatch = listUser.get(userIndex).checkPassword(password);

            if (isPaswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah");
            }
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();

        String password;
        do {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine();
            if(password.isEmpty()){
                System.out.println("inputan kosong. masukkan password");
            }else if(password.length() < 8){
                System.out.println("password minimal 8 karakter");
            }
        }while (password.length() < 8);

        User user = new User(username, password);
        Profile profile = new Profile();

        String fullName;
        do {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (fullName.isEmpty()){
                System.out.println("Inputan kosong. masukkan nama lengkap");
            }else if(fullName.matches("-?\\d+(\\.\\d+)?")){
                System.out.println("inputan harus berupa huruf ");
                runApp();
            }
        } while (fullName.matches("-?\\d+(\\.\\d+)?"));

        System.out.println("Umur");
        System.out.print("> ");
        int age = 0 ;
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

        String hobby = sc.nextLine();
        do{
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (hobby.isEmpty()){
                System.out.println("Inputan kosong. masukkan hobby");
            }else if(hobby.matches("-?\\d+(\\.\\d+)?")){
                System.out.println("inputan harus berupa huruf ");
                runApp();
            }
        } while (fullName.matches("-?\\d+(\\.\\d+)?"));

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        String nickName = StringUtils.getNickName(fullName);
        profile.setNickName(nickName);

        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap   : " + profile.getFullName());
        System.out.println("Nama Panggilan : " + profile.getNickName());
        System.out.println("Umur           : " + profile.getAge());
        System.out.println("Hobby          : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}