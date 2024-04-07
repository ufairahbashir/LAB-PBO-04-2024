import java.util.Scanner;

class Person {
    private boolean isMale;
    private int age;
    private String name, gender;

    void setName(Scanner sc) { // Method untuk menentukan nama
        while (true) {
            boolean isValid = true;
            String CEWname = "";

            System.out.print("Masukkan nama : ");
            name = sc.nextLine().strip();

            if (name.isEmpty()) { // Cek apakah nama kosong
                System.out.println("Nama tidak boleh kosong.\n"); continue;
            }
            
            for (int i = 0; i < name.length(); i++) {
                char[] c = name.toCharArray();

                // Cek apakah huruf ke-i merupakan bagian dari kata baru. Jika ya, maka diubah menjadi kapital
                if (i == 0 || (i > 1 && name.charAt(i-1) == ' ')) { CEWname += name.substring(i, i+1).toUpperCase(); }
                else { CEWname += name.substring(i, i+1).toLowerCase(); } // Jika tidak, maka diubah menjadi huruf kecil

                if (Character.isAlphabetic(c[i]) || c[i] == '.' || c[i] == ' ') { continue; } 
                else { // Cek apakah nama hanya mengandung huruf dan titik
                    System.out.println("Nama hanya boleh mengandung huruf dan titik.\n"); isValid = false;
                    break;
                }
            }
            
            if (!isValid) { continue; } // Jika nama tidak valid, maka ulangi inputan
            else { name = CEWname; break; }// Ubah nama sebelumnya menjadi nama baru (menggunakan format CEW)
        }
    }

    String getName() { // Method untuk mendapatkan nama
        return name;
    }

    int setAge(Scanner sc) { // Method untuk menentukan umur
        while (true) {
            try {
                System.out.print("Masukkan umur : ");
                String tester = sc.nextLine().strip();

                if (tester.isEmpty()) { System.out.println("Umur tidak boleh kosong.\n"); continue; }
                else { age = Integer.parseInt(tester); } // Cek apakah inputan merupakan integer

                if (age < 1) { System.out.println("Umur harus lebih dari 0 (nol).\n"); }
                else { break; }
            } catch (NumberFormatException e) {
                System.out.println("Umur harus integer.\n"); // Jika inputan bukan integer, maka ulangi inputan
            }
        }
        return age;
    }
    
    int getAge() { // Method untuk mendapatkan umur
        return age;
    }
    
    String setGender(Scanner sc) { // Method untuk menentukan gender
        while (true) {
            System.out.printf("Apakah Anda pria (y/t)? ");
            String ans = sc.nextLine().strip();

            if (ans.isBlank()) { System.out.println("Inputan tidak boleh kosong.\n");} 
            else if (ans.charAt(0) == 'y') { isMale = true; break; } 
            else if(ans.charAt(0) == 't') { isMale = false; break; }
            else { System.out.println("Hanya menerima dua inputan, yaitu 'y' atau 't'.\n"); }
        }
        return gender = isMale ? "Pria" : "Wanita";
    }

    String getGender() { // Method untuk mendapatkan gender
        return gender;
    }

}

public class TP2_1_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Person Sappo = new Person();
            Sappo.setName(sc);
            Sappo.setAge(sc);
            Sappo.setGender(sc);
            System.out.printf("========================================" +
            "\nNama          : %s\nUmur          : %s\nJenis Kelamin : %s\n",
            Sappo.getName(), Sappo.getAge(), Sappo.getGender() + 
            "\n========================================");
            
            Person Fatimah = new Person();
            Fatimah.setName(sc);
            Fatimah.setAge(sc);
            Fatimah.setGender(sc);
            System.out.printf("========================================" +
            "\nNama          : %s\nUmur          : %s\nJenis Kelamin : %s\n",
            Fatimah.getName(), Fatimah.getAge(), Fatimah.getGender() + 
            "\n========================================");
        }
    }
}