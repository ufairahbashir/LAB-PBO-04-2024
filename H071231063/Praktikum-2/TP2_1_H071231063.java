import java.util.Scanner;
public class TP2_1_H071231063 {
    public int age;
    public String name;
    public boolean isMale;

    public TP2_1_H071231063(String name, int age, boolean isMale) {
        this.name=name;
        this.age=age;
        this.isMale=isMale;
    }

    public void setName(){
        this.name=name;
    }

    public void setage(){
        this.age= age;
    }

    public void setGender(){
        this.isMale=isMale;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        if (isMale) {
            return "Male";
        }else{
            return "Female";
        }
    }

    public static void main(String[] args) {
        Scanner Scanner=new Scanner(System.in);
        
        System.out.print("Masukkan nama= ");
        String name = Scanner.nextLine();
        
        System.out.print("Masukkan umur= ");
        int age = Scanner.nextInt();
        
        System.out.print("Masukkan gender(True= Male & False= Female)= ");
        boolean isMale = Scanner.nextBoolean();
        
        System.out.println("Biodata pengguna");
        TP2_1_H071231063 biodata= new TP2_1_H071231063(name, age, isMale);
        
        System.out.println("Nama= "+ biodata.getName());
        System.out.println("Umur= "+biodata.getAge());
        System.out.println("Gender= "+biodata.getGender());
    }
}
