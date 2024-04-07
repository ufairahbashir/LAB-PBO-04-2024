import java.util.Scanner;

public class TP3_1_H071231032 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            // Ship 1
            System.out.print("\nMasukkan nama kapal 1: ");
            String japanShipName = sc.nextLine().toUpperCase();

            System.out.print("\nDaftar senjata:\n- RUDAL\n- SENAPAN MESIN\n- TORPEDO\nPilih jenis senjata: ");
            String japanWeaponName = sc.nextLine().toUpperCase();

            System.out.print("\nDaftar pelindung:\n- PLATINUM\n- BERLIAN\n- TITANIUM\nPilih jenis pelindung: ");
            String japanShieldName = sc.nextLine().toUpperCase();

            Weapon japanWeapon = new Weapon(japanWeaponName);
            Shield japanShield = new Shield(japanShieldName);

            Ship japanShip = new Ship(japanShipName, japanWeaponName, japanShieldName, japanWeapon, japanShield);
            japanShip.setWeaponShield();

            // Ship 2
            System.out.print("\nMasukkan nama kapal 2: ");
            String koreanShipName = sc.nextLine().toUpperCase();
            
            System.out.print("\nDaftar senjata:\n- RUDAL\n- SENAPAN MESIN\n- TORPEDO\nPilih jenis senjata: ");
            String koreanWeaponName = sc.nextLine().toUpperCase();
            
            System.out.print("\nDaftar pelindung:\n- PLATINUM\n- BERLIAN\n- TITANIUM\nPilih jenis pelindung: ");
            String koreanShieldName = sc.nextLine().toUpperCase();
            
            Weapon koreanWeapon = new Weapon(koreanWeaponName);
            Shield koreanShield = new Shield(koreanShieldName);
            
            Ship koreaShip = new Ship(koreanShipName, koreanWeaponName, koreanShieldName, koreanWeapon, koreanShield);
            koreaShip.setWeaponShield();
            
            // Before shoot
            System.out.println("\n" + "*".repeat(61));
            System.out.println(" ".repeat(19) + "Ship Data Before Battle" + " ".repeat(19));
            System.out.println("*".repeat(61));
            japanShip.shipData();
            koreaShip.shipData();
            System.out.println("*".repeat(61) + "\n");
            
            // Ship 1 shoot Ship 2
            japanShip.shoot(koreaShip);
            japanShip.shoot(koreaShip);
            japanShip.shoot(koreaShip);
            japanShip.shoot(koreaShip);
            japanShip.shoot(koreaShip);
            koreaShip.shoot(japanShip);
            japanShip.shoot(koreaShip);
            japanShip.shoot(koreaShip);
            japanShip.shoot(koreaShip);
            koreaShip.shoot(japanShip);
            
            // After shoot
            System.out.println("\n" + "*".repeat(61));
            System.out.println(" ".repeat(19) + "Ship Data After Battle" + " ".repeat(19));
            System.out.println("*".repeat(61));
            japanShip.shipData();
            koreaShip.shipData();
            System.out.println("*".repeat(61) + "\n");
        }
    }
}

class Ship {
    private String shipName, weaponName, shieldName;
    private int shipHealth = 1000, shipPower;
    Shield shield;
    Weapon weapon;

    // Constructor without parameter
    public Ship() {}

    // Constructor with parameter
    public Ship(String shipName, String weaponName, String shieldName, Weapon weapon, Shield shield) {
        this.shipName = shipName;
        this.weaponName = weaponName;
        this.shieldName = shieldName;
        this.weapon = weapon;
        this.shield = shield;
    }

    // Behavior set health and power
    public void setWeaponShield() {
        this.shipHealth += shield.getHealth();
        this.shipPower = weapon.getPower();
    }

    // Behavior shoot
    public void shoot(Ship target) {
        if (this.shipHealth <= 0) System.out.printf("Kapal %s tidak bisa menembak, karena telah hancur.\n",
            this.shipName);
        else {
            if (target.shipHealth <= 0) {
                System.out.printf("Kapal %s telah hancur.\n", target.shipName);
            } else {
                target.shipHealth -= this.shipPower;
                System.out.printf("Kapal %s telah menembak kapal %s menggunakan %s.\n",
                                this.shipName, target.shipName, this.weaponName);

                if (target.shipHealth <= 0) {
                    System.out.printf("Kapal %s telah dihancurkan oleh kapal %s.\n",
                                    target.shipName, this.shipName);
                    target.shipPower = 0;
                    target.shipHealth = 0;
                }
            }
        }
    }

    // Behavior ship data
    public void shipData() {
        System.out.println(
            "=".repeat(40) +
            "\nNama Kapal     : " + this.shipName +
            "\nNama Senjata   : " + this.weaponName +
            "\nNama Pelindung : " + this.shieldName +
            "\nDaya Tahan     : " + this.shipHealth +
            "\nDaya Hancur    : " + this.shipPower +
            "\n" + "=".repeat(40)
        );
    }

    // getter & setter ship name
    public String getShipName() {
        return this.shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    
    // getter & setter shield name
    public String getShieldName() {
        return this.shieldName;
    }

    public void setShieldName(String shieldName) {
        this.shieldName = shieldName;
    }

    // getter & setter weapon name
    public String getWeaponName() {
        return this.weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    // getter ship health
    public int getShipHealth(Shield shield) {
        return this.shipHealth + shield.getHealth();
    }

    // getter ship power
    public int getShipPower(Weapon weapon) {
        return weapon.getPower();
    }

    // set Shield
    public void setShield(Shield shield) {
        this.shield = shield;
    }

    // set Weapon
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

class Weapon {
    private String weaponName;

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getPower() {
        if (this.weaponName.equals("RUDAL")) return 100;
        else if (this.weaponName.equals("SENAPAN MESIN")) return 45;
        else if (this.weaponName.equals("TORPEDO")) return 150;
        else { System.out.println("Senjata tidak tersedia."); return 0; }
    }
}

class Shield {
    private String shieldName;

    public Shield(String shieldName) {
        this.shieldName = shieldName;
    }
    
    public int getHealth() {
        if (shieldName.equals("PLATINUM")) return 350;
        else if (shieldName.equals("BERLIAN")) return 450;
        else if (shieldName.equals("TITANIUM")) return 600;
        else { System.out.println("Pelindung tidak tersedia."); return 0; }
    }
}