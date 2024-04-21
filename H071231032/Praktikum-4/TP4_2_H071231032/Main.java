import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        runOrder();
    }
    
    private static void runOrder() {
        try (Scanner sc = new Scanner(System.in)) {
            OrderReceipt orderReceipt = new OrderReceipt();

            // Input nama kasir
            String cashierName;
            do {
                System.out.print("Masukkan nama kasir   : ");
                cashierName = sc.nextLine();
            } while (!isNameValid(cashierName));
            orderReceipt.setCashierName(CEWord(cashierName));

            // Input nama pemesan
            String customerName;
            do {
                System.out.print("Masukkan nama pemesan : ");
                customerName = sc.nextLine();
            } while (!isNameValid(customerName));
            orderReceipt.setCustomerName(CEWord(customerName));

            // Input jenis penyajian
            String testOpsi;
            do {
                System.out.print("Pilih jenis penyajian:\n1. Paket\n2. Ala Carte\n> ");
                testOpsi = sc.nextLine();
            } while (!isNumber(testOpsi));
            
            int opsi = Integer.parseInt(testOpsi);
            int opsiForId = opsi;
            
            if (opsi == 1) { // Paket
                while (true) {
                    try {
                        System.out.println("Pilih menu:\n1. Paket Skull Pedas\n2. Paket Semi-Skull\n3. Paket Skull Teknik\n> ");
                        opsi = sc.nextInt();
                        sc.nextLine();
                        
                        // Set orderName dan price
                        if (opsi == 1) {
                            orderReceipt.setOrderName("Paket Skull Pedas");
                            orderReceipt.setPrice(30_000);
                            break;
                        } else if (opsi == 2) {
                            orderReceipt.setOrderName("Paket Semi-Skull");
                            orderReceipt.setPrice(40_000);
                            break;
                        } else if (opsi == 3) {
                            orderReceipt.setOrderName("Paket Skull Teknik");
                            orderReceipt.setPrice(55_000);
                            break;
                        } else { System.out.println("Invalid opsi.\n"); }

                    } catch (NumberFormatException e) {
                        System.out.println("Input harus integer.\n");
                        sc.nextLine();
                    }
                }

                String test;
                do {
                    System.out.print("Masukkan jumlah pesanan: ");
                    test = sc.nextLine();
                } while (!isNumber(test));
                orderReceipt.setQuantity(Integer.parseInt(test));

            } else if (opsi == 2) { // Ala carte
                while (true) {
                    try {
                        System.out.println("Pilih menu:\n1. Ayam Skull\n2. Skull Soda\n3. Air Mineral\n> ");
                        opsi = sc.nextInt();
                        sc.nextLine();
                        
                        if (opsi == 1) {
                            orderReceipt.setOrderName("Ayam Skull");
                            orderReceipt.setPrice(25_000);
                            break;
                        } else if (opsi == 2) {
                            orderReceipt.setOrderName("Skull Soda");
                            orderReceipt.setPrice(15_000);
                            break;
                        } else if (opsi == 3) {
                            orderReceipt.setOrderName("Air Mineral");
                            orderReceipt.setPrice(7_000);
                            break;
                        } else { System.out.println("Invalid opsi.\n"); }

                    } catch (NumberFormatException e) {
                        System.out.println("Input harus integer.\n");
                        sc.nextLine();
                    }
                }

                String test;
                do {
                    System.out.print("Masukkan jumlah pesanan: ");
                    test = sc.nextLine();
                } while (!isNumber(test));
                orderReceipt.setQuantity(Integer.parseInt(test));

            } else {
                System.out.println("Invalid input.\n");
                runOrder();
            }

            // Set orderId
            orderReceipt.setOrderId(orderId(opsiForId));
            
            // Set waktu dan tanggal
            orderReceipt.setDateTime(dateTimeFormatted());

            // Show order receipt
            orderReceipt.showOrderReceipt();
            System.exit(0);
        }
    }
    
    private static String dateTimeFormatted() {
        String dateTimeFormat;
        
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("H:mm d MMM yyyy");
        dateTimeFormat = dateTime.format(formatDateTime);

        return dateTimeFormat;
    }

    private static boolean isNameValid(String name) {
        if (name.length() == 0){
            System.out.println("Nama tidak boleh kosong.\n");
            return false;
        }

        char[] c = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            // Cek apakah nama panjang hanya mengandung huruf, titik, dan spasi.
            if (Character.isAlphabetic(c[i]) || ((c[i] == '.' || c[i] == ' ') && i > 0)) continue;
            else {
                System.out.println("Nama hanya boleh mengandung huruf, titik dan spasi.\n");
                return false;
            }
        }
        
        return true;
    }
    
    private static String orderId(int jenis) {
        String orderId;

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyddMMHH");
        
        if (jenis == 1) orderId = "PK" + dateTime.format(formatDateTime); // Paket
        else orderId = "AC" + dateTime.format(formatDateTime); // Ala Carter

        return orderId;
    }

    private static String CEWord(String name) { // Capital Each Word
        String CEWord = "";

        for (int i = 0; i < name.length(); i++) {
            // Cek apakah huruf ke-i merupakan bagian dari kata baru. Jika ya, maka diubah menjadi kapital
            if (i == 0 || (i > 1 && name.charAt(i-1) == ' ')) { CEWord += name.substring(i, i+1).toUpperCase(); }
            else { CEWord += name.substring(i, i+1).toLowerCase(); } // Jika tidak, maka diubah menjadi huruf kecil
        }

        return CEWord;
    }

    private static boolean isNumber(String number) {
        if (number.isEmpty()) {
            System.out.println("Input tidak boleh kosong.\n");
            return false;
        }
        
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input harus integer.\n");
            return false;
        }
    }
}