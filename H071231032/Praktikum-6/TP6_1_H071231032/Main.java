public class Main {
    public static void main(String[] args) {
        mainForDog();
        // mainForCar();
        // mainForSmartphone();
    }

    private static void mainForDog() {
        Dog roger = new Bulldog("Roger", 0);
        roger.describe();
        roger.barking();
        roger.getPosition();
        roger.move();
        roger.getPosition();

        Dog asep = new Pitbull("Asep", 19);
        asep.describe();
        asep.barking();

        Dog jamal = new SiberianHusky("Jamal", 10);
        jamal.describe();
        jamal.barking();

        Dog jony = new GermanShepherd("Jony", 5);
        jony.describe();
        jony.barking();
    }

    private static void mainForCar() {
        ToyotaSupra supra = new ToyotaSupra("Black");
        supra.detailCar();
        supra.upgradeEngine();
        supra.detailCar();
        supra.engineSound();
        supra.move();
    }

    private static void mainForSmartphone() {
        Smartphone smartphone = new Samsung(899);
        smartphone.phoneInfo();
        smartphone.move();
    }
}