import java.util.Scanner;
class HotWheels {

    String name;
    double speed, cash;
    int winningAmount;

    public HotWheels(String name, double speed, double cash) {
        this.name = name;
        this.speed = speed;
        this.cash = cash;
        this.winningAmount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public void showSpec() {
        System.out.println("========== Specification ==========");
        System.out.println("Name : " + getName());
        System.out.println("Speed : " + getSpeed());
        System.out.println("Winning Amount : " + getWinningAmount());
        System.out.println("Cash : Rp. " + getCash() + "\n");
    }

    public void upgrade(int budget) {
        if (budget > this.getCash()) {
            System.out.printf("%s cannot be upgraded, not enough money...\n", this.getName());
        } else {

            int increaseSpeed = budget / 50000;
            speed += increaseSpeed;
            this.setCash(this.getCash() - budget + (budget % 50000));
            System.out.printf("Increases the speed of %s by %d...\n", this.getName(), increaseSpeed);
        }
    }

    public void raceTo(HotWheels enemy) {
        if (speed > enemy.speed) {
            this.setWinningAmount(getWinningAmount() + 1);
            this.setCash(this.getCash() + 40000);
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", getName(), enemy.getName(),
                    getWinningAmount());
        } else if (this.getSpeed() == enemy.getSpeed()) { // If the speed is equal
            System.out.printf("%s with %s are equally strong! The match ended in a draw...\n", this.getName(),
                    enemy.getName());
        } else {
            enemy.setWinningAmount(enemy.getWinningAmount() + 1);
            enemy.setCash(enemy.getCash() + 40000);
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", getName(), enemy.getName(),
                    getWinningAmount());
            enemy.setCash(enemy.getCash() + 40000);
        }
        System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n",
                enemy.getName(), enemy.getName(), enemy.getWinningAmount());
    }
}
public class TP3_2_H071231060  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            //mobil 1
            System.out.print("Masukkan nama mobil: ");
            String Nama1 = scan.nextLine();
            System.out.print("Masukkan speed: ");
            int Speed1 = scan.nextInt();
            scan.nextLine();
            System.out.print("Masukkan cash: ");
            int cash1 = scan.nextInt();
            //mobil 2
            System.out.print("Masukkan nama mobil: ");
            String Nama2 = scan.nextLine();
            scan.nextLine();
            System.out.print("Masukkan speed: ");
            int Speed2 = scan.nextInt();
            scan.nextLine();
            System.out.print("Masukkan cash: ");
            int cash2 = scan.nextInt();
    
            HotWheels mercebesDenz = new HotWheels(Nama1, Speed1, cash1);
            HotWheels ferharri = new HotWheels(null, 0, 0);
            ferharri.setName(Nama2);
            ferharri.setSpeed(Speed2);
            ferharri.setCash(cash2);
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
            scan.close();
            
        } catch (Exception e) {
           System.out.println("Tipe data tidak sesuai");
        }
        }
        public static void printBarriers() {
        System.out.println("================================");
    }
}