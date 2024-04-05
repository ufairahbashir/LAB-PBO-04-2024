import java.util.Scanner;

class HotWheels {
    String name;
    double speed, cash;
    int winningAmount;

    public HotWheels(String name, double speed, double cash) {
        this.name = name;
        this.speed = speed;
        this.cash = cash;
    }

    public void showSpec() {
        System.out.println("========== Specification ==========");
        System.out.println("Name            : " + getName());
        System.out.println("Speed           : " + getSpeed());
        System.out.println("Winning Amount  : " + getWinningAmount());
        System.out.println("Cash            : Rp. " + getCash() + "\n");
    }

    public void upgrade(int budget) {
        if (budget > this.getCash()) {
            System.out.printf("%s cannot be upgraded, not enough money...\n", this.getName());
        } else {
            int increaseSpeed = budget / 50000;
            this.setSpeed(this.getSpeed() + increaseSpeed);
            this.setCash(this.getCash() - budget + (budget % 50000));
            System.out.printf("Increases the speed of %s by %d...\n", this.getName(), increaseSpeed);
        }
    }

    public void raceTo(HotWheels enemy) {
        if (getSpeed() > enemy.getSpeed()) {
            this.setWinningAmount(getWinningAmount() + 1);
            this.setCash(this.getCash() + 40000);
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", this.getName(),
                    this.getName(), this.getWinningAmount());
        } else if (this.getSpeed() == enemy.getSpeed()) { // If the speed is equal
            System.out.printf("%s with %s are equally strong! The match ended in a draw...\n", this.getName(),
                    enemy.getName());
        } else {
            enemy.setWinningAmount(enemy.getWinningAmount() + 1);
            enemy.setCash(enemy.getCash() + 40000);
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", enemy.getName(),
                    enemy.getName(), enemy.getWinningAmount());
        }
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
}

public class TP3_2_H071231079 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan Nama Mobil 1  : ");
            String nama1 = input.nextLine();
            System.out.print("Masukkan Speed Mobil 1 : ");
            double speed1 = input.nextDouble();
            System.out.print("Masukkan Cash 1        : ");
            double cash1 = input.nextDouble();

            input.nextLine();

            System.out.print("Masukkan Nama Mobil 2  : ");
            String nama2 = input.nextLine();
            System.out.print("Masukkan Speed Mobil 2 : ");
            double speed2 = input.nextDouble();
            System.out.print("Masukkan Cash 2        : ");
            double cash2 = input.nextDouble();

            HotWheels mercebesDenz = new HotWheels(nama1, speed1, cash1);

            HotWheels ferharri = new HotWheels(null, 0, 0);
            ferharri.setName(nama2);
            ferharri.setSpeed(speed2);
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
        } catch (Exception e) {
            System.out.println("Inputan tidak valid.");
        } finally {
            input.close();
        }
    }

    public static void printBarriers() {
        System.out.println("================================");
    }
}