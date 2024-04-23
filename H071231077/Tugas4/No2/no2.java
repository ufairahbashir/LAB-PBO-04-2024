import java.io.IOException;
import java.util.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Audio.AudioFile;


class Product {
    String name;
    String category;
    double price;
    String code;
    int stock;

    public Product(String name, String category, double price, String code, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.code = code;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void buy(int quantity) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        if (quantity <= stock) {
            stock -= quantity;
            System.out.println("Berhasil membeli" + quantity + " " + name + "1");
            System.out.println("Resi | " + code + " | " +name + " | Rp " + price);
            AudioFile.AudioSorted("Audio\\Reyy.wav");

        } else {
            System.out.println("Stok tidak cukup. stok saaat ini " + stock);
        }
    }



}

class Store {
    private HashMap<String, ArrayList<Product>> categories;
    private Scanner scanner;

    public Store() {
        categories = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void buyProduct() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        System.out.println("Pilih kategori:");
        displayCategories();
        String category = scanner.nextLine();
        if (!categories.containsKey(category)) {
            System.out.println("Kategori tidak ditemukan.");
            return;
        }
        System.out.println("Pilih produk:");
        ArrayList<Product> products = categories.get(category);
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " - Rp" + products.get(i).getPrice());
        }
        int productIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (productIndex >= 0 && productIndex < products.size()) {
            Product product = products.get(productIndex);
            System.out.println("Jumlah yang ingin di beli: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            product.buy(quantity);
        } else {
            System.out.println("Pilihan produk tidak valid.");
        }
    }

    public void addCategory() {
        System.out.println("Input nama kategori:");
        String categoryName = scanner.nextLine();
        categories.put(categoryName, new ArrayList<>());
        System.out.println("Kategori tersimpan!!");
    }

    public void addProduct() {
        System.out.println("Input nama barang:");
        String productName = scanner.nextLine();
        System.out.println("Input kategori barang:");
        String productCategory = scanner.nextLine();

        // Check if the category exists
        if (!categories.containsKey(productCategory)) {
            System.out.println("Kategori tidak tersedia. Pilih dari kategori yang ada:");
            displayCategories(); 
            productCategory = scanner.nextLine();
            if (!categories.containsKey(productCategory)) {
                System.out.println("Input tidak valid. Operasi dibatalkan.");
                return;
            }
        }

        System.out.println("Input harga barang:");
        double productPrice = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Input kode produk:");
        String productCode = scanner.nextLine();
        System.out.println("Input stok produk:");
        int productStock = scanner.nextInt();
        scanner.nextLine(); 

        Product newProduct = new Product(productName, productCategory, productPrice, productCode, productStock);
        categories.get(productCategory).add(newProduct);
        System.out.println("Produk tersimpan!!");

    }
    public void displayCategories() {
        if (categories.isEmpty()) {
            System.out.println("Belum ada kategori yang tersedia.");
        } else {
            for (String category : categories.keySet()) {
                System.out.println(category);
            }
        }
    }

    public void displayProducts() {
        if (categories.isEmpty()) {
            System.out.println("Belum ada kategori.");
        } else {
            for (String category : categories.keySet()) {
                System.out.println(category + ":");
                ArrayList<Product> products = categories.get(category);
                if (products.isEmpty()) {
                    System.out.println("\tBelum ada");
                } else {
                    for (Product product : products) {
                        System.out.println("\t" + product.getName() + " - Rp" + product.getPrice() + " - Stok: "
                                + product.getStock());
                    }
                }
                System.out.println("================");
            }
        }
    }

    public void removeCategory() {
        if (categories.isEmpty()) {
            System.out.println("Tidak ada kategori yang bisa dihapus.");
            return;
        }
        System.out.println("Input nama kategori yang ingin dihapus:");
        String categoryName = scanner.nextLine();
        if (categories.containsKey(categoryName) && !categories.get(categoryName).isEmpty()) {
            categories.remove(categoryName);
            System.out.println("Kategori dihapus!!");
        } else {
            System.out.println("Kategori tidak ditemukan atau sudah kosong.");
        }
    }

    public void removeProduct() {
        System.out.println("Input nama kategori dari produk yang ingin dihapus:");
        String category = scanner.nextLine();
        if (!categories.containsKey(category) || categories.get(category).isEmpty()) {
            System.out.println("Tidak ada produk yang bisa dihapus dalam kategori ini.");
            return;
        }
        System.out.println("Input nama produk yang ingin dihapus:");
        String productName = scanner.nextLine();
        ArrayList<Product> products = categories.get(category);
        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equals(productName)) {
                products.remove(i);
                System.out.println("Produk dihapus!!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Produk tidak ditemukan.");
        }
    }
}



