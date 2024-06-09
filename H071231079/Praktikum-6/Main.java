import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println("           DOGS PART");
        System.out.println("===============================");

        // Input untuk posisi awal dogs
        int pitbullPosition = inputInt(scanner, "Masukkan posisi awal Pitbull           : ");
        int pitbullLength = inputInt(scanner, "Masukkan panjang rata2 Pitbull         : ");
        int siberianHuskyPosition = inputInt(scanner, "Masukkan posisi awal Siberian Husky    : ");
        int siberianHuskyLength = inputInt(scanner, "Masukkan panjang rata2 Siberian Husky  : ");
        int bulldogPosition = inputInt(scanner, "Masukkan posisi awal Bulldog           : ");
        int bulldogLength = inputInt(scanner, "Masukkan panjang rata2 Bulldog         : ");
        int germanShepherdPosition = inputInt(scanner, "Masukkan posisi awal German Shepherd   : ");
        int germanShepherdLength = inputInt(scanner, "Masukkan panjang rata2 German Shephard : ");
        
        // Membuat objek dogs
        Pitbull pitbull = new Pitbull(pitbullPosition, pitbullLength);
        SiberianHusky siberianHusky = new SiberianHusky(siberianHuskyPosition, siberianHuskyLength);
        Bulldog bulldog = new Bulldog(bulldogPosition, bulldogLength);
        GermanShepherd germanShepherd = new GermanShepherd(germanShepherdPosition, germanShepherdLength);

        // Move dan describe dogs
        System.out.println("===========INFO DOGS===========\n");
        System.out.println("============PITBULL============");
        pitbull.move();
        pitbull.describe();

        System.out.println("\n=========SIBERIAN HUSKY========");
        siberianHusky.move();
        siberianHusky.describe();

        System.out.println("\n============BULLDOG============");
        bulldog.move();
        bulldog.describe();

        System.out.println("\n========GERMAN SHEPHERD========");
        germanShepherd.move();
        germanShepherd.describe();

        System.out.println("\n===============================");
        System.out.println("        SMARTPHONE PART");
        System.out.println("===============================");


        // Input untuk smartphone
        int smartphonePrice = inputInt(scanner, "Masukkan harga smartphone : ");

        String smartphoneBrand = inputString(scanner, "Masukkan merek smartphone : ");

        System.out.println("\n========SMARTPHONE PART========");

        // Membuat objek smartphone
        Smartphone smartphone = new Smartphone(smartphonePrice, smartphoneBrand);

        // jalankan method untuk Smartphone
        smartphone.move();
        smartphone.startPhone();
        smartphone.answerCall();
        smartphone.stopPhone();

        System.out.println("\n===============================");
        System.out.println("           CARS PART");
        System.out.println("===============================");

        // Input untuk mobil
        int carForwardGear = inputInt(scanner, "Masukkan jumlah gigi maju mobil   : ");

        String carColor = inputString(scanner, "Masukkan warna mobil              : ");
        
        int carMaxSpeed = inputInt(scanner, "Masukkan kecepatan maksimum mobil : ");

        System.out.println("\n===========INFO CARS===========");

        // Membuat objek mobil
        Car car = new Car(carForwardGear, carColor, carMaxSpeed);

        // Jalankan Method untuk car
        car.startEngine();
        car.move();
        car.stopEngine();

        scanner.close();
    }

    // Input dan validasi inputan bertipe data integer
    public static int inputInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
                    continue;
                }
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Nilai harus lebih dari 0.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
            }
        }
    }

    // Input dan validasi inputan bertipe data String
    public static String inputString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silahkan coba lagi.");
            } else {
                return input;
            }
        }
    }
}    