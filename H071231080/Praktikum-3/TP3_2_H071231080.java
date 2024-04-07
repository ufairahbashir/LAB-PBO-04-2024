import java.util.Scanner;

class HotWheels {
    String name;
    double speed;
    double cash;
    int winningAmount;

    //TODO1
    public HotWheels(){};

    public HotWheels(String name, double speed, double cash, int winningAmount){
        this.name = name;
        this.speed = speed;
        this.cash = cash;
        this.winningAmount = winningAmount;
    }
    
    public void showSpec() {
    //TODO2
        System.out.println("========== Specification ==========");
        System.out.println("Name            : " + this.name);
        System.out.println("Speed           : " + this.speed);
        System.out.println("Winning Amount  : " + this.winningAmount);
        System.out.println("Cash            : Rp. " + this.cash + "\n");
    }

    public void upgrade(int budget) {
        if (budget > this.getCash()) {
            System.out.printf("%s cannot be upgraded, not enough money...\n", this.getName());

        } else {
            // Every Rp. 50,000 increase speed 1
            //TODO3
            int increaseSpeed = budget / 50000;
            this.setSpeed(this.getSpeed() + increaseSpeed);
            this.setCash(this.getCash() - budget + (budget % 50000));
            System.out.printf("Increases the speed of %s by %d...\n", this.getName(), increaseSpeed);
        }
    }

    public void raceTo(HotWheels enemy) {
        //TODO4
        if (this.getSpeed() > enemy.getSpeed()) {
        //TODO5
        //TODO6
            this.setWinningAmount(this.getWinningAmount() + 1);
            this.setCash(this.getCash() + 40000);

        //TODO7
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", this.getName(), this.getName(), this.getWinningAmount());

        } else if (this.getSpeed() == enemy.getSpeed()) { // If the speed is equal
            System.out.printf("%s with %s are equally strong! The match ended in a draw...\n", this.getName(),
                    enemy.getName());
        //TODO8
        } else {
            enemy.setWinningAmount(enemy.getWinningAmount() + 1);
            enemy.setCash(enemy.getCash() + 40000);

        //TODO9 
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", enemy.getName(),
                    enemy.getName(), enemy.getWinningAmount());
        }

    }
        //TODO10
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return speed;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    public double getCash() {
        return cash;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }
    public int getWinningAmount() {
        return winningAmount;
    }
        
}

public class TP3_2_H071231080{
    public static void main(String[] args) {
        HotWheels mercebesDenz = new HotWheels("Mercebes-Denz", 4, 20000,0);

        Scanner scanner = new Scanner(System.in);

        HotWheels ferharri = new HotWheels();

        System.out.println("Masukkan Nama Kendaraan: ");
        String name = scanner.nextLine();
        ferharri.setName(name);

        System.out.println("Masukkan Speed : ");
        int speed = scanner.nextInt();
        ferharri.setSpeed(speed);

        System.out.println("Masukkan Uang : ");
        int cash = scanner.nextInt();
        ferharri.setCash(cash);
   

        System.out.println();
        mercebesDenz.showSpec();
        ferharri.showSpec();

        printBarriers();
        mercebesDenz.upgrade(50000);
        printBarriers();
        ferharri.upgrade(50000);
        printBarriers();

        System.out.println();
        ferharri.showSpec();

        printBarriers();
        ferharri.raceTo(mercebesDenz);
        printBarriers();
        mercebesDenz.raceTo(ferharri);
        printBarriers();

        System.out.println();
        mercebesDenz.showSpec();
        ferharri.showSpec();

        scanner.close();
    }

    public static void printBarriers() {
        System.out.println("================================");
    }
}