public class no2 {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        int role;
        int choice;

        while (true) { // Loop utama untuk pemilihan peran
            System.out.println("Selamat datang di Pbo-04 store:");
            System.out.println("1. Pembeli");
            System.out.println("2. Penjual");
            System.out.println("3. Keluar");
            System.out.print("Pilih peran: ");
            String roleInput = scanner.nextLine();

            // Handle empty input for role selection
            if (roleInput.trim().isEmpty()) {
                System.out.println("Input tidak valid. Silakan pilih peran yang sesuai.");
                continue;
            }

            try {
                role = Integer.parseInt(roleInput);
                if (role == 3) { // Jika pilihan adalah 'Keluar'
                    System.out.println("Terima kasih telah menggunakan Pbo-04 store.");
                    break; // Keluar dari loop dan program
                }
                if (role != 1 && role != 2) {
                    System.out.println("Peran tidak valid. Silakan pilih peran yang sesuai.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan nomor peran.");
                continue;
            }

            // Logika untuk Pembeli
            if (role == 1) {
                do {
                    System.out.println("Menu Pembeli:");
                    System.out.println("1. Daftar kategori dan barangnya");
                    System.out.println("2. Beli barang");
                    System.out.println("3. Kembali");
                    System.out.print("Pilih menu: ");
                    String input = scanner.nextLine();

                    if (input.trim().isEmpty()) {
                        System.out.println("Input tidak valid. Silakan pilih menu yang sesuai.");
                        continue;
                    }

                    try {
                        choice = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid. Silakan masukkan nomor menu.");
                        continue;
                    }

                    if (choice == 3) { // Jika pilihan adalah 'Kembali'
                        break; // Kembali ke pemilihan peran
                    }


                // Logika switch untuk Pembeli
                switch (choice) {
                    case 1:
                        store.displayProducts();
                        break;
                    case 2:
                        store.buyProduct();
                        break;
                    case 3:
                        System.out.println("Terima kasih telah berkunjung.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (true);
        }

        // Logika untuk Penjual
        else if (role == 2) {
            do {
                System.out.println("Menu Penjual:");
                System.out.println("1. Daftar kategori dan barangnya");
                System.out.println("2. Input barang baru");
                System.out.println("3. Input kategori baru");
                System.out.println("4. Hapus kategori");
                System.out.println("5. Hapus barang");
                System.out.println("6. Kembali");
                System.out.print("Pilih menu: ");
                String input = scanner.nextLine();

                if (input.trim().isEmpty()) {
                    System.out.println("Input tidak valid. Silakan pilih menu yang sesuai.");
                    continue;
                }

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Silakan masukkan nomor menu.");
                    continue;
                }

                if (choice == 6) { // Jika pilihan adalah 'Kembali'
                    break; // Kembali ke pemilihan peran
                }

                // Logika switch untuk Penjual
                switch (choice) {
                    case 1:
                        store.displayProducts();
                        break;
                    case 2:
                        store.addProduct();
                        break;
                    case 3:
                        store.addCategory();
                        break;
                    case 4:
                        store.removeCategory();
                        break;
                    case 5:
                        store.removeProduct();
                        break;
                    case 6:
                        System.out.println("Terima kasih telah menggunakan Pbo-04 store.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (true);
        }

        
      }
      scanner.close();
    }
}





