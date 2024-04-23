import java.util.Scanner;
class Bambang{
    int serangan;
    int energi;
    int nyawa;

    Bambang(int serangan, int energi, int nyawa){
        this.serangan = serangan;
        this.energi = energi;
        this.nyawa = nyawa;
    }
    void Menyerang(){
        if (energi >= serangan){
            System.out.println("Bambang menyerang dengan damage sebesar" + serangan);
            energi -= serangan;
        }else {
            System.out.println("Energi bambang tidak cukup");
        }

    }

    void Terkuras(){
        
        System.out.println("Energi bambang terkuras sebanyak" + serangan);

    }

    void Live (){ 
        System.out.println("Nyawa bambang berkurang sebesar " + nyawa );
    }

    int getNyawa() {
        return nyawa;

    }

    int getEnergi(){
        return energi;
    }


}



class Robby{
    int attack;
    int energy;
    int health;
   

    Robby(int attack, int energy, int health){
        this.attack= attack;
        this.energy= energy;
        this.health = health;
    }
    void robbyMenyerang (Bambang bambang){
        if (energy >= attack){
            System.out.println("Robby menyerang bambang dengan kekuatan "  + attack);
            energy -= attack;
            bambang.nyawa -= attack;
            bambang.Menyerang();
            health -= bambang.serangan;
        }else {
            System.out.println("Energi Robby tidak cukup");
        }
        
    }
    int getHealth(){
        return health;
        
    }
}


public class No1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan serangan bambang: ");
        int seranganBambang = input.nextInt();

        System.out.println("Masukan energi bambang: ");
        int energiBambang = input.nextInt();
        
        System.out.println("Masukan nyawa bambang: ");
        int nyawaBambang = input.nextInt();


        System.out.println("Masukan serangan robby: ");
        int seranganRobby = input.nextInt();

        System.out.println("Masukan nyawa robby: ");
        int darahRobby = input.nextInt();

        System.out.println("Masukkan energi robby: ");
        int energiRobby = input.nextInt();



        Bambang bambang = new Bambang(seranganBambang, energiBambang, nyawaBambang);
        Robby robby = new Robby(seranganRobby, energiRobby, darahRobby);

        while (bambang.getNyawa() > 0 && robby.getHealth() > 0) {
            
            bambang.Menyerang();
            robby.robbyMenyerang(bambang);
            System.out.println("Nyawa bambang setelah diserang robby " + bambang.getNyawa());
            System.out.println("Nyawa robby setelah diserang bambang " + robby.getHealth());

         }   
        if (bambang.getNyawa() <= 0){
            System.out.println("bambang kalah!");
        } else {
            System.out.println("Robby kalah!");
        }
            input.close();
        
    }
    
}
