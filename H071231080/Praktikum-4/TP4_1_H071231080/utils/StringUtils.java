package TP4_1_H071231080.utils;

public class StringUtils {
    public static String getNickname(String fullName) {
        // Pisahkan fullName menjadi array kata-kata
        String[] parts = fullName.split(" ");
        
        // Jika fullName hanya terdiri dari satu kata, kembalikan itu sebagai nickName
        if (parts.length == 1) {
            return fullName;
        } else {
            // Jika fullName terdiri dari lebih dari satu kata, kembalikan kata kedua sebagai nickName
            return parts[1]; //mengampil inndeks 1 darii parts
        }
    }
}