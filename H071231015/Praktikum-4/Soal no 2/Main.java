import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


class inputUser{
    static double inputUserAngka(String tanya){
        Scanner input = new Scanner(System.in);
        double check;
        while (true) {
            System.out.print(tanya);
            String cek = input.nextLine().trim();
            if (cek.isEmpty()) {
                System.out.printf("%s\n", "-".repeat(50));
                System.out.println("Input is empty");
            }
            else{
                try {
                    check = Integer.parseInt(cek);
                    if (check <= 0) {
                        System.out.printf("%s\n", "-".repeat(50));
                        System.out.println("Invalid input");
                    }
                    else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("%s\n", "-".repeat(50));
                    System.out.println("Error caused by " + e);
                }
            }
        }
        return check;
    }

    static String inputUserKosong(String tanya){
        Scanner input = new Scanner(System.in);
        String ans;
        while (true) {
            System.err.print(tanya);
            ans = input.next();
            if (ans.trim().isEmpty()) {
                System.out.println("-------------------------");
                System.out.println("Input is empty");
            }
            else{
                break;
            }
        }
        return ans;
    }
}


class Car{
    private String brand;
    private int year;
    private double price;
    private String id;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public Car(){
    }

    public Car(String brand, int year, double price, String id) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.id = id;
    }

    static ArrayList<Car> cars = new ArrayList<>();

    static{
        cars.add(new Car("Porsche", 2013, 50000, "001"));
        cars.add(new Car("Audi", 2018, 70000, "002"));
        cars.add(new Car("Lamborghini", 2020, 65000, "003"));
        cars.add(new Car("Mercedes Benz", 2015, 40000, "004"));
    };


    static void info(){
        int count = 1;
        for (Car i : cars){
            System.out.println("Car " + count + " :");
            System.out.println("Brand : " + i.getBrand());
            System.out.println("Year of production : " + i.getYear());
            System.out.println("Price : $" + i.getPrice());
            System.out.println("ID : " + i.getId());
            count++;
            System.out.printf("%s\n","-".repeat(50));
        }
    }

    static void change(){
        String id = inputUser.inputUserKosong("Please enter id of the car : ");
        for (Car i : cars){
            if (i.getId().equals(id)) {
                while (true) {
                    System.out.println("What do you want to change ?\n1. Brand\n2. Year of production\n3. Price\n4. Back");
                    int menu = (int) inputUser.inputUserAngka("= ");
                    if (menu == 1) {
                        String brand = inputUser.inputUserKosong("Please enter new brand : ");
                        System.out.println("Brand changed from " + i.getBrand() + " to " + brand);
                        i.setBrand(brand);
                        break;
                        
                    }
                    else if (menu == 2) {
                        int year = (int) inputUser.inputUserAngka("= ");
                        System.out.println("Year of production changed from " + i.getYear() + " to " + year);
                        i.setYear(year);
                        break;
                    }
                    else if (menu == 3) {
                        double price = inputUser.inputUserAngka("= ");
                        System.out.println("Price changed from " + i.getPrice() + " to " + price);
                        i.setPrice(price);
                        break;
                    }
                    else if (menu == 4) {
                        break;
                    }
                    else{
                        System.out.printf("%s\n","-".repeat(50));
                        System.out.println("Please input 1/2/3/4");
                    }
                }
            }
            else if (i.getId().equals(cars.get(cars.size()-1).getId())) {
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("ID not found");
            }
        }
    }



    static void cekSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        int count = 1;
        while (true) {
            System.out.printf("%s\n","=".repeat(50));
            System.out.println("List of car avaliable :");
            for (Car i : cars){
                System.out.println(count + ". " + i.getBrand() + " with ID : " + i.getId());
                count++;
            }
            count =1;
            String id = inputUser.inputUserKosong("Please enter id of the car (type 'back' to main menu): ");
            if (id.equals("001")) {
                AudioFile.Audio("porsche-105500.wav");
            }
            else if (id.equals("002")) {
                AudioFile.Audio("audi-v8-acceleration-sound-6067.wav");
            }
            else if (id.equals("003")) {
                AudioFile.Audio("lambo-rev-87832.wav");
            }
            else if (id.equals("004")) {
                AudioFile.Audio("s63-amg-v8-engine-revs-41131.wav");
            }
            else if (id.toLowerCase().equals("back")) {
                break;
            }
            else{
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("ID not found");
            }
        }
        
    }

    static void buy(){
        String id = inputUser.inputUserKosong("Please enter id of the car : ");
        for (Car i : cars){
            if (i.getId().equals(id)) {
                while (true) {
                    System.out.println("Are you sure want to buy " + i.getBrand() + " ? (yes/no)");
                    String confirm = inputUser.inputUserKosong("= "); //YES = yes
                    if (confirm.toLowerCase().equals("yes")) {
                        inputUser.inputUserKosong("Please enter your credit card number : ");
                        System.out.println("Thank you! we love you");
                    
                        break;
                    }
                    else if (confirm.toLowerCase().equals("no")) {
                        break;
                    }
                    else{
                        System.out.println("Please enter yes/no");
                    }
                }
            }
            else if (i.getId().equals(cars.get(cars.size()-1).getId())) {
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("ID not found");
            }
        }
    }

    //METHOD OWNER
    static void owner(){
        while (true) {
            System.out.printf("%s\n","=".repeat(50));
            System.out.println("Hello Owner!\n1. List of cars\n2. Change data\n3. Back");
            int menu = (int) inputUser.inputUserAngka("= ");
            if (menu == 1 || menu == 2 || menu == 3) {
                System.out.printf("%s\n","=".repeat(50));
                if (menu == 1) {
                    info();
                }
                else if (menu == 2) {
                    change();
                }
                else if (menu == 3) {
                    break;
                }
            }
            else{
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("Please input 1/2/3");
            }
        }
    }

    //METHOD USER
    static void user() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.printf("%s\n","=".repeat(50));
            System.out.println("Hello! Please choose :\n1. List of cars\n2. Cek sound\n3. Buy\n4. Back");
            int menu = (int) inputUser.inputUserAngka("= ");
            if (menu == 1 || menu == 2 || menu == 3 || menu == 4) {
                System.out.printf("%s\n","-".repeat(50));
                if (menu == 1) {
                    info();
                }
                else if (menu == 2) {
                    cekSound();
                }
                else if (menu == 3) {
                    buy();
                }
                else if (menu == 4) {
                    break;
                }
            }
            else{
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("Please input 1/2/3/4");
            }
        }
    }


}

// MULAI DISNI
public class Main{
    private final static String password = "PBO04";

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
        while (true) {
            System.out.printf("%s\n","-".repeat(50));
            System.out.println("Welcome to Car shop\n1. Login as Owner\n2. Login as Consumer");
            int menu = (int) inputUser.inputUserAngka("= ");
            if (menu == 1 || menu == 2) {
                if (menu == 1) {
                    String log = inputUser.inputUserKosong("Please enter the password : ");
                    if (log.equals(password)) {
                        Car.owner();
                    }
                    else{
                        System.out.printf("%s\n","-".repeat(50));
                        System.out.println("Wrong password");
                    }
                }
                else if (menu == 2) {
                    Car.user();
                }
            }
            else{
                System.out.printf("%s\n","-".repeat(50));
                System.out.println("Please input 1 or 2");
            }
        }
    }
}