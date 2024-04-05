public class TP3_2_H071231063 {
    String name;
    double speed, cash;
    int winningAmount;
    public TP3_2_H071231063(){
    }
    // TODO 1: Create a constructor according to your needs in Main.java
    public TP3_2_H071231063(String name, double speed, double cash){
        this.name=name;
        this.speed=speed;
        this.cash=cash;
        this.winningAmount=0;
    }

    public void showSpec() {
        // TODO 2: Call all the getter methods and print the output according to the format
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
            // Every Rp. 50,000 increase speed 1
            int increaseSpeed = budget / 50000;

            // TODO 3: Increase the speed of the car
            speed+= increaseSpeed;

            this.setCash(this.getCash() - budget + (budget % 50000));

            System.out.printf("Increases the speed of %s by %d...\n", this.getName(), increaseSpeed);
        }
    }

    public void raceTo(TP3_2_H071231063 enemy) {
        // TODO 4: Validate if the speed of this car is greater than the enemy's speed
        if (this.getSpeed() > enemy.getSpeed()) {
            // TODO 5: Increase the winning amount
            this.setWinningAmount(this.getWinningAmount()+1);

            // TODO 6: Increase the cash of this car by 40000
            this.setCash(this.getCash()+4000);


            // TODO 7: Call all the getter methods and print the output according to the format
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", this.getName(), this.getCash(), this.getWinningAmount());
        } else if (this.getSpeed() == enemy.getSpeed()) { // If the speed is equal
            System.out.printf("%s with %s are equally strong! The match ended in a draw...\n", this.getName(),
                    enemy.getName());
        } else { // If the speed of this car is less than the enemy's speed
            // TODO 8: Increase the winning amount of the enemy
            enemy.setWinningAmount(enemy.getWinningAmount()+1);

            // TODO 9: Increase the cash of the enemy by 40000
            enemy.setCash(enemy.getCash()+4000);

            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", enemy.getName(),
                    enemy.getName(), enemy.getWinningAmount());
        }
    }

    // TODO 10: Create getter and setter methods for all the attributes
    public void setName(String name){
        this.name=name;
    }
    public void setSpeed(double speed){
        this.speed=speed;
    }
    public void setCash(double cash){
        this.cash=cash;
    }
    public void setWinningAmount(int winningAmount){
        this.winningAmount=winningAmount;
    }
    public String getName(){
        return name;
    }
    public double getCash(){
        return cash;
    }
    public double getSpeed(){
        return speed;
    }
    public int getWinningAmount(){
        return winningAmount;
    }

    public static void main(String[] args) {
        TP3_2_H071231063 mercebesDenz = new TP3_2_H071231063("Mercebes-Denz", 4, 20000);

        TP3_2_H071231063 ferharri = new TP3_2_H071231063();
        ferharri.setName("Ferharri");
        ferharri.setSpeed(4);
        ferharri.setCash(50000);

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
    }

    public static void printBarriers() {
        System.out.println("================================");
    }
}