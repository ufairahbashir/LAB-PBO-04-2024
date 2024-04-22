package TP4_1_H071231079.utils;

public class StringUtils {
    public static String generateNickname(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length > 1) {
            return parts[1]; 
        }
        return fullName; 
    }
}
