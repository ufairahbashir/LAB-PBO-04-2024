class Pet{
    String nama;
    String spesies;
    public Pet(String nama, String spesies){
        this.nama=nama;
        this.spesies=spesies;
    }

    public String getNama(){
        return nama;
    }
    
    public String getSpesies(){
        return spesies;
    }

    public void makeSound(){
        this.spesies=spesies.toLowerCase();
        if(this.spesies.equals("kucing")){
            System.out.println(nama+" mengeong\n");
        }else if(this.spesies.equals("burung")){
            System.out.println(nama+" berkicau\n");
        }else if(this.spesies.equals("ular")){
            System.out.println(nama+" berdesis\n");
        }else{
            System.out.println(nama+" membuat suara\n");
        }
    }

    public void eat(){
        this.spesies=spesies.toLowerCase();
        if(this.spesies.equals("kucing")){
            System.out.println(nama+" makan whiskas\n");
        }else if(this.spesies.equals("burung")){
            System.out.println(nama+" makan ular\n");
        }else if(this.spesies.equals("ular")){
            System.out.println(nama+" makan kucing\n");
        }else{
            System.out.println(nama+" makan makanan\n");
        }
    }

}
public class TP3_1_H071231063{
    String namaShop;
    String alamat;
    Pet[] pets;
    public TP3_1_H071231063(String namaShop, String alamat, Pet[] pets){
        this.namaShop= namaShop;
        this.alamat= alamat;
        this.pets=pets;
    }
    
    public void display(){
        System.out.println("==== Info Pet Shop "+ namaShop+" ====");
        System.out.println("Alamat: "+alamat);
        for(Pet pet:pets){
            System.out.println("Nama: "+ pet.getNama());
            System.out.println("Spesies: "+ pet.getSpesies());
        }
    }

    public void makeSoundPet(){
        System.out.println("Hewan peliharaan di "+ namaShop+ " lapar");
        for(Pet pet:pets){
            pet.makeSound();
        }
    }
    public void feed(){
        System.out.println("Hewan peliharaan di "+ namaShop + " senang");
        for(Pet pet:pets){
            pet.eat();;
        }
    }
    public static void main(String[] args) {
        String namaShop = "Eliya";
        String alamat = "Ahmad Dahlan No.23";

        Pet[] pets = new Pet[3];
        pets[0] = new Pet("Joy", "Kucing");
        pets[1] = new Pet("Ayi", "Burung");
        pets[2] = new Pet("Sai", "Ular");
        
        TP3_1_H071231063 myPetshop= new TP3_1_H071231063(namaShop, alamat, pets);
        myPetshop.display();
        myPetshop.feed();
        myPetshop.makeSoundPet();
    }
}